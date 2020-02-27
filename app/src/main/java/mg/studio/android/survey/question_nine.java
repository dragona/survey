package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_nine extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp9_1;
    private RadioButton rgp9_2;
    private RadioButton rgp9_3;
    private RadioButton rgp9_4;

    private String rgp9_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_nine);
        rgp9_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp9_2=(RadioButton)findViewById(R.id.rbtn2);
        rgp9_3=(RadioButton)findViewById(R.id.rbtn3);
        rgp9_4=(RadioButton)findViewById(R.id.rbtn4);

    }

    public void next9(View view){

        if(rgp9_1.isChecked()){
            rgp9_string=rgp9_1.getText().toString().trim();
        }
        if(rgp9_2.isChecked()){
            rgp9_string=rgp9_2.getText().toString().trim();
        }
        if(rgp9_3.isChecked()){
            rgp9_string=rgp9_3.getText().toString().trim();
        }
        if(rgp9_4.isChecked()){
            rgp9_string=rgp9_4.getText().toString().trim();
        }

        answer=rgp9_string;

        Intent intent9 = new Intent(this,question_ten.class);

        startActivity(intent9);
    }
}
