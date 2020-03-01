package mg.studio.android.survey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.annotation.Nullable;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class FinishSurvey extends Activity {
    String file_name="innerstorage.json";
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

        //save in the external storage
        try{
            if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
                String outfile_path=getExternalFilesDir("").getAbsolutePath();
                File file=new File(outfile_path.toString()+File.separator+"surveyreport.json");
                if(!file.exists()){
                    file.createNewFile();
                    System.out.println("create new file in external storage");
                }
//                File file=new File(outfile_path.toString()+File.separator+"surveyreport.json");
                FileOutputStream fos=new FileOutputStream(file,true);
                fos.write("\n".getBytes());
                fos.write(jsonObj.toString().getBytes());
                fos.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("external storage failed."+e.getMessage());
        }


        //save in the shared preference
        SharedPreferences sp=getSharedPreferences("shared_prefer",0);
        SharedPreferences.Editor editor=sp.edit();
        Iterator it=jsonObj.keys();
        try{
            while(it.hasNext()){
                String key=(String) it.next();
                String content=jsonObj.getString(key);
                editor.putString(key,content);
            }
            editor.commit();
        }catch (Exception e){
            System.out.println("shared preference failed! "+e.getMessage());
        }
        Intent intent=new Intent();
        intent.setClass(this,SvyReports.class);
        startActivity(intent);
    }
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