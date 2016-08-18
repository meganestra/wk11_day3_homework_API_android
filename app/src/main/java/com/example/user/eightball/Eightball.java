package com.example.user.eightball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class Eightball extends AppCompatActivity {

    EditText mQuestionEditText;
    Button mShakeButton;

    Answers mAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionEditText = (EditText)findViewById(R.id.question_text);
        mShakeButton = (Button)findViewById(R.id.shake_button);
//        mAnswers = new AnswersFromSimpleStrings();
        mAnswers = new AnswersFromMyAPI();

        mShakeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String question = mQuestionEditText.getText().toString();

//                String answer = randomAnswer();

                String answer = mAnswers.getAnswer();

                Intent intent = new Intent(Eightball.this, AnswerActivity.class);
                intent.putExtra("answer", answer);
                Log.d("Eightball: ", "passing through '" + answer + "'");
                startActivity(intent);
            }
//
//            public String randomAnswer(){
//
//                String[] answers = new String[3];
//
//                answers[0] = "Yes";
//                answers[1] = "No";
//                answers[2] = "Maybe";
//
//                Random rand = new Random();
//                int index = rand.nextInt(answers.length);
//
//                return answers[index];
//
//            }


        });


    }

}
