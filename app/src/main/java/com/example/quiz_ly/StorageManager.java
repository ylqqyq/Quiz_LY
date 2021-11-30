package com.example.quiz_ly;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StorageManager {

    String filename = "record.txt";
    ArrayList<String> attempts = new ArrayList(0);

    public void saveData(Activity context, int q_num, int score ) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND);
            Toast.makeText(context.getApplicationContext(), "Attempts saved to " + context.getFilesDir(),Toast.LENGTH_LONG).show();
            fileOutputStream.write((score + "/" +q_num + "&").getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resetHistory(Activity context) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            Toast.makeText(context.getApplicationContext(), "Record reset",Toast.LENGTH_LONG).show();
            fileOutputStream.write("".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getData(Activity context) {
        FileInputStream fileInputStream = null;
        String averageStr ="";
        double total = 0.0;
        double average;
        StringBuffer stringBuffer = new StringBuffer();
        int read=0;
        try {
            fileInputStream = context.openFileInput(filename);
            while ((read = fileInputStream.read() )!= -1) {
                stringBuffer.append((char) read);
            }
            attempts = getHistory(stringBuffer.toString());
//            Log.d("history",attempts.toString());
            for (int i=0; i < attempts.size();i++) {
                total += Integer.parseInt(attempts.get(i));
            }
            Log.d("total",String.valueOf(total));
            Log.d("attempts",String.valueOf(attempts.size()));
            average = total / attempts.size();
            averageStr = String.format("%.2f",average);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return averageStr;
    }

    private ArrayList<String> getHistory(String stringFromFile) {
        int index=0;
        for (int i=0;i<stringFromFile.toCharArray().length;i++) {
            if(stringFromFile.toCharArray()[i] == '&') {
                index = i+1;
            } else {
                if(stringFromFile.toCharArray()[i] == '/') {
                    String score = stringFromFile.substring(index,i);
                    Log.d("score",score);
                    attempts.add(score);
                    Log.d("attempt",String.valueOf(attempts.size()));
                }
            }
        }
        return attempts;
    }
}
