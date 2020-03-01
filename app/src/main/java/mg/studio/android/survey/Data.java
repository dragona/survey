package mg.studio.android.survey;

import android.app.Application;

import org.json.JSONException;
import org.json.JSONObject;

public class Data extends Application {
//    private String reports[];
    private JSONObject jsonObj;
    @Override
    public void onCreate() {
        super.onCreate();
//        reports=new String[12];
        jsonObj=new JSONObject();
//        for(int i=0;i<reports.length;++i){
//            reports[i]="No answer.";
//        }
    }
    public void setReports(int ques_num,String ques_str,String opt){
//        reports[ques_num]=opt;
        try{
            jsonObj.put(ques_str,opt);
        }catch (JSONException e){
            System.out.println("wrong json");
        }
    }
    public JSONObject getReports(){
        return jsonObj;
    }
    public String getAnswer(String key){
        try{
            return jsonObj.getString(key);
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }

    }

}
