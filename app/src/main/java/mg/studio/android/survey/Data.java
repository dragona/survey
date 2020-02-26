package mg.studio.android.survey;

import android.app.Application;

public class Data extends Application {
    private String reports[];
    @Override
    public void onCreate() {
        super.onCreate();
        reports=new String[12];
        for(int i=0;i<reports.length;++i){
            reports[i]="No answer.";
        }
    }
    public void setReports(int ques_num,String opt){
        reports[ques_num]=opt;
    }
    public String[] getReports(){
        return reports;
    }

}
