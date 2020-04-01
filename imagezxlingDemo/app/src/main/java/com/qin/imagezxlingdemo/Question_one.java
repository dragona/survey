package com.qin.imagezxlingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Question_one extends AppCompatActivity {
    Button q1_next;
    String q1input = null;
    RadioButton q1_iphone;
    String password;
    private RadioGroup radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);
        Intent i = getIntent();
        password = i.getStringExtra("password");
        q1_next = (Button)findViewById(R.id.q1_next);
        q1_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q1_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        q1_iphone = (RadioButton) findViewById(R.id.q1_iphone);
        q1input = q1_iphone.getText().toString();
    }
    private OnCheckedChangeListener RadioClick=new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    RadioButton e = (RadioButton) findViewById(id);
                    q1input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q1_next:
                    Intent intent = new Intent(Question_one.this,
                            UnLock.class);
                    intent.putExtra("password",password);
                    startActivity(intent);
            }
        }
    };
}
