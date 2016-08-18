package com.example.user.eightball;

import java.util.ArrayList;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromSimpleStrings extends Answers {

    public AnswersFromSimpleStrings(){
        super();
    }

    public AnswersFromSimpleStrings(ArrayList<String> options){
        super(options);
    }

    @Override
    public void setupAnswers(){

        String[] answers = {
                "Yes",
                "That would be an ecumenical matter!"
        };

        for(String answer : answers){
            mAnswers.add(answer);
        }

    }

}
