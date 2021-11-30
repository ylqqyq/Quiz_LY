//package com.example.quiz_ly;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class userActivity extends AppCompatActivity {
//    TextView question;
//    EditText input;
//    Button submit;
//    QuestionBank bank;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//        question = findViewById(R.id.how_many);
//        input = findViewById(R.id.user_input);
//        submit = findViewById(R.id.submit);
//        bank = ((myApp)getApplication()).getBank();
//
//        int size = bank.questionList.size();
//        if (size > Integer.parseInt(input.getText().toString())) {
//            bank.questionList.subList(Integer.parseInt(input.getText().toString()), size).clear();
//        }
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//    }
//}