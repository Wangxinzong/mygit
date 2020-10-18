package main.java.stack;

public class OperatorUtil {

    //判断是否是操作符
    public boolean isOperator(char operator){
        if(operator=='+' || operator=='-' || operator=='*' || operator=='/'){
            return true;
        }
        return false;
    }

    //判断是否是数值
    public boolean isNum(String num){
        return num.matches("\\d+");
    }

    //返回操作符优先级
    public int operatorGrade(char operator){
        if(operator=='*' || operator=='/'){
            return 1;
        }
        if(operator=='+' || operator=='-'){
            return 0;
        }
        return -1;
    }

    public int operation(int num1,int num2 ,char operator){
        if(operator=='+'){
            return num1+num2;
        }
        else if(operator=='*'){
            return num1*num2;
        }
        else if(operator=='-'){
            return num2-num1;
        }
        else {
            return num2/num1;
        }
    }
}
