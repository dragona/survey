package mg.studio.android.survey;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GeneratePage{

    private int page_cnt;
    private int survey_id;
    private String filename;
    /*
    func:constructor,set the filename para.
     */
    public GeneratePage(String filename){
        this.filename=filename;
    }
    /*
    func: read the json file
    output: string data
     */
    private String getJson(){
        StringBuilder stringBuilder=new StringBuilder();
        try{
            InputStream inputStream=GeneratePage.this.getClass().getClassLoader().getResourceAsStream("assets/"+this.filename);//get assetmanager
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;//read each line
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);//add each line to string.
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        }catch (IOException e){
            Log.d("Read json error",e.getMessage());
        }
        return stringBuilder.toString();//return the json data as string.
    }
    /*
    func:get the survey json object.
    input:the result of getJson();
    output:the survey json object;
     */
    public JSONObject getSurvey(){
        String json=getJson();//read the json file;
        JSONObject surveyObj=null;
        try{
            surveyObj=new JSONObject(json);//convert string to jsonobj
            surveyObj=surveyObj.getJSONObject("survey");
            page_cnt=surveyObj.getInt("len");//get the numbers of questions
            survey_id=surveyObj.getInt("id");//get the id of the survey
        }catch(Exception e){
            Log.d("get json error",e.getMessage());
        }
        return surveyObj;
    }
    /*
    func:get the numbers of questions
    output: question numbers
    */
    public int getPageCnt(){
        return page_cnt;
    }
    /*
    func:get survey id in survey json obj
    output:survey id
     */
    public int getSurveyId(){return survey_id;}

    /*
    func:get all the questions in a json array.
    input:survey json object
    output:the questions array.
     */
    public JSONArray getQuestions(JSONObject jsonObject){
        JSONArray quesArr=null;
        try{
            quesArr=new JSONArray();
            quesArr=jsonObject.getJSONArray("questions");
        }catch (Exception e){
            Log.d("get questions error",e.getMessage());
        }
        return quesArr;
    }
    /*
    func:get the certain question according to the index
    input:the questions array,the index of some question
    output:the certain question json object.
     */
    public JSONObject getQuesAsIndex(JSONArray quesArr,int index){
        try{
            return quesArr.getJSONObject(index);
        }catch (Exception e){
            Log.d("get question as index",e.getMessage());
            return null;
        }
    }
    /*
    func:get question type
    input: a quesion json obj from getQuesAsIndex();
     */
    public String getQuesType(JSONObject ques){
        try{
            return ques.getString("type");
        }catch (Exception e){
            Log.d("get question type error",e.getMessage());
            return null;
        }
    }
    /*
   func:get question name
   input: a quesion json obj from getQuesAsIndex();
    */
    public String getQuesName(JSONObject ques){
        try{
            return ques.getString("question");
        }catch (Exception e){
            Log.d("get question name error",e.getMessage());
            return null;
        }
    }
    /*
 func:get question options
 input: a quesion json obj from getQuesAsIndex();
  */
    public JSONArray getOpts(JSONObject ques){
        try{
            return ques.getJSONArray("options");
        }catch (Exception e){
            Log.d("get ques options error",e.getMessage());
            return null;
        }
    }
}
