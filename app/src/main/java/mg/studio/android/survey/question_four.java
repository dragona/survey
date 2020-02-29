package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class question_four extends AppCompatActivity {

    public static String answer;

    private CheckBox rgp4_1;
    private CheckBox rgp4_2;
    private CheckBox rgp4_3;
    private CheckBox rgp4_4;
    private CheckBox rgp4_5;
    private CheckBox rgp4_6;
    private CheckBox rgp4_7;

    private String rgp4_string="Null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
        rgp4_1=(CheckBox)findViewById(R.id.rbtn1);
        rgp4_2=(CheckBox)findViewById(R.id.rbtn2);
        rgp4_3=(CheckBox)findViewById(R.id.rbtn3);
        rgp4_4=(CheckBox)findViewById(R.id.rbtn4);
        rgp4_5=(CheckBox)findViewById(R.id.rbtn5);
        rgp4_6=(CheckBox)findViewById(R.id.rbtn6);
        rgp4_7=(CheckBox)findViewById(R.id.rbtn7);


    }

    public void next4(View view){

        if(rgp4_1.isChecked()){
            rgp4_string=rgp4_1.getText().toString().trim();
        }

        if(rgp4_2.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_2.getText().toString().trim();
            }
        else {
            rgp4_string=rgp4_string+" , "+rgp4_2.getText().toString().trim();
            }
        }

        if(rgp4_3.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_3.getText().toString().trim();
            }
            else {
                rgp4_string=rgp4_string+" , "+rgp4_3.getText().toString().trim();
            }
        }

        if(rgp4_4.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_4.getText().toString().trim();
            }
            else {
                rgp4_string=rgp4_string+" , "+rgp4_4.getText().toString().trim();
            }
        }

        if(rgp4_5.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_5.getText().toString().trim();
            }
            else {
                rgp4_string=rgp4_string+" , "+rgp4_5.getText().toString().trim();
            }
        }

        if(rgp4_6.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_6.getText().toString().trim();
            }
            else {
                rgp4_string=rgp4_string+" , "+rgp4_6.getText().toString().trim();
            }
        }

        if(rgp4_7.isChecked()){
            if(rgp4_string=="Null"){
                rgp4_string=rgp4_7.getText().toString().trim();
            }
            else {
                rgp4_string=rgp4_string+" , "+rgp4_7.getText().toString().trim();
            }
        }

        answer=rgp4_string;

        if(rgp4_string!="Null") {
            Intent intent4 = new Intent(this,question_five.class);
            startActivity(intent4);
        }else{
            Toast.makeText(question_four.this,"Please select at least one option.",Toast.LENGTH_SHORT).show();
        }
    }
}
