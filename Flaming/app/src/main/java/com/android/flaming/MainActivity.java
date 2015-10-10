package com.android.flaming;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goFlames(View view){
        EditText name1 = (EditText) findViewById(R.id.name1);
        String firstname = name1.getText().toString().toLowerCase();
        firstname = firstname.replaceAll(" ", "");


        EditText name2 = (EditText) findViewById(R.id.name2);
        String secondname = name2.getText().toString().toLowerCase();
        secondname = secondname.replaceAll(" ", "");

        String unCommon = "";
        String result = "";

        int lenght = firstname.length();
        for (int i=0; i<firstname.length(); i++){
            if (secondname.contains(String.valueOf(firstname.charAt(i)))){
                secondname = secondname.replaceAll(String.valueOf(firstname.charAt(i)), "");
                firstname = firstname.replaceAll(String.valueOf(firstname.charAt(i)), "");
                i--;
            }else{
                unCommon += String.valueOf(firstname.charAt(i));
            }
        }

        unCommon += secondname;
        String flame_res = "";

        switch (unCommon.length() % 6) {
            case 0:
                flame_res = "You are JUST Friends";
                break;
            case 1:
                flame_res = "PERFECT Lovers";
                break;
            case 2:
                flame_res = "JUST an Acquaintance";
                break;
            case 3:
                flame_res = "You will be MARRIED";
                break;
            case 4:
                flame_res = "ENEMIES stay close";
                break;
            case 5:
                flame_res = "Be a SWEETHEART ";
                break;
        }

        displayResult(flame_res);
    }

    public void displayResult(String result){
        TextView resultTextView = (TextView) findViewById(
                R.id.result_info);
        resultTextView.setText("" + result);
    }
}
