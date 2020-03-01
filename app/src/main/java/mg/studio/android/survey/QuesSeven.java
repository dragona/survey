package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class QuesSeven extends Activity {
    Data app;
    RadioGroup radio_group;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_seven);
        app=(Data)getApplication();
        radio_group=findViewById(R.id.rg);
    }
    public void enterNext(View view){
        try{
            RadioButton checked_btn=findViewById(radio_group.getCheckedRadioButtonId());
            String checked_val=checked_btn.getText().toString();
            app.setReports(6,getResources().getString(R.string.ques_7),checked_val);
            Intent intent=new Intent();
            intent.setClass(this,QuesEight.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(QuesSeven.this,"please choose an answer first!",Toast.LENGTH_SHORT).show();
        }
    }
}
