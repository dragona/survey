package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_six extends AppCompatActivity {
    Button q6_next;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        q6_next = (Button)findViewById(R.id.q6_next);
        q6_next.setOnClickListener(ButtonClick);
        editText = (EditText)findViewById(R.id.q6_edittext);
    }
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q6_next:
                    if(editText.length()!=0)
                    {
                        Intent intent = new Intent(question_six.this,question_seven.class);
                        startActivity(intent);
                    }

            }
        }
    };
}
