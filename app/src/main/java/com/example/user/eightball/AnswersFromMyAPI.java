package com.example.user.eightball;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromMyAPI extends Answers implements Answerable {

    private final static String API_URL = "https://api.chucknorris.io/jokes/random";

    public AnswersFromMyAPI(){
        super();
    }

    public AnswersFromMyAPI(ArrayList<String> answers){
        super(answers);
    }

    public void setupAnswers(){

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_URL, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(JSONObject jsonObject){

                if(jsonObject != null && jsonObject.has("value")){
                    String answer = jsonObject.optString("value");
                    mAnswers.add(answer);
                }
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                Log.e("EightBall:", "failure: " + statusCode + " " + throwable.getMessage());
            }

        });


    }

}
