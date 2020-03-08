package mg.studio.android.survey;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    CheckBox accept;
    GeneratePage gpage;
    JSONArray quesArr;
    int curPage;
    String curQName;
    String curQType;
    int pageCnt;
    Data app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        accept=findViewById(R.id.accept);
        curPage=0;
        gpage=new GeneratePage("sample.json");
        JSONObject survey=gpage.getSurvey();
        pageCnt=gpage.getPageCnt();
        quesArr=gpage.getQuestions(survey);//get all the questions
        app=(Data)getApplication();
    }
    /*
    func:create a page
    input:a quesion json obj
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void createPage(JSONObject pagejson){
        ++curPage;//the current page of the questionnaire(except welcom page)
        //set the outer linearlayout
        LinearLayout outLinearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        outLinearLayout.setPadding(dp2px(50),dp2px(30),dp2px(50),dp2px(30));//set the padding
        outLinearLayout.setOrientation(LinearLayout.VERTICAL);//set the vertical orientation
        outLinearLayout.setLayoutParams(params);

        curQName=gpage.getQuesName(pagejson);
        curQType=gpage.getQuesType(pagejson);
        JSONArray quesOpts=gpage.getOpts(pagejson);

        //set the inner linearlayout
        LinearLayout inLinearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams inparams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1);
        inLinearLayout.setOrientation(LinearLayout.VERTICAL);
        inLinearLayout.setLayoutParams(inparams);

        //add views to inner layout, add inner layout and nextbtn to outer layout
        List listQNum=createQuesNum();
        List listQName=createQuesName();
        List listOpts=createRbtns(quesOpts);
        inLinearLayout.addView((TextView)listQNum.get(0),(LinearLayout.LayoutParams)listQNum.get(1));
        inLinearLayout.addView((TextView)listQName.get(0),(LinearLayout.LayoutParams)listQName.get(1));
        inLinearLayout.addView((RadioGroup)listOpts.get(0),(LinearLayout.LayoutParams)listOpts.get(1));
        outLinearLayout.addView(inLinearLayout,inparams);

        List next=createNext();
        outLinearLayout.addView((Button)next.get(0),(LinearLayout.LayoutParams)next.get(1));

        setContentView(outLinearLayout);

    }

    private int dp2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private List createQuesNum(){
        List list=new ArrayList();
        //add question num: TextView
        TextView quesNumTV=new TextView(this);
        quesNumTV.setText("Question "+"One ");
        quesNumTV.setTextSize(25);
        quesNumTV.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        LinearLayout.LayoutParams quesNumParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        quesNumTV.setLayoutParams(quesNumParams);
        list.add(quesNumTV);
        list.add(quesNumParams);
        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private List createQuesName(){
        List list=new ArrayList();
        //add question name:TextView
        TextView quesNameTV=new TextView(this);
        quesNameTV.setText(curQName);
        quesNameTV.setTextSize(20);
        LinearLayout.LayoutParams quesNameParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        quesNameParams.setMarginStart(dp2px(20));
        quesNameParams.setMarginEnd(dp2px(20));
        quesNameParams.topMargin=dp2px(60);
        quesNameTV.setLayoutParams(quesNameParams);
        list.add(quesNameTV);
        list.add(quesNameParams);
        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private List createRbtns(JSONArray quesOpts){
        //set the params of radiogroup
        List list=new ArrayList();
        RadioGroup rg=new RadioGroup(this);
        LinearLayout.LayoutParams rgParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        rgParams.topMargin=dp2px(40);
        rgParams.setMarginStart(dp2px(40));
        rgParams.setMarginEnd(dp2px(40));
        rg.setId(R.id.btngrp);

        //set the radio buttons
        try{
            for(int i=0;i<quesOpts.length();++i){
                RadioButton rbtn=new RadioButton(this);
                LinearLayout.LayoutParams rbtnParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                rbtn.setText(quesOpts.getJSONObject(i).getString(i+1+""));
                rbtn.setLayoutParams(rbtnParams);

                //add radiobuttons to radiogroup
                rg.addView(rbtn,rbtnParams);
            }
        }catch (Exception e){
            Log.d("set radio btn error",e.getMessage());
        }
        list.add(rg);
        list.add(rgParams);
        return list;
    }

    private List createNext(){
        List list=new ArrayList();
        Button next=new Button(this);
        next.setText("NEXT");
        next.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        next.setBackgroundColor(getResources().getColor(R.color.colorGreen));

        LinearLayout.LayoutParams nextParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,dp2px(70));
        nextParams.bottomMargin=dp2px(10);
        next.setLayoutParams(nextParams);
        next.setOnClickListener(new Button.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
//                String quesType=gpage.getQuesType(gpage.getQuesAsIndex(quesArr,curPage-1));//get current options type
                switch (curQType){
                    case "single":
                        //must check at least one option
                        try{
                            RadioGroup rg=findViewById(R.id.btngrp);
                            RadioButton checked_btn=findViewById(rg.getCheckedRadioButtonId());
                            String checked_val=checked_btn.getText().toString();
                            app.setReports(curPage-1,curQName,checked_val);
                        }catch (Exception e){
                            Toast.makeText(MainActivity.this,"please choose an answer first!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        break;
                }
                if(curPage<pageCnt){
                    createPage(gpage.getQuesAsIndex(quesArr,curPage));
                }else{
//                    setContentView(R.layout.finish_survey);
                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,FinishSurvey.class);
                    startActivity(intent);
                }
            }
        });
        list.add(next);
        list.add(nextParams);
        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void enterSurvey(View view){
        if(!accept.isChecked()){
            Toast.makeText(MainActivity.this,"Please accept the terms first!",Toast.LENGTH_SHORT).show();
        }else {
            JSONObject page=gpage.getQuesAsIndex(quesArr,0);//get the certain question page.
            createPage(page);//dynamically generate the page

//            Intent intent=new Intent();
//            intent.setClass(this,QuesOne.class);
//            startActivity(intent);
        }

    }

}
