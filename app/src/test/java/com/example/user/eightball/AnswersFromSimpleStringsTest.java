package com.example.user.eightball;

import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by user on 17/08/2016.
 */
public class AnswersFromSimpleStringsTest {

//    ArrayList<String> options;
    Answers answers;

    @Before
    public void before(){
//        options = new ArrayList<String>(Arrays.asList("Yes", "No", "Maybe"));
//        answers = new AnswersFromSimpleStrings(options);

        answers = new AnswersFromSimpleStrings();
    }

    @Test
    public void getAnswersTest(){
        assertNotNull(answers.getAnswers());
    }

    @Test
    public void getAnswersLengthTest(){
        assertEquals(2, answers.getLength());
    }

    @Test
    public void getAnswersByIndexTest(){
        assertEquals("Yes", answers.getAnswerAtIndex(0));
    }

    @Test
    public void getAnswerTest(){
        assertNotNull(answers.getAnswer());
    }

}
