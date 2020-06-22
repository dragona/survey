package mg.studio.android.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class QuesSix extends Activity {
    EditText edt;
    Data app;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_six);
        edt=findViewById(R.id.edt);
        app=(Data)getApplication();
    }
    public void enterNext(View view){
        String tmp=edt.getText().toString();
        if(tmp==null||"".equals(tmp)){
            Toast.makeText(QuesSix.this,"Please fill the blank",Toast.LENGTH_SHORT).show();
        }else{
            app.setReports(5,getResources().getString(R.string.ques_6),tmp);
            Intent intent=new Intent();
            intent.setClass(this,QuesSeven.class);
            startActivity(intent);
        }
    }
}
