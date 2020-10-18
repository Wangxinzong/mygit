package main.java.stack;

import java.util.Scanner;

public class CalulatorMain {

    public static void main(String[] args){
        StackArray numStack = new StackArray(10);
        StackArray operStack = new StackArray(10);
        OperatorUtil operatorUtil = new OperatorUtil();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式");
        String expression = scanner.next();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(operatorUtil.isOperator(ch)){
                //如果操作符栈为空，则直接放入
                if(operStack.isEmpty()){
                    operStack.add(ch);
                }
                else {
                    //如果不为空，则分为一下几种情况
                    //1、如果当前操作符小于或等于栈顶操作符，则取出数栈中前两个数和栈顶操作符计算，计算结果放入数栈中
                    //2、如果当前操作符大于栈顶操作符，则放入操作符栈中
                    if(operatorUtil.operatorGrade(ch)<=operatorUtil.operatorGrade((char)operStack.pick())){
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        char operator = (char)operStack.pop();
                        int result = operatorUtil.operation(num1,num2,operator);
                        numStack.add(result);
                        i--;
                    }
                    else{
                        operStack.add(ch);
                    }


                }
            }
            else {
                int num = ch-48;
                String sNum = String.valueOf(num);
                while (true){
                    if(i+1>=expression.length() || operatorUtil.isOperator(expression.charAt(i+1))){
                        numStack.add(Integer.parseInt(sNum));
                        break;
                    }
                    else {
                        num = expression.charAt(i+1)-48;
                        sNum=sNum+String.valueOf(num);
                        i++;

                    }
                }
            }
        }

        while (true){
            if(operStack.isEmpty()){
                break;
            }
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char operator = (char)operStack.pop();
            int result = operatorUtil.operation(num1,num2,operator);
            numStack.add(result);
        }

        System.out.println("结果："+numStack.pop());
    }
}
