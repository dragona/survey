package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_eight extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp8_1;
    private RadioButton rgp8_2;
    private RadioButton rgp8_3;
    private RadioButton rgp8_4;
    private RadioButton rgp8_5;
    private RadioButton rgp8_6;
    private RadioButton rgp8_7;

    private String rgp8_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);
        rgp8_1=(RadioButton)findViewById(R.id.Iphone);
        rgp8_2=(RadioButton)findViewById(R.id.Nokia);
        rgp8_3=(RadioButton)findViewById(R.id.Samsung);
        rgp8_4=(RadioButton)findViewById(R.id.MI);
        rgp8_5=(RadioButton)findViewById(R.id.Lenovo);
        rgp8_6=(RadioButton)findViewById(R.id.Sony);
        rgp8_7=(RadioButton)findViewById(R.id.Others);

    }

    public void next8(View view){

        if(rgp8_1.isChecked()){
            rgp8_string=rgp8_1.getText().toString().trim();
        }
        if(rgp8_2.isChecked()){
            rgp8_string=rgp8_2.getText().toString().trim();
        }
        if(rgp8_3.isChecked()){
            rgp8_string=rgp8_3.getText().toString().trim();
        }
        if(rgp8_4.isChecked()){
            rgp8_string=rgp8_4.getText().toString().trim();
        }
        if(rgp8_5.isChecked()){
            rgp8_string=rgp8_5.getText().toString().trim();
        }
        if(rgp8_6.isChecked()){
            rgp8_string=rgp8_6.getText().toString().trim();
        }
        if(rgp8_7.isChecked()){
            rgp8_string=rgp8_7.getText().toString().trim();
        }

        answer=rgp8_string;

        Intent intent8 = new Intent(this,question_nine.class);
        startActivity(intent8);
    }
}
