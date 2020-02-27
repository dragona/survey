package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class question_eleven extends AppCompatActivity {

    public static String answer;

    private RadioButton rgp11_1;
    private RadioButton rgp11_2;

    private String rgp11_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eleven);
        rgp11_1=(RadioButton)findViewById(R.id.rbtn1);
        rgp11_2=(RadioButton)findViewById(R.id.rbtn2);

    }

    public void next11(View view){

        if(rgp11_1.isChecked()){
            rgp11_string=rgp11_1.getText().toString().trim();
        }
        if(rgp11_2.isChecked()){
            rgp11_string=rgp11_2.getText().toString().trim();
        }

        answer=rgp11_string;

        Intent intent11 = new Intent(this,question_twelve.class);

        startActivity(intent11);
    }
}
