package main.java.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式测试
 * */
public class PolandNotation {

    public static void main(String[] args) {
        //定义一个逆波兰表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        //将逆波兰表达式中的每个值放入集合中
        List<String> rpnList = getListStr(suffixExpression);
        System.out.println("-----------" + rpnList.toString());
        //计算集合存储的逆波兰表达式
        int r = caculate(rpnList);
        System.out.println("结果:"+r);

    }

    //将逆波兰表达式字符串转换为集合
    public static List<String> getListStr(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String value : strings) {
            list.add(value);
        }
        return list;
    }

    //计算逆波兰表达式
    public static int caculate(List<String> list) {
        OperatorUtil operatorUtil = new OperatorUtil();
        Stack<String> stack = new Stack<>();
        for (String v : list) {
            //如果是数值，放入栈中
            //如果是操作符，从栈中弹出两个数，并计算，将计算结果放入栈中。
            if (operatorUtil.isNum(v)) {
                stack.push(v);
            } else {
                int result = 0;
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                switch (v) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        System.out.println("无效操作符");
                        break;
                }

                stack.push(String.valueOf(result));
            }

        }
        return Integer.valueOf(stack.pop());
    }
}
