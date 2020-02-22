package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button btnw= (Button) findViewById(R.id.button_wel);
    }

    public void onclick_buttonw(View view)
    {
        //Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
        //Intent intent = new Intent(this,Main2Activity.class);
        //startActivity(intent);
        setContentView(R.layout.question_one);
        Button btnone= (Button) findViewById(R.id.button_one);
    }

    public void onclick_buttonone(View view)
    {
        setContentView(R.layout.question_two);
        Button btntwo= (Button) findViewById(R.id.button_two);
    }

    public void onclick_buttontwo(View view)
    {
        setContentView(R.layout.question_three);
        Button btnthree= (Button) findViewById(R.id.button_three);
    }

    public void onclick_buttonthree(View view)
    {
        setContentView(R.layout.question_four);
        Button btnfour= (Button) findViewById(R.id.button_four);
    }

    public void onclick_buttonfour(View view)
    {
        setContentView(R.layout.question_five);
        Button btnfive= (Button) findViewById(R.id.button_five);
    }

    public void onclick_buttonfive(View view)
    {
        setContentView(R.layout.question_six);
        Button btnsix= (Button) findViewById(R.id.button_six);
    }

    public void onclick_buttonsix(View view)
    {
        setContentView(R.layout.question_seven);
        Button btnseven= (Button) findViewById(R.id.button_seven);
    }

    public void onclick_buttonseven(View view)
    {
        setContentView(R.layout.question_eight);
        Button btneight= (Button) findViewById(R.id.button_eight);
    }

    public void onclick_buttoneight(View view)
    {
        setContentView(R.layout.question_nine);
        Button btnnine= (Button) findViewById(R.id.button_nine);
    }

    public void onclick_buttonnine(View view)
    {
        setContentView(R.layout.question_ten);
        Button btnten= (Button) findViewById(R.id.button_ten);
    }

    public void onclick_buttonten(View view)
    {
        setContentView(R.layout.question_eleven);
        Button btneleven= (Button) findViewById(R.id.button_eleven);
    }

    public void onclick_buttoneleven(View view)
    {
        setContentView(R.layout.question_twelve);
        Button btntwelve= (Button) findViewById(R.id.button_twelve);
    }

    public void onclick_buttontwelve(View view)
    {
        setContentView(R.layout.finish_survey);
        Button btnfin= (Button) findViewById(R.id.button_fin);
    }

    public void onclick_buttonf(View view)
    {
        System.exit(0);
    }
}
