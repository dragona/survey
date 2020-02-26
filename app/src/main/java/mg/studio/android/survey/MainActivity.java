package mg.studio.android.survey;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    CheckBox welcomecheck;
    Button welcome_start_click;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        welcomecheck = (CheckBox)findViewById(R.id.welcome_check);
        welcome_start_click = (Button)findViewById(R.id.welcome_start);
        welcomecheck.setOnClickListener(ButtonClick);
        welcome_start_click.setOnClickListener(ButtonClick);
    }
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.welcome_check:
                    count += 1;
                    if(count > 1)
                        count = 0;
                    break;
                case R.id.welcome_start:
                    if(count == 1)
                    {
                        Intent intent = new Intent(MainActivity.this,question_one.class);
                        startActivity(intent);
                    }

            }
        }
    };
}




