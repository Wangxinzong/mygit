package main.java.java8.new_interface;

public interface MyInterface {
    default void addOneObj(Object obj) {
        System.out.println("default add" + obj);
    }

    //String showMsg();

    static String staticMethod() {
        return "静态实现方法";
    }

}
