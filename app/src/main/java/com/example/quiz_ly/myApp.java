package com.example.quiz_ly;

import android.app.Application;

public class myApp extends Application {
    private QuestionBank bank = new QuestionBank();

    public QuestionBank getBank() {
        return bank;
    }

    private StorageManager manager = new StorageManager();

    public StorageManager getManager() {
        return manager;
    }
}
