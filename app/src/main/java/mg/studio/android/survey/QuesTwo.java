package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Arrays;

public class QuesTwo extends Activity {
    Data app;
    RadioGroup radio_group;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);
        app=(Data)getApplication();
        radio_group=findViewById(R.id.rg);
    }
    public void enterNext(View v){
        try{
            RadioButton checked_btn=findViewById(radio_group.getCheckedRadioButtonId());
            String checked_val=checked_btn.getText().toString();
            app.setReports(1,checked_val);
            System.out.println("report: "+ Arrays.toString(app.getReports()));
            Intent intent=new Intent();
            intent.setClass(this,QuesThree.class);
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(QuesTwo.this,"please choose an answer first!",Toast.LENGTH_SHORT).show();
        }
    }
}
