package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class QuesOne extends Activity {
    RadioGroup radio_group;
    Data app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);
        radio_group=findViewById(R.id.rg);
        app=(Data)getApplication();
    }
    public void enterNext(View v){
        //get the answers
        try{
            RadioButton checked_btn=findViewById(radio_group.getCheckedRadioButtonId());
            String checked_val=checked_btn.getText().toString();
            app.setReports(0,getResources().getString(R.string.ques_1),checked_val);
//            app.jsonObj.put("oo","ss");
            Intent intent=new Intent();
            intent.setClass(this,QuesTwo.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(QuesOne.this,"please choose an answer first!",Toast.LENGTH_SHORT).show();
        }

    }
}
