package main.java.queue;

import java.util.Scanner;

public class QueueMain {

    public static void main(String[] args){
        //ArrayQueue queue =new ArrayQueue(3);
        AnnulusQueue queue = new AnnulusQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        String key;
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据");
            System.out.println("g(get)：取出数据");
            System.out.println("h(head)：查看队列头数据");
            key = scanner.next();
            switch (key){
                case "s":
                    queue.showQueue();
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                case "a":
                    int num = scanner.nextInt();
                    queue.addQueue(num);
                    break;
                case "g":
                    try {
                        int num2 = queue.getQueue();
                        System.out.println("获取数据："+num2);
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int head = queue.headQueue();
                        System.out.println("头数据："+head);
                    } catch (Exception e) {
                       System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
