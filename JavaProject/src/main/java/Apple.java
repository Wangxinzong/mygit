package main.java;

public class Apple extends Fruit {

    public static String staString = "A静态属性";
    public String noString = "A属性";

    public static void staMethod() {
        System.out.println("A静态方法");
    }

    public void noMethod() {
        System.out.println("A方法");
    }
}
