package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Report extends AppCompatActivity {

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView txt9;
    private TextView txt10;
    private TextView txt11;
    private TextView txt12;

    private TextView answers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        txt1= (TextView) findViewById(R.id.txt1);
        txt2= (TextView) findViewById(R.id.txt2);
        txt3= (TextView) findViewById(R.id.txt3);
        txt4= (TextView) findViewById(R.id.txt4);
        txt5= (TextView) findViewById(R.id.txt5);
        txt6= (TextView) findViewById(R.id.txt6);
        txt7= (TextView) findViewById(R.id.txt7);
        txt8= (TextView) findViewById(R.id.txt8);
        txt9= (TextView) findViewById(R.id.txt9);
        txt10= (TextView) findViewById(R.id.txt10);
        txt11= (TextView) findViewById(R.id.txt11);
        txt12= (TextView) findViewById(R.id.txt12);

        txt1.setText("Q1: "+question_one.answer);
        txt2.setText("Q2: "+question_two.answer);
        txt3.setText("Q3: "+question_three.answer);
        txt4.setText("Q4: "+question_four.answer);
        txt5.setText("Q5: "+question_five.answer);
        txt6.setText("Q6: "+question_six.answer);
        txt7.setText("Q7: "+question_seven.answer);
        txt8.setText("Q8: "+question_eight.answer);
        txt9.setText("Q9: "+question_nine.answer);
        txt10.setText("Q10: "+question_ten.answer);
        txt11.setText("Q11:"+question_eleven.answer);
        txt12.setText("Q12:"+question_twelve.answer);
    }
}
