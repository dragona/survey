package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_three extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp3_1;
    private RadioButton rgp3_2;
    private RadioButton rgp3_3;
    private RadioButton rgp3_4;


    private String rgp3_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);
        rgp3_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp3_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp3_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp3_4=(RadioButton)findViewById(R.id.rbtn4);


    }

    public void next3(View view){

        if(rgp3_1.isChecked()){
            rgp3_string=rgp3_1.getText().toString().trim();
        }
        if(rgp3_2.isChecked()){
            rgp3_string=rgp3_2.getText().toString().trim();
        }
        if(rgp3_3.isChecked()){
            rgp3_string=rgp3_3.getText().toString().trim();
        }
        if(rgp3_4.isChecked()){
            rgp3_string=rgp3_4.getText().toString().trim();
        }

        answer=rgp3_string;

        Intent intent3 = new Intent(this,question_four.class);

        startActivity(intent3);
    }
}
