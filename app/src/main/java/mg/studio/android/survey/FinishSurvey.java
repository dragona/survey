package mg.studio.android.survey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class FinishSurvey extends Activity {
    String file_name="question.json";
    Data app;
    JSONObject jsonObj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_survey);
        app=(Data)getApplication();
        jsonObj=app.getReports();

    }
    public void enterNext(View view){
        createReport();//create report dynamically
        saveInternalFile();//save into internal jsonfile
    }
    private void createReport(){
        //add scrollview
        ScrollView sv=new ScrollView(this);
        ScrollView.LayoutParams svParam=new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT,ScrollView.LayoutParams.WRAP_CONTENT);
        sv.setBackgroundColor(getResources().getColor(R.color.colorGreen));
        sv.setLayoutParams(svParam);

        //add outer linearlayout
        LinearLayout outLinearLayout=new LinearLayout(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        outLinearLayout.setPadding(50,50,50,50);//set the padding
        outLinearLayout.setOrientation(LinearLayout.VERTICAL);//set the vertical orientation
        outLinearLayout.setLayoutParams(params);

        //add views together
        Iterator iterator=jsonObj.keys();
        try{
            while(iterator.hasNext()){
                String ques=iterator.next().toString();
                String ans=jsonObj.getString(ques);
                LinearLayout inlin=createTV(ques,ans);
                outLinearLayout.addView(inlin);
            }
        }catch (Exception e){
            Log.d("create view error",e.getMessage());
        }
        sv.addView(outLinearLayout,params);
        setContentView(sv);
    }
    private LinearLayout createTV(String ques,String ans){
        //create a inner linear layout for each question and answer
        LinearLayout inLin=new LinearLayout(this);
        inLin.setOrientation(LinearLayout.VERTICAL);
        inLin.setDividerDrawable(getResources().getDrawable(R.drawable.divider_line));
        inLin.setShowDividers(LinearLayout.SHOW_DIVIDER_END);
        inLin.setDividerPadding(4);
        LinearLayout.LayoutParams inParam=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        inLin.setLayoutParams(inParam);

        //create question name
        TextView tv=new TextView(this);
        tv.setText(ques);
        tv.setTextSize(20);
        LinearLayout.LayoutParams tvParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(tvParams);

        //create answer
        TextView answer=new TextView(this);
        answer.setText(ans);
        answer.setTextSize(25);
        answer.setTextColor(getResources().getColor(R.color.colorYellow));
        LinearLayout.LayoutParams ansParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        answer.setLayoutParams(ansParams);

        // add together
        inLin.addView(tv,tvParams);
        inLin.addView(answer,ansParams);
        return inLin;
    }
    private void saveInternalFile(){
                //save in the innerstorage
        FileOutputStream fileout = null;
        BufferedWriter writer = null;
        try {
            fileout = openFileOutput(file_name, Context.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(fileout));
            writer.write("\n");
            writer.write(jsonObj.toString());
        } catch (IOException e) {
            System.out.println("Internal storage failed! "+e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
//    public void enterNext(View view){
//        //save in the innerstorage
//        FileOutputStream fileout = null;
//        BufferedWriter writer = null;
//        try {
//            fileout = openFileOutput(file_name, Context.MODE_APPEND);
//            writer = new BufferedWriter(new OutputStreamWriter(fileout));
//            writer.write("\n");
//            writer.write(jsonObj.toString());
//        } catch (IOException e) {
//            System.out.println("Internal storage failed! "+e.getMessage());
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.close();
//                } catch (IOException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//
//        //save in the external storage
//        try{
//            if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
//                String outfile_path=getExternalFilesDir("").getAbsolutePath();
//                File file=new File(outfile_path.toString()+File.separator+"surveyreport.json");
//                if(!file.exists()){
//                    file.createNewFile();
//                    System.out.println("create new file in external storage");
//                }
////                File file=new File(outfile_path.toString()+File.separator+"surveyreport.json");
//                FileOutputStream fos=new FileOutputStream(file,true);
//                fos.write("\n".getBytes());
//                fos.write(jsonObj.toString().getBytes());
//                fos.close();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("external storage failed."+e.getMessage());
//        }
//
//
//        //save in the shared preference
//        SharedPreferences sp=getSharedPreferences("shared_prefer",0);
//        SharedPreferences.Editor editor=sp.edit();
//        Iterator it=jsonObj.keys();
//        try{
//            while(it.hasNext()){
//                String key=(String) it.next();
//                String content=jsonObj.getString(key);
//                editor.putString(key,content);
//            }
//            editor.commit();
//        }catch (Exception e){
//            System.out.println("shared preference failed! "+e.getMessage());
//        }
//        Intent intent=new Intent();
//        intent.setClass(this,SvyReports.class);
//        startActivity(intent);
//    }
}
//read the file
//        FileInputStream filein=null;
//        try{
//            filein=openFileInput(file_name);
//            BufferedReader bfr=new BufferedReader(new InputStreamReader(filein));
//            String line=bfr.readLine();
//            StringBuffer sb=new StringBuffer();
//            while(line!=null){
//                sb.append(line);
//                sb.append('\n');
//                line=bfr.readLine();
//            }
//            bfr.close();
//            filein.close();
//            System.out.println("save file content : "+sb.toString());
//        }catch (IOException e){
//            System.out.println("wrong read");
//            e.printStackTrace();
//        }