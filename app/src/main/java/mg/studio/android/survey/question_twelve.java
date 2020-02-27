package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_twelve extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp12_1;
    private RadioButton rgp12_2;
    private RadioButton rgp12_3;
    private RadioButton rgp12_4;
    private RadioButton rgp12_5;

    private String rgp12_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_twelve);
        rgp12_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp12_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp12_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp12_4=(RadioButton)findViewById(R.id.rbtn4);
        rgp12_5=(RadioButton)findViewById(R.id.rbtn5);

    }


    public void next12(View view){

        if(rgp12_1.isChecked()){
            rgp12_string=rgp12_1.getText().toString().trim();
        }
        if(rgp12_2.isChecked()){
            rgp12_string=rgp12_2.getText().toString().trim();
        }
        if(rgp12_3.isChecked()){
            rgp12_string=rgp12_3.getText().toString().trim();
        }
        if(rgp12_4.isChecked()){
            rgp12_string=rgp12_4.getText().toString().trim();
        }
        if(rgp12_5.isChecked()){
            rgp12_string=rgp12_5.getText().toString().trim();
        }

        answer=rgp12_string;

        Intent intent12 = new Intent(this,finish_survey.class);

        startActivity(intent12);
    }
}
