package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class question_six extends AppCompatActivity {

    public static String answer;

    private EditText et1;

    private String rgp6_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        et1=(EditText)findViewById(R.id.edit1);


    }

    public void next6(View view){

        rgp6_string=et1.getText().toString().trim();

        answer=rgp6_string;

        Intent intent6 = new Intent(this,question_seven.class);

        startActivity(intent6);
    }
}
