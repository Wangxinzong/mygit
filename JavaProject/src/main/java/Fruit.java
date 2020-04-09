package main.java;

import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.Inherited;

@Description("ieiei")
public class Fruit {

    public static String staString = "F静态属性";
    public String noString = "F属性";

    public static void staMethod() {
        System.out.println("F静态方法");
    }

    private void noMethod() {
        System.out.println("F方法");
    }

    public void a(Apple... apples) {

    }

    private int b(String name, double d, int i) {
        return 1;
    }
}
