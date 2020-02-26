package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class FinishSurvey extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);
    }
    public void enterNext(View view){
        Intent intent=new Intent();
        intent.setClass(this,SvyReports.class);
        startActivity(intent);
    }
}
