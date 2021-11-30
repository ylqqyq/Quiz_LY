//package com.example.quiz_ly;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//import android.widget.TextView;
//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link UserFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class UserFragment extends Fragment implements StorageManager.getValue {
//
////    // TODO: Rename parameter arguments, choose names that match
////    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
////    private static final String ARG_PARAM1 = "param1";
////    private static final String ARG_PARAM2 = "param2";
////
////    // TODO: Rename and change types of parameters
//
//    EditText userInput;
//    Button submit;
//
//
//
//    public UserFragment() {
//        // Required empty public constructor
//    }
//
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_user, container, false);
//        userInput = v.findViewById(R.id.user_input);
//        submit = v.findViewById(R.id.submit);
//        return v;
//    }
//
//
//    @Override
//    public String getInput() {
//        return userInput.getText().toString();
//    }
//}