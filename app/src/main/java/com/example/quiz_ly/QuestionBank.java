package com.example.quiz_ly;

import java.util.ArrayList;

public class QuestionBank {
    public ArrayList<Question> questionList;
    public ArrayList<Integer> colorList = new ArrayList<>();
    public QuestionBank() {


        this.questionList = new ArrayList<Question>();
        this.questionList.add(new Question((R.string.bear),R.string.true_answer));
        this.questionList.add(new Question((R.string.horse),R.string.false_answer));
        this.questionList.add(new Question((R.string.puffin),R.string.true_answer));
        this.questionList.add(new Question((R.string.cat),R.string.false_answer));
        this.questionList.add(new Question((R.string.dog),R.string.false_answer));
        this.questionList.add(new Question((R.string.cow),R.string.true_answer));
        this.questionList.add(new Question((R.string.koala),R.string.true_answer));
        this.questionList.add(new Question((R.string.reindeer),R.string.false_answer));
        this.questionList.add(new Question((R.string.chimp),R.string.true_answer));
        this.questionList.add(new Question((R.string.narwhal),R.string.false_answer));
        this.questionList.add(new Question((R.string.lion),R.string.false_answer));
//
//
        this.colorList.add(R.color.Green);
        this.colorList.add(R.color.MediumSeaGreen);
        this.colorList.add(R.color.SteelBlue);
        this.colorList.add(R.color.DarkOliveGreen);
        this.colorList.add(R.color.CadetBlue);
        this.colorList.add(R.color.MidnightBlue);
        this.colorList.add(R.color.DarkSlateGray);
        this.colorList.add(R.color.DarkGoldenrod);
        this.colorList.add(R.color.black);
        this.colorList.add(R.color.SaddleBrown);
        this.colorList.add(R.color.DarkBlue);
//
    }


    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public ArrayList<Integer> getColorList() {
        return colorList;
    }
}
