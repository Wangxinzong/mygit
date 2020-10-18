package main.java.stack;

import java.util.Scanner;

public class StackMain {

    public static void main(String[] args){
        StackArray stackArray = new StackArray(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据");
            System.out.println("p(pop)：取出数据");
            String key = scanner.next();
            switch (key){
                case "s":
                    try {
                        stackArray.list();
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                case "a":
                    int num = scanner.nextInt();
                    stackArray.add(num);
                    break;
                case "p":
                    try {
                        int num2 = stackArray.pop();
                        System.out.println("获取数据："+num2);
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
}
