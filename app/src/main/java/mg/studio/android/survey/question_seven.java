package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_seven extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp7_1;
    private RadioButton rgp7_2;
    private RadioButton rgp7_3;
    private RadioButton rgp7_4;
    private RadioButton rgp7_5;

    private String rgp7_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_seven);
        rgp7_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp7_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp7_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp7_4=(RadioButton)findViewById(R.id.rbtn4);
        rgp7_5=(RadioButton)findViewById(R.id.rbtn5);

    }

    public void next7(View view){

        if(rgp7_1.isChecked()){
            rgp7_string=rgp7_1.getText().toString().trim();
        }
        if(rgp7_2.isChecked()){
            rgp7_string=rgp7_2.getText().toString().trim();
        }
        if(rgp7_3.isChecked()){
            rgp7_string=rgp7_3.getText().toString().trim();
        }
        if(rgp7_4.isChecked()){
            rgp7_string=rgp7_4.getText().toString().trim();
        }
        if(rgp7_5.isChecked()){
            rgp7_string=rgp7_5.getText().toString().trim();
        }

        answer=rgp7_string;

        Intent intent7 = new Intent(this,question_eight.class);

        startActivity(intent7);
    }

}
