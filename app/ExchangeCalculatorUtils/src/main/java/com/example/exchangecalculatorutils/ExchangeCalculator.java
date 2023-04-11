package com.example.exchangecalculatorutils;

import java.util.ArrayList;

public final class ExchangeCalculator {
    final public static int Init = 0;
    final public static int Right = -1;
    final public static int Error = -2;
    final public static int Div0 = -3;
    final public static int End = -4;
    final public static int Empty = -5;
    String inputEqu = "";
    double currInput = 0;
    double rTemp = 0;
    int currState = Init;
    ArrayList<Double> numbers = new ArrayList<>();
    ArrayList<Character> symbols = new ArrayList<>();
    ArrayList<Boolean> buttonAble = new ArrayList<>();
    public double Calc(String eval){
        inputEqu = eval;
        currState = getE();
        return currInput;
    }

    public String getInputEqu() {
        return inputEqu;
    }

    public int getCurrState() {
        return currState;
    }

    /**
     * isEquation, 返回可读取的等式的长度或错误类型
     */
    private int getE(){
        boolean flag = true;
        int curr = 0;
        if(inputEqu.startsWith("-")){
            flag = false;
            curr++;
        }
        //double start point
        if(inputEqu.length() == 0) return Empty;
        curr = getR(curr);
        rTemp *= flag?1:-1;
        if(curr == End && inputEqu.length() != 0) {
            currInput = rTemp;
            return Right;
        }if(curr < 0) return curr;
        //not end, not error, current at symbol
        numbers.clear();
        symbols.clear();
        numbers.add(rTemp);
        do {//read Symbol
            if (isSymbol(inputEqu.charAt(curr))) return Error;
            symbols.add(inputEqu.charAt(curr));
            curr = curr + 1;
            if (inputEqu.length() == curr) return Error;
            //read double
            curr = getR(curr);
            if (curr == Error) return Error;
            numbers.add(rTemp);
        } while (curr != End);

        //calc mul and div
        for(int i = 0; i < symbols.size(); i++){
            char symbol = symbols.get(i);
            if(symbol == '×' || symbol == '/'){
                double a = numbers.get(i);
                double b = numbers.get(i+1);
                if(symbol == '×') numbers.set(i,a*b);
                else {
                    if(b == 0) return Div0;
                    numbers.set(i,a/b);
                }
                numbers.remove(i+1);
                symbols.remove(i);
                i--;
            }
        }
        //calc add and sub
        currInput = numbers.get(0);
        for(int i = 0; i < symbols.size(); i++){
            if(symbols.get(i) == '+') currInput += numbers.get(i+1);
            else currInput -= numbers.get(i+1);
        }
        return Right;
    }

    /**
     * isReal, 返回可读取的实数长度或错误类型
     * @return end+1
     */
    private int getR(int start){
        int i = start;
        while(i < inputEqu.length() && isSymbol(inputEqu.charAt(i))) i++;
        try{
            rTemp = Double.parseDouble(inputEqu.substring(start, i));
            if(i == inputEqu.length()) return End;
            else return i;
        }catch (NumberFormatException e){
            return Error;
        }
    }
    public static boolean isSymbol(char ch){
        return ch != '+' && ch != '-' && ch != '×' && ch != '/';
    }
}
