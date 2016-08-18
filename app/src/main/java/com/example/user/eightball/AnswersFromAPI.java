package com.example.user.eightball;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromAPI extends Answers  {

    private final static String API_URL="https://craggy-island-8-ball-api.herokuapp.com/";

    public AnswersFromAPI() {
        super();
    }

    public AnswersFromAPI(ArrayList<String> answers) {
        super(answers);
    }

    public void setupAnswers() {

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_URL, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.d("Eightball:", jsonObject.toString());

                JSONArray jsonAnswers = jsonObject.optJSONArray("answers");

                if (jsonAnswers != null) {

                    for (int i = 0; i < jsonAnswers.length(); i++) {

                        JSONObject jsonAnswer = jsonAnswers.optJSONObject(i);
                        if (jsonAnswer.has("text")) {
                            Log.d("Eightball:", jsonAnswer.toString());
                            String answer = jsonAnswer.optString("text");
                            Log.d("Eightball:", answer);
                            mAnswers.add(answer);
                        }
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                Log.e("EightBall:", "failure: " + statusCode + " " + throwable.getMessage());
            }
        });
    }
}
