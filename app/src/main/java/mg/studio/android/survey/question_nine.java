package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_nine extends AppCompatActivity {
    Button q9_next;
    int count = 0;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_nine);
        q9_next = (Button)findViewById(R.id.q9_next);
        q9_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q9_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q9_next:
                    if(count > 0)
                    {
                        Intent intent = new Intent(question_nine.this,question_ten.class);
                        startActivity(intent);
                    }

            }
        }
    };
}
