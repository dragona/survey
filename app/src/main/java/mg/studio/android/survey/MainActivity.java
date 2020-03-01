package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    CheckBox accept;
    String file_name="mystore.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        accept=findViewById(R.id.accept);

    }
    public void enterSurvey(View view){
        if(!accept.isChecked()){
            Toast.makeText(MainActivity.this,"Please accept the terms first!",Toast.LENGTH_SHORT).show();
        }else {
            Intent intent=new Intent();
            intent.setClass(this,QuesOne.class);
            startActivity(intent);
        }

    }
}
