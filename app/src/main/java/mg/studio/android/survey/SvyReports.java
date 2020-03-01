package mg.studio.android.survey;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONObject;

public class SvyReports extends Activity {
    Data app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        app=(Data)getApplication();
//        String []res=app.getReports();
//        JSONObject jsonObj=app.getReports();
        ((TextView)findViewById(R.id.ans_1)).setText(app.getAnswer(getResources().getString(R.string.ques_1)));
        ((TextView)findViewById(R.id.ans_2)).setText(app.getAnswer(getResources().getString(R.string.ques_2)));
        ((TextView)findViewById(R.id.ans_3)).setText(app.getAnswer(getResources().getString(R.string.ques_3)));
        ((TextView)findViewById(R.id.ans_4)).setText(app.getAnswer(getResources().getString(R.string.ques_4)));
        ((TextView)findViewById(R.id.ans_5)).setText(app.getAnswer(getResources().getString(R.string.ques_5)));
        ((TextView)findViewById(R.id.ans_6)).setText(app.getAnswer(getResources().getString(R.string.ques_6)));
        ((TextView)findViewById(R.id.ans_7)).setText(app.getAnswer(getResources().getString(R.string.ques_7)));
        ((TextView)findViewById(R.id.ans_8)).setText(app.getAnswer(getResources().getString(R.string.ques_8)));
        ((TextView)findViewById(R.id.ans_9)).setText(app.getAnswer(getResources().getString(R.string.ques_9)));
        ((TextView)findViewById(R.id.ans_10)).setText(app.getAnswer(getResources().getString(R.string.ques_10)));
        ((TextView)findViewById(R.id.ans_11)).setText(app.getAnswer(getResources().getString(R.string.ques_11)));
        ((TextView)findViewById(R.id.ans_12)).setText(app.getAnswer(getResources().getString(R.string.ques_12)));

    }
}
