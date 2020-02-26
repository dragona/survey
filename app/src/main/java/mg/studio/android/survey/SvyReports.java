package mg.studio.android.survey;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SvyReports extends Activity {
    Data app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        app=(Data)getApplication();
        String []res=app.getReports();
        ((TextView)findViewById(R.id.ans_1)).setText(res[0]);
        ((TextView)findViewById(R.id.ans_2)).setText(res[1]);
        ((TextView)findViewById(R.id.ans_3)).setText(res[2]);
        ((TextView)findViewById(R.id.ans_4)).setText(res[3]);
        ((TextView)findViewById(R.id.ans_5)).setText(res[4]);
        ((TextView)findViewById(R.id.ans_6)).setText(res[5]);
        ((TextView)findViewById(R.id.ans_7)).setText(res[6]);
        ((TextView)findViewById(R.id.ans_8)).setText(res[7]);
        ((TextView)findViewById(R.id.ans_9)).setText(res[8]);
        ((TextView)findViewById(R.id.ans_10)).setText(res[9]);
        ((TextView)findViewById(R.id.ans_11)).setText(res[10]);
        ((TextView)findViewById(R.id.ans_12)).setText(res[11]);

    }
}
