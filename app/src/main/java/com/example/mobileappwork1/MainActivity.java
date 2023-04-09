package com.example.mobileappwork1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    double currInput = 0;
    String inputEqu = "";
    TextView inputTv;
    ArrayList<View.OnClickListener> listeners = new ArrayList<>();
    Map<String, Button> buttonMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("汇率计算器");

        inputTv = findViewById(R.id.InputEqu);
        buttonMap.put("0",   (Button) findViewById(R.id.Button0));
        buttonMap.put("1",   (Button) findViewById(R.id.Button1));
        buttonMap.put("2",   (Button) findViewById(R.id.Button2));
        buttonMap.put("3",   (Button) findViewById(R.id.Button3));
        buttonMap.put("4",   (Button) findViewById(R.id.Button4));
        buttonMap.put("5",   (Button) findViewById(R.id.Button5));
        buttonMap.put("6",   (Button) findViewById(R.id.Button6));
        buttonMap.put("7",   (Button) findViewById(R.id.Button7));
        buttonMap.put("8",   (Button) findViewById(R.id.Button8));
        buttonMap.put("9",   (Button) findViewById(R.id.Button9));
        buttonMap.put("c"  , (Button) findViewById(R.id.ButtonC  ));
        buttonMap.put("00" , (Button) findViewById(R.id.Button00 ));

        buttonMap.put("cln", (Button) findViewById(R.id.ButtonCln));
        buttonMap.put("equ", (Button) findViewById(R.id.ButtonEqu));
        buttonMap.put("del", (Button) findViewById(R.id.ButtonDel));

        buttonMap.put("dpt", (Button) findViewById(R.id.ButtonDpt));
        buttonMap.put("add", (Button) findViewById(R.id.ButtonAdd));
        buttonMap.put("sub", (Button) findViewById(R.id.ButtonSub));
        buttonMap.put("mul", (Button) findViewById(R.id.ButtonMul));
        buttonMap.put("div", (Button) findViewById(R.id.ButtonDiv));

        for(int i = 0; i < 10; i++){
            int finalI = i;
            Objects.requireNonNull(buttonMap.get(String.valueOf(i).substring(0, 1))).
                    setOnClickListener(view -> input(String.valueOf(finalI)));
        }
        Objects.requireNonNull(buttonMap.get("dpt")).setOnClickListener(view -> input("."));
        Objects.requireNonNull(buttonMap.get("add")).setOnClickListener(view -> input("+"));
        Objects.requireNonNull(buttonMap.get("sub")).setOnClickListener(view -> input("-"));
        Objects.requireNonNull(buttonMap.get("mul")).setOnClickListener(view -> input("*"));
        Objects.requireNonNull(buttonMap.get("div")).setOnClickListener(view -> input("/"));

        Objects.requireNonNull(buttonMap.get("del")).setOnClickListener(view -> delete());
        Objects.requireNonNull(buttonMap.get("cln")).setOnClickListener(view -> clean());

        Objects.requireNonNull(buttonMap.get("00")).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { input("0"); input("0"); }
                }
        );
    }
    public void input(String ch){
        inputEqu += ch;
        inputTv.setText(inputEqu);
    }
    public void clean(){
        inputEqu = "";
        inputTv.setText(inputEqu);
    }
    public void delete(){
        inputEqu = inputEqu.substring(0, inputEqu.length()-1);
        inputTv.setText(inputEqu);
    }
    public void equal(){

    }
}