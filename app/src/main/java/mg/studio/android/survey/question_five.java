package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class question_five extends AppCompatActivity {

    public static String answer;

    private CheckBox rgp5_1;
    private CheckBox rgp5_2;
    private CheckBox rgp5_3;
    private CheckBox rgp5_4;
    private CheckBox rgp5_5;
    private CheckBox rgp5_6;
    private CheckBox rgp5_7;

    private String rgp5_string="Null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);
        rgp5_1=(CheckBox)findViewById(R.id.rbtn1);
        rgp5_2=(CheckBox)findViewById(R.id.rbtn2);
        rgp5_3=(CheckBox)findViewById(R.id.rbtn3);
        rgp5_4=(CheckBox)findViewById(R.id.rbtn4);
        rgp5_5=(CheckBox)findViewById(R.id.rbtn5);
        rgp5_6=(CheckBox)findViewById(R.id.rbtn6);
        rgp5_7=(CheckBox)findViewById(R.id.rbtn7);

    }

    public void next5(View view){

        if(rgp5_1.isChecked()){
            rgp5_string=rgp5_1.getText().toString().trim();
        }
        if(rgp5_2.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_2.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_2.getText().toString().trim();
            }
        }
        if(rgp5_3.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_3.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_3.getText().toString().trim();
            }
        }
        if(rgp5_4.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_4.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_4.getText().toString().trim();
            }
        }
        if(rgp5_5.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_5.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_5.getText().toString().trim();
            }
        }
        if(rgp5_6.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_6.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_6.getText().toString().trim();
            }
        }
        if(rgp5_7.isChecked()){
            if(rgp5_string=="Null"){
                rgp5_string=rgp5_7.getText().toString().trim();
            }
            else {
                rgp5_string=rgp5_string+" , "+rgp5_7.getText().toString().trim();
            }
        }

        answer=rgp5_string;

        if(rgp5_string!="Null") {
            Intent intent5 = new Intent(this,question_six.class);
            startActivity(intent5);
        }else{
            Toast.makeText(question_five.this,"Please select at least one option.",Toast.LENGTH_SHORT).show();
        }


    }
}
