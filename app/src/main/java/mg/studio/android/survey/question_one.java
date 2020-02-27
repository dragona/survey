package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_one extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp1_1;
    private RadioButton rgp1_2;
    private RadioButton rgp1_3;
    private RadioButton rgp1_4;
    private RadioButton rgp1_5;
    private RadioButton rgp1_6;
    private RadioButton rgp1_7;
    private String rgp1_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);
        rgp1_1=(RadioButton)findViewById(R.id.Iphone);
        rgp1_2=(RadioButton)findViewById(R.id.Nokia);
        rgp1_3=(RadioButton)findViewById(R.id.Samsung);
        rgp1_4=(RadioButton)findViewById(R.id.MI);
        rgp1_5=(RadioButton)findViewById(R.id.Lenovo);
        rgp1_6=(RadioButton)findViewById(R.id.Sony);
        rgp1_7=(RadioButton)findViewById(R.id.Others);
    }

    public void next1(View view){

        if(rgp1_1.isChecked()){
            rgp1_string=rgp1_1.getText().toString().trim();
        }
        if(rgp1_2.isChecked()){
            rgp1_string=rgp1_2.getText().toString().trim();
        }
        if(rgp1_3.isChecked()){
            rgp1_string=rgp1_3.getText().toString().trim();
        }
        if(rgp1_4.isChecked()){
            rgp1_string=rgp1_4.getText().toString().trim();
        }
        if(rgp1_5.isChecked()){
            rgp1_string=rgp1_5.getText().toString().trim();
        }
        if(rgp1_6.isChecked()){
            rgp1_string=rgp1_6.getText().toString().trim();
        }
        if(rgp1_7.isChecked()){
            rgp1_string=rgp1_7.getText().toString().trim();
        }

        answer=rgp1_string;

        Intent intent1 = new Intent(this,question_two.class);
        //intent1.putExtra("one",rgp1_string);
        startActivity(intent1);
    }
}
