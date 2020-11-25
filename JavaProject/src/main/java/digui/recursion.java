package main.java.digui;

public class recursion {

    public static void main(String[] args){
        test(4);
    }

    public static void test(int i){
        if(i>2){
            System.out.println("A"+i);
            test(i-1);
            System.out.println("B"+i);
        }
        System.out.println(i);
    }
}
