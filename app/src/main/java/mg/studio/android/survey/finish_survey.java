package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class finish_survey extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);

    }

    public void finish(View view){
        Intent intent13 = new Intent(this,Report.class);
        startActivity(intent13);
    }
}
