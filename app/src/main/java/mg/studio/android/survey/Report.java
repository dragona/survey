package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

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

    private Button save;
    private String JSON_data;

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
        save=(Button)findViewById(R.id.btn1);

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

        JSON_data = "{Question_1:"+question_one.answer+"\n"+",Question_2:"+question_two.answer+"\n"+",Question_3:"+question_three.answer
                +"\n"+",Question_4:"+question_four.answer+"\n"+",Question_5:"+question_five.answer+"\n"+",Question_6:"+question_six.answer+"\n"
                +",Question_7:"+question_seven.answer+"\n"+",Question_8:"+question_eight.answer+"\n"+",Question_9:"+question_nine.answer+"\n"
                +",Question_10:"+question_ten.answer+"\n"+",Question11:"+question_eleven.answer+"\n"+",Question_12:"+question_twelve.answer+"\n"+"}"+"\n";

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_file(JSON_data);
                Toast.makeText(Report.this,"Your answers have been saved in file save_data.json.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void save_file(String msg) {

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED));
        File sdFile = getExternalFilesDir(null);
        File saveData1 = new File(sdFile, "save_data.json");
        File saveData2 = new File(sdFile, "save_data.txt");
        try {
            FileOutputStream file_out1=new FileOutputStream(saveData1, true);
            file_out1.write(msg.getBytes());
            file_out1.flush();
            file_out1.close();

            FileOutputStream file_out2=new FileOutputStream(saveData2, true);
            file_out2.write(msg.getBytes());
            file_out2.flush();
            file_out2.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
