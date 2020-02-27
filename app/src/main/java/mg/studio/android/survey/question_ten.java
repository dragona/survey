package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_ten extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp10_1;
    private RadioButton rgp10_2;
    private RadioButton rgp10_3;
    private RadioButton rgp10_4;

    private String rgp10_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_ten);
        rgp10_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp10_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp10_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp10_4=(RadioButton)findViewById(R.id.rbtn4);


    }

    public void next10(View view){

        if(rgp10_1.isChecked()){
            rgp10_string=rgp10_1.getText().toString().trim();
        }
        if(rgp10_2.isChecked()){
            rgp10_string=rgp10_2.getText().toString().trim();
        }
        if(rgp10_3.isChecked()){
            rgp10_string=rgp10_3.getText().toString().trim();
        }
        if(rgp10_4.isChecked()){
            rgp10_string=rgp10_4.getText().toString().trim();
        }

        answer=rgp10_string;

        Intent intent10 = new Intent(this,question_eleven.class);

        startActivity(intent10);
    }
}
