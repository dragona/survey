package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuesFour extends Activity {
    List<CheckBox> boxes=new ArrayList<CheckBox>();
    Data app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
        app=(Data)getApplication();
        CheckBox check_1=findViewById(R.id.checkBox1);
        CheckBox check_2=findViewById(R.id.checkBox2);
        CheckBox check_3=findViewById(R.id.checkBox3);
        CheckBox check_4=findViewById(R.id.checkBox4);
        CheckBox check_5=findViewById(R.id.checkBox5);
        CheckBox check_6=findViewById(R.id.checkBox6);
        CheckBox check_7=findViewById(R.id.checkBox7);
        boxes.add(check_1);
        boxes.add(check_2);
        boxes.add(check_3);
        boxes.add(check_4);
        boxes.add(check_5);
        boxes.add(check_6);
        boxes.add(check_7);
    }
    public void enterNext(View view){
        String tmp="";
        for(int i=0;i<boxes.size();++i){
            if(boxes.get(i).isChecked()){
                tmp+=boxes.get(i).getText()+" . ";
            }
        }
        if(tmp == null || tmp.length() <= 0){
            Toast.makeText(QuesFour.this,"please at least choose one option!",Toast.LENGTH_SHORT).show();
        }else{
            app.setReports(3,tmp);
            Intent intent=new Intent();
            intent.setClass(this,QuesFive.class);
            startActivity(intent);
        }
    }
}
