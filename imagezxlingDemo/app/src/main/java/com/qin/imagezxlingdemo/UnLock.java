package com.qin.imagezxlingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class UnLock extends Activity implements View.OnClickListener, UnlockView.OnCompleteListener {

    private TextView mExplainTv;
    private Button mConfirmBtn;
    private UnlockView mPwdView;

    //private String UnLockPassword;
    int clicknum = 0;
    //private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_lock);
        initViews();
    }

    private void initViews() {
        mExplainTv = (TextView) findViewById(R.id.tv_explain_unlock);
        mConfirmBtn = (Button) findViewById(R.id.btn_confirm_unlock);
        mPwdView = (UnlockView) findViewById(R.id.mPassWordView_unlock);

        mConfirmBtn.setOnClickListener(this);
        mPwdView.setOnCompleteListener(this);
        initChoose();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm_unlock:
                confirm();
                break;
        }
    }

    private void confirm() {
        if (mPwdView.getFirstPassword().equals(MainActivity.againPassword)) {
            if(clicknum == 0) {
                onPrompt("解锁成功");
                mPwdView.disableTouch();
                mConfirmBtn.setText("退出");
                //Toast.makeText(UnLock.this, "success", Toast.LENGTH_SHORT).show();
                clicknum += 1;
            }else{
                onPrompt("成功退出");
                Toast.makeText(UnLock.this, "成功退出", Toast.LENGTH_SHORT).show();
            }
        } else {
            onPrompt("密码错误，请重试");
            //Toast.makeText(UnLock.this, "try again", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onComplete(String password) {
        firstChoose(password);
    }

    @Override
    public void onPrompt(String prompt) {
        mExplainTv.setText(prompt);
    }

    private void initChoose() {
        mPwdView.setFirstPassword("");
        mConfirmBtn.setVisibility(View.GONE);
    }

    private void firstChoose(String password) {
        mPwdView.setFirstPassword(password);
        mPwdView.clearPassword(0);
        mConfirmBtn.setEnabled(true);
        mConfirmBtn.setVisibility(View.VISIBLE);
    }
}

