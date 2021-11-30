package com.example.quiz_ly;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

//    private QuestionBank questionBank;
//
//    public QuizFragment(QuestionBank questionBank) {
//        super();
//        this.questionBank = questionBank;
//    }
//
//    public QuestionBank getQuestionBank() {
//        return questionBank;
//    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final int ARG_PARAM1 = questionID;
//    private static final int ARG_PARAM2 = "colorID";

    // TODO: Rename and change types of parameters
    private int questionID;
    private int colorID;

    public QuizFragment() {
        // Required empty public constructor
    }


    public static QuizFragment newInstance(int questionID, int colorID) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putInt("question",questionID);
        args.putInt("color",colorID);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView q = v.findViewById(R.id.question_frag);
        q.setText(getArguments().getInt("question"));
        q.setBackgroundResource(getArguments().getInt("color"));

        return v;



    }
}