package com.qin.imagezxlingdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class UnlockView extends View {
    /**
     * 控件的宽高
     */
    private float width = 0;
    private float height = 0;

    private boolean isCache = false; //缓存pwdMaxLen个点
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private Point[][] mPoints = new Point[3][3];
    private float dotRadius = 0;

    //选择>pwdMinLen的点
    private List<Point> sPoints = new ArrayList<Point>();

    private boolean checking = false;
    private long CLEAR_TIME = 1000;
    private int pwdMaxLen = 9;
    private int pwdMinLen = 4;
    private boolean isTouch = true;

    private Paint linePaint;
    private Paint normalPaint;
    private Paint selectedPaint;
    private Paint errorPaint;

    private int normalDotColor = 0xff929292;
    private int selectedColor = 0xffC3C3C3;
    private int selectedLineColor = 0xffEDEDED;
    private int errorColor = 0xffF34B2A;
    private int errorLineColor = 0xffEEBFB6;
    public UnlockView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public UnlockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UnlockView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureDimension(200, widthMeasureSpec);
        int height = measureDimension(200, heightMeasureSpec);
        if (width > height) {
            setMeasuredDimension(height, height);
        } else {
            setMeasuredDimension(width, width);
        }
    }

    public int measureDimension(int defaultSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultSize;   //UNSPECIFIED
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (!isCache) {
            initCache();
        }
        drawToCanvas(canvas);
    }

    private void drawToCanvas(Canvas canvas) {
        boolean inErrorState = false;
        float radiu = dotRadius / 16; //圆的半径
        //画点
        for (int i = 0; i < mPoints.length; i++) {
            for (int j = 0; j < mPoints[i].length; j++) {
                Point p = mPoints[i][j];
                if (p.state == Point.STATE_CHECK) {
                    selectedPaint.setColor(selectedColor);
                    canvas.drawCircle(p.x, p.y, radiu, selectedPaint);
                } else if (p.state == Point.STATE_CHECK_ERROR) {
                    inErrorState = true;
                    errorPaint.setColor(errorColor);
                    canvas.drawCircle(p.x, p.y, radiu, errorPaint);
                } else {
                    normalPaint.setColor(normalDotColor);
                    canvas.drawCircle(p.x, p.y, radiu, normalPaint);
                }
            }
        }

        if (inErrorState) {
            linePaint.setColor(errorLineColor);
        } else {
            linePaint.setColor(selectedLineColor);
        }

        //画线
        if (sPoints.size() > 0) {
            int tmpAlpha = mPaint.getAlpha();
            Point tp = sPoints.get(0);
            for (int i = 1; i < sPoints.size(); i++) {
                Point p = sPoints.get(i);
                drawLine(tp, p, canvas, linePaint);
                tp = p;
            }
            if (this.movingNoPoint) {
                drawLine(tp, new Point(moveingX, moveingY, -1), canvas, linePaint);
            }
            mPaint.setAlpha(tmpAlpha);
        }
    }

    /**
     * 画线
     * @param start
     * @param end
     * @param canvas
     * @param paint
     */
    private void drawLine(Point start, Point end, Canvas canvas, Paint paint) {
        float radiu = dotRadius / 16; //圆的半径
        double d = MathUtil.distance(start.x, start.y, end.x, end.y);
        float rx = (float) ((end.x - start.x) * radiu / d);
        float ry = (float) ((end.y - start.y) * radiu / d);
        canvas.drawLine(start.x + rx, start.y + ry, end.x - rx, end.y - ry, paint);
    }

    /**
     * 缓存控件宽高跟点个位置
     */
    private void initCache() {
        width = this.getWidth();
        height = this.getHeight();
        float x = 0;
        float y = 0;

        if (width > height) {
            x = (width - height) / 2;
            width = height;
        } else {
            y = (height - width) / 2;
            height = width;
        }

        int leftPadding = 15;
        float dotPadding = width / 3 - leftPadding;
        float middleX = width / 2;
        float middleY = height / 2;

        mPoints[0][0] = new Point(x + middleX - dotPadding, y + middleY - dotPadding, 1);
        mPoints[0][1] = new Point(x + middleX, y + middleY - dotPadding, 2);
        mPoints[0][2] = new Point(x + middleX + dotPadding, y + middleY - dotPadding, 3);
        mPoints[1][0] = new Point(x + middleX - dotPadding, y + middleY, 4);
        mPoints[1][1] = new Point(x + middleX, y + middleY, 5);
        mPoints[1][2] = new Point(x + middleX + dotPadding, y + middleY, 6);
        mPoints[2][0] = new Point(x + middleX - dotPadding, y + middleY + dotPadding, 7);
        mPoints[2][1] = new Point(x + middleX, y + middleY + dotPadding, 8);
        mPoints[2][2] = new Point(x + middleX + dotPadding, y + middleY + dotPadding, 9);

        Log.d("jerome", "canvas width:" + width);
        dotRadius = width / 10;
        isCache = true;

        initPaints();
    }

    private void initPaints() {
        linePaint = new Paint();
        linePaint.setColor(selectedColor);
        linePaint.setStyle(Style.FILL);
        linePaint.setAntiAlias(true);
        linePaint.setStrokeWidth(dotRadius / 9);

        selectedPaint = new Paint();
        selectedPaint.setStyle(Style.FILL);
        selectedPaint.setAntiAlias(true);
        selectedPaint.setStrokeWidth(dotRadius / 6);

        errorPaint = new Paint();
        errorPaint.setStyle(Style.FILL);
        errorPaint.setAntiAlias(true);
        errorPaint.setStrokeWidth(dotRadius / 6);

        normalPaint = new Paint();
        normalPaint.setStyle(Style.FILL);
        normalPaint.setAntiAlias(true);
        normalPaint.setStrokeWidth(dotRadius / 9);
    }

    /**
     * 检查
     *
     * @param x
     * @param y
     * @return
     */
    private Point checkSelectPoint(float x, float y) {
        for (int i = 0; i < mPoints.length; i++) {
            for (int j = 0; j < mPoints[i].length; j++) {
                Point p = mPoints[i][j];
                if (MathUtil.checkInRound(p.x, p.y, dotRadius, (int) x, (int) y)) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * 重置
     */
    private void reset() {
        for (Point p : sPoints) {
            p.state = Point.STATE_NORMAL;
        }
        sPoints.clear();
        this.enableTouch();
    }

    /**
     * 判断点是否有交叉 返回 0,新点 ,1 与上一点重叠 2,与非最后一点重叠
     *
     * @param p
     * @return
     */
    private int crossPoint(Point p) {
        // 重叠的不最后一个则 reset
        if (sPoints.contains(p)) {
            if (sPoints.size() > 2) {
                // 与非最后一点重叠
                if (sPoints.get(sPoints.size() - 1).index != p.index) {
                    return 2;
                }
            }
            return 1; // 与最后一点重叠
        } else {
            return 0; // 新点
        }
    }

    /**
     * 添加一个点
     *
     * @param point
     */
    private void addPoint(Point point) {
        if (sPoints.size() > 0) {
            Point lastPoint = sPoints.get(sPoints.size() - 1);
            int dx = Math.abs(lastPoint.getColNum() - point.getColNum());
            int dy = Math.abs(lastPoint.getRowNum() - point.getRowNum());
            if ((dx > 1 || dy > 1) && (dx == 0 || dy == 0 || dx == dy)) {
//          if ((dx > 1 || dy > 1) && (dx != 2 * dy) && (dy != 2 * dx)) {
                int middleIndex = (point.index + lastPoint.index) / 2 - 1;
                Point middlePoint = mPoints[middleIndex / 3][middleIndex % 3];
                if (middlePoint.state != Point.STATE_CHECK) {
                    middlePoint.state = Point.STATE_CHECK;
                    sPoints.add(middlePoint);
                }
            }
        }
        this.sPoints.add(point);
    }

    /**
     * 转换为String
     */
    private String toPointString() {
        if (sPoints.size() >= pwdMinLen && sPoints.size() <= pwdMaxLen) {
            StringBuffer sf = new StringBuffer();
            for (Point p : sPoints) {
                sf.append(p.index);
            }
            return sf.toString();
        } else {
            return "";
        }
    }

    boolean movingNoPoint = false;
    float moveingX, moveingY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 不可操作
        if (!isTouch) {
            return false;
        }

        movingNoPoint = false;

        float ex = event.getX();
        float ey = event.getY();
        boolean isFinish = false;
        boolean redraw = false;
        Point p = null;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //点下
                // 如果正在清除密码,则取消
                if (task != null) {
                    task.cancel();
                    task = null;
                    Log.d("task", "touch cancel()");
                }
                // 删除之前的点
                reset();
                p = checkSelectPoint(ex, ey);
                if (p != null) {
                    checking = true;
                }
                mCompleteListener.onPrompt("完成后松开手指");
                break;
            case MotionEvent.ACTION_MOVE:// 移动
                if (checking) {
                    p = checkSelectPoint(ex, ey);
                    if (p == null) {
                        movingNoPoint = true;
                        moveingX = ex;
                        moveingY = ey;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:// 提起
                p = checkSelectPoint(ex, ey);
                checking = false;
                isFinish = true;
                break;
        }
        if (!isFinish && checking && p != null) {

            int rk = crossPoint(p);
            if (rk == 2) {// 与非最后一重叠
                // reset();
                // checking = false;
                movingNoPoint = true;
                moveingX = ex;
                moveingY = ey;

                redraw = true;
            } else if (rk == 0) {// 一个新点
                p.state = Point.STATE_CHECK;
                addPoint(p);
                redraw = true;
            }
            // rk == 1
        }

        // 是否重画
        if (redraw) {

        }
        if (isFinish) {
            if (this.sPoints.size() == 1) {
                this.reset();
                isFirstPwdEmpty();
            } else if (sPoints.size() > 0 && sPoints.size() < pwdMinLen) {
                error();
                clearPassword();
                isFirstPwdEmpty();
            } else if (mCompleteListener != null) {
                if (this.sPoints.size() >= pwdMinLen) {
                    this.disableTouch();
                    mCompleteListener.onPrompt("点击确认验证密码");
                    mCompleteListener.onComplete(toPointString());
                }
            }
        }
        this.postInvalidate();
        return true;
    }

    private void isFirstPwdEmpty() {
        if (TextUtils.isEmpty(firstPassword)) {
            mCompleteListener.onPrompt("至少需连接4个点，请重试。");
        } else {
            mCompleteListener.onPrompt("请重试");
        }
    }


    /**
     * 设置已经选中的为错误
     */
    private void error() {
        for (Point p : sPoints) {
            p.state = Point.STATE_CHECK_ERROR;
        }
    }

    /**
     * 设置为输入错误
     */
    public void markError() {
        markError(CLEAR_TIME);
    }

    /**
     * 设置为输入错误
     */
    public void markError(final long time) {
        for (Point p : sPoints) {
            p.state = Point.STATE_CHECK_ERROR;
        }
        this.clearPassword(time);
    }

    /**
     * 设置为可操作
     */
    public void enableTouch() {
        isTouch = true;
    }

    /**
     * 设置为不可操作
     */
    public void disableTouch() {
        isTouch = false;
    }

    private Timer timer = new Timer();
    private TimerTask task = null;

    /**
     * 清除密码
     */
    public void clearPassword() {
        clearPassword(CLEAR_TIME);
    }

    /**
     * 清除密码
     */

    public void clearPassword(final long time) {
        if (time > 1) {
            if (task != null) {
                task.cancel();
                Log.d("task", "clearPassword cancel()");
            }
            postInvalidate();
            task = new TimerTask() {
                public void run() {
                    reset();
                    postInvalidate();
                }
            };
            Log.d("task", "clearPassword schedule(" + time + ")");
            timer.schedule(task, time);
        } else {
            reset();
            postInvalidate();
        }
    }

    private String firstPassword;

    public String getFirstPassword() {
        return firstPassword;
    }

    public void setFirstPassword(String firstPassword) {
        this.firstPassword = firstPassword;
    }

    private OnCompleteListener mCompleteListener;

    public void setOnCompleteListener(OnCompleteListener mCompleteListener) {
        this.mCompleteListener = mCompleteListener;
    }

    public interface OnCompleteListener {
        void onComplete(String password);  //密码

        void onPrompt(String prompt); //提示信息
    }
}
