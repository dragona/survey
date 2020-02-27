package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class question_two extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp2_1;
    private RadioButton rgp2_2;
    private RadioButton rgp2_3;
    private RadioButton rgp2_4;
    private RadioButton rgp2_5;

    private String rgp2_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);
        rgp2_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp2_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp2_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp2_4=(RadioButton)findViewById(R.id.rbtn4);
        rgp2_5=(RadioButton)findViewById(R.id.rbtn5);


    }

    public void next2(View view){

        if(rgp2_1.isChecked()){
            rgp2_string=rgp2_1.getText().toString().trim();
        }
        if(rgp2_2.isChecked()){
            rgp2_string=rgp2_2.getText().toString().trim();
        }
        if(rgp2_3.isChecked()){
            rgp2_string=rgp2_3.getText().toString().trim();
        }
        if(rgp2_4.isChecked()){
            rgp2_string=rgp2_4.getText().toString().trim();
        }
        if(rgp2_5.isChecked()){
            rgp2_string=rgp2_5.getText().toString().trim();
        }

        answer=rgp2_string;

        Intent intent2 = new Intent(this,question_three.class);

        startActivity(intent2);
    }
}

