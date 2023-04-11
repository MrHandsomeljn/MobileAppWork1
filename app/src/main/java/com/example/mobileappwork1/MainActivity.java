package com.example.mobileappwork1;

import static java.lang.String.*;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exchangecalculatorutils.ExchangeCalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    double currInput = 0;
    String inputEqu = "0";

    /**
     * @bref State 状态转换算法
     * Terminal终结符：
     * s --> + - * /
     * d --> 123456789
     * . --> .
     * 0 --> 0
     *
     * State状态:
     * S1 新数字（#_ | s_)      ,接收(s,d,0,.)，s-->xs
     * S2 整数部分内部(d_)       ,接收(s,d,0,.)
     * S3 小数部分(._)          ,接收(s,d,0)
     * S4 整数0状态(s0_ | #0_)  ,接收(s,d,0,.)
     * D0 除0出错
     * Err 错误
     *
     * Table转换表：
     *      + - * / 19      00      .          drc
     * S1   S1(xs)  S2      S4      S3(0.)
     * S2   S1      ok      ok      S3
     * S3   S1      ok      ok      Err
     * S4   S1      S2(xd)  e       S3
     * D0   Err     S2(d)   S4      S3(0.)
     * Err
     */
    private enum State {s1,s2,s3,s4,d0,er}
    Stack<State> sState = new Stack<>();

    public void input(char ch){
        State inputState = sState.get(sState.size()-1);
        //run stage
        switch (inputState){
            case d0:
                if(isDigital(ch)) {
                    inputEqu = ""+ch;
                    setState(State.s2);
                } else if(ch=='0') {
                    inputEqu = "0";
                    setState(State.s4);
                } else if(ch == '.') {
                    inputEqu = "0.";
                    setState(State.s4);
                    setState(State.s3);
                } else {
                    inputEqu = "Error";
                    setState(State.er);
                } break;
            case s1:
                if(isSignal(ch)) {
                    inputEqu = inputEqu.substring(0,inputEqu.length()-1) + ch;
                    popState();
                    setState(State.s1);
                } else if(isDigital(ch)) {
                    inputEqu += ch;
                    setState(State.s2);
                } else if(ch == '0') {
                    inputEqu += ch;
                    setState(State.s4);
                } else if(ch == '.') {
                    inputEqu += "0.";
                    sState.push(State.s4);
                    setState(State.s3);
                } else {
                    inputEqu = "Error";
                    setState(State.er);
                } break;
            case s2: case s3:
                if(isSignal(ch)) {
                    inputEqu += ch;
                    setState(State.s1);
                } else if (isDigital(ch) || ch == '0') {
                    inputEqu += ch;
                    setState(inputState);
                } else if (ch == '.' && inputState == State.s2) {
                    inputEqu += ch;
                    setState(State.s3);
                } break;
            case s4:
                if(isSignal(ch)) {
                    inputEqu += ch;
                    setState(State.s1);
                } else if(isDigital(ch)) {
                    if(inputEqu.length() > 0)
                        inputEqu = inputEqu.substring(0,inputEqu.length()-1);
                    inputEqu += ch;
                    popState();
                    setState(State.s2);
                } else if(ch == '0'){
                    break;
                } else if(ch == '.') {
                    inputEqu += ch;
                    setState(State.s3);
                } else {
                    inputEqu = "Error";
                    setState(State.er);
                } break;
            case er:
                break;
        }
        //refresh inputNum
        inputTv.setText(inputEqu);
        renewDouble();
    }
    public void delete(){
        State curr = sState.get(sState.size()-1);
        if(curr == State.d0 || curr == State.er || inputEqu.length() == 1) {
            clean();
            return;
        } else if(inputEqu.charAt(0) == '-' && inputEqu.length() == 2){
            clean();
            return;
        }
        popState();
        inputEqu = inputEqu.substring(0,inputEqu.length()-1);
        inputTv.setText(inputEqu);
        renewDouble();
    }
    public void renewDouble(){
        String sTemp = inputEqu;
        if(isSignal(inputEqu.charAt(inputEqu.length()-1)))
            sTemp = inputEqu.substring(0,inputEqu.length()-1);
        currInput = eCalc.Calc(sTemp);
    }
    TextView inputTv;
    Map<String, Button> btnMap = new HashMap<>();
    ExchangeCalculator eCalc = new ExchangeCalculator();
    final String[] btnNames = new String[]{"1", "2", "3", "4", "5", "6", "7",
            "8", "9", "0", "00", "+", "-", "×", "/", ".", "c", "r", "e", "d",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("汇率计算器");

        inputTv = findViewById(R.id.InputEqu);
        //init buttonMap
        {
            //input[0,11]
            btnMap.put("0", (Button) findViewById(R.id.Button0));
            btnMap.put("00",(Button) findViewById(R.id.Button00));
            btnMap.put("1", (Button) findViewById(R.id.Button1));
            btnMap.put("2", (Button) findViewById(R.id.Button2));
            btnMap.put("3", (Button) findViewById(R.id.Button3));
            btnMap.put("4", (Button) findViewById(R.id.Button4));
            btnMap.put("5", (Button) findViewById(R.id.Button5));
            btnMap.put("6", (Button) findViewById(R.id.Button6));
            btnMap.put("7", (Button) findViewById(R.id.Button7));
            btnMap.put("8", (Button) findViewById(R.id.Button8));
            btnMap.put("9", (Button) findViewById(R.id.Button9));
            btnMap.put(".", (Button) findViewById(R.id.ButtonDpt));
            //signs[12,15]
            btnMap.put("+", (Button) findViewById(R.id.ButtonAdd));
            btnMap.put("-", (Button) findViewById(R.id.ButtonSub));
            btnMap.put("×", (Button) findViewById(R.id.ButtonMul));
            btnMap.put("/", (Button) findViewById(R.id.ButtonDiv));
            //control[16,19]
            btnMap.put("c", (Button) findViewById(R.id.ButtonCln));
            btnMap.put("r", (Button) findViewById(R.id.ButtonRes));
            btnMap.put("e", (Button) findViewById(R.id.ButtonEqu));
            btnMap.put("d", (Button) findViewById(R.id.ButtonDel));
        }
        //init buttonListeners
        {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                Objects.requireNonNull(btnMap.get(valueOf(i))).
                        setOnClickListener(view -> input(valueOf(finalI).charAt(0)));
            }
            Objects.requireNonNull(btnMap.get(".")).setOnClickListener(view -> input('.'));
            Objects.requireNonNull(btnMap.get("+")).setOnClickListener(view -> input('+'));
            Objects.requireNonNull(btnMap.get("-")).setOnClickListener(view -> input('-'));
            Objects.requireNonNull(btnMap.get("×")).setOnClickListener(view -> input('×'));
            Objects.requireNonNull(btnMap.get("/")).setOnClickListener(view -> input('/'));

            Objects.requireNonNull(btnMap.get("d")).setOnClickListener(view -> delete());
            Objects.requireNonNull(btnMap.get("c")).setOnClickListener(view -> clean());
            Objects.requireNonNull(btnMap.get("r")).setOnClickListener(view -> reset());
            Objects.requireNonNull(btnMap.get("e")).setOnClickListener(view -> equal());

            Objects.requireNonNull(btnMap.get("00")).setOnClickListener(view -> {
                input('0');
                input('0');
            });
        }
        //init state
        reset();
    }

    public void clean(){
        currInput = 0;
        inputEqu = "0";
        inputTv.setText(inputEqu);
        sState.clear();
        setState(State.s4);
    }

    public void equal(){
        if(isSignal(inputEqu.charAt(inputEqu.length()-1))){delete();}
        currInput = eCalc.Calc(inputEqu) + 0.0;
        if(eCalc.getCurrState() == ExchangeCalculator.Div0) {
            inputEqu = "Div 0";
            sState.clear();
            setState(State.d0);
        }else if(eCalc.getCurrState() == ExchangeCalculator.Error){
            inputEqu = "Error";
            sState.clear();
            setState(State.d0);
        }else if(eCalc.getCurrState() == ExchangeCalculator.Right){
            //build stack from start
            sState.clear();
            setState(State.s4);
            inputEqu = "0";
            if(currInput < 0) {
                currInput *= -1;
                inputEqu = "-";
                setState(State.s1);
            }
            //get curr double
            String sTemp = String.format("%5.6f", currInput);
            while(sTemp.charAt(sTemp.length()-1) == '0') sTemp = sTemp.substring(0,sTemp.length()-1);
            if(sTemp.charAt(sTemp.length()-1) == '.') sTemp = sTemp.substring(0,sTemp.length()-1);

            for(int i = 0; i < sTemp.length(); i++){ input(sTemp.charAt(i)); }
        }
        inputTv.setText(inputEqu);
    }
    public void reset(){
        clean();
    }
    private static boolean isDigital(char ch){
        return ch <= '9' && ch > '0';
    }
    private static boolean isSignal(char ch){
        return ch=='+'||ch=='-'||ch=='×'||ch=='/';
    }
    private void setState(State inputState){
        sState.push(inputState);
        setButtons(inputState);
    }
    private void popState(){
        if(sState.size() >= 1)
            sState.pop();
        if(sState.size() > 0)
            setButtons(sState.get(sState.size()-1));
    }
    private void setButtons(State inputState){
        switch (inputState){
            case d0:
                setButtons(".0019drc");
                break;
            case s1:
                setButtons("+-×/.0019drce");
                break;
            case s2:
                setButtons("+-×/.0019drce");
                break;
            case s3:
                setButtons("+-×/0019drce");
                break;
            case s4:
                setButtons("+-×/.19drce");
                break;
            case er:
                setButtons("drc");
                break;
        }
    }
    private void setButtons(String cmd){
        for(String s : btnNames) Objects.requireNonNull(btnMap.get(s)).setEnabled(cmd.contains(s));
        boolean f = cmd.contains("19");
        for(int i = 1; i < 10; i++) Objects.requireNonNull(btnMap.get(valueOf(i))).setEnabled(f);
    }
}