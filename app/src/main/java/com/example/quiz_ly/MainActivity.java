package com.example.quiz_ly;

import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button true_btn;
    Button false_btn;
    ProgressBar progress;
    int index = 0;
    QuestionBank bank;
    int correctNum=0;
    AlertDialog.Builder alert1;
    AlertDialog.Builder alert2;
    StorageManager storageM;
//    UserFragment userFragment;
    FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        true_btn = findViewById(R.id.true_btn);
        false_btn = findViewById(R.id.false_btn);
        progress = findViewById(R.id.progressBar);
        alert1 = new AlertDialog.Builder(this);
        alert2 = new AlertDialog.Builder(this);
        bank = ((myApp)getApplication()).getBank();
        storageM = ((myApp)getApplication()).getManager();
        updateFragment(bank.questionList.get(index).question, bank.colorList.get(index));
        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == bank.questionList.size()-1) {
                    progress.setProgress(index+1);
                    showScoreDialog();
                } else {
                    if (bank.questionList.get(index).answer == R.string.true_answer) {
                        correctNum++;
                        Toast.makeText(getApplicationContext(), getString(R.string.correct_msg), Toast.LENGTH_LONG).show();
                        progress.setProgress(index+1);
                    } else {
                        progress.setProgress(index+1);
                        Toast.makeText(getApplicationContext(), getString(R.string.wrong_msg), Toast.LENGTH_LONG).show();
                    }
                    updateFragment(bank.questionList.get(index+1).question, bank.colorList.get(index+1));
                }
                index++;}
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index == bank.questionList.size()-1) {
                    showScoreDialog();
                } else {
                    if (bank.questionList.get(index).answer == R.string.false_answer) {
                        correctNum++;
                        Toast.makeText(getApplicationContext(), getString(R.string.correct_msg), Toast.LENGTH_LONG).show();
                        progress.setProgress(index+1);
                    } else {
                        progress.setProgress(index+1);
                        Toast.makeText(getApplicationContext(), getString(R.string.wrong_msg), Toast.LENGTH_LONG).show();
                    }
                    updateFragment(bank.questionList.get(index+1).question, bank.colorList.get(index+1));
                }
                index++;}
        });
    }

    public void showScoreDialog() {
        alert1.create();
        alert1.setMessage("Your total score is " + correctNum + " out of " + bank.questionList.size());
        alert1.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                storageM.saveData(MainActivity.this,bank.questionList.size(),correctNum);
                Collections.shuffle(((myApp)getApplication()).getBank().questionList);
                Collections.shuffle(((myApp)getApplication()).getBank().colorList);
                index = 0;
                correctNum = 0;
            }
        });

        alert1.setNegativeButton("TRY AGAIN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Collections.shuffle(((myApp)getApplication()).getBank().questionList);
                Collections.shuffle(((myApp)getApplication()).getBank().colorList);
                index = 0;
                correctNum = 0;
            }
        });
        alert1.show();
    }

    public void showAverageDialog() {
        alert2.create();


        String average = ((myApp)getApplication()).getManager().getData(this);
        int attempts = ((myApp)getApplication()).getManager().attempts.size();
        Log.d("attemps_main",String.valueOf(attempts));
        alert2.setMessage("Your average score is " + average + " in " +
                attempts + " attempts");
        alert2.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alert2.show();
    }

    void updateFragment(int questionID,int colorID ) {
        fragManager = getSupportFragmentManager();
        fragManager.findFragmentById(R.id.question);
        QuizFragment frag = QuizFragment.newInstance(questionID,colorID);
        if(frag == null) {
            fragManager.beginTransaction().add(R.id.question,frag).commit();
        } else {
            fragManager.beginTransaction().replace(R.id.question,frag).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

//    void userFragment() {
//        fragManager = getSupportFragmentManager();
//        fragManager.findFragmentById(R.id.userInterface);
//        fragManager.beginTransaction().add(R.id.userInterface,new UserFragment()).commit();
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.average:{
                showAverageDialog();
                break;
            }
//            case R.id.q_num:{
//                Intent intent = new Intent(getApplicationContext(),userActivity.class);
//                startActivity(intent);
//                break;
//            }
            case R.id.reset:{
                ((myApp)getApplication()).getManager().resetHistory(this);
            }
        } return true;
    }

    public void onSavedInstanceState (Bundle outState) {

        }

//    public void setQuestionNum(View view) {
//        int input = Integer.parseInt(userFragment.userInput.getText().toString());
//        Log.d("input",String.valueOf(input));
//        bank.questionList.subList(input,bank.questionList.size()).clear();;
//    }
}

