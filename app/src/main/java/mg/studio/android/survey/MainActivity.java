package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    Intent intent;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

    }


    public void start(View view){
        intent = new Intent(this,question_one.class);
        startActivity(intent);
    }

    public void json(View view){
        intent1 = new Intent(this,Show_json.class);
        startActivity(intent1);
    }


}
