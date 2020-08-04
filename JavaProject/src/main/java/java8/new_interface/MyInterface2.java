package main.java.java8.new_interface;

public interface MyInterface2 {

    default void addOneObj(Object obj) {
        System.out.println("MyInterface2:" + obj);
    }

}
