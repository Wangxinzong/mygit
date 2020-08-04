package main.java.java8.new_interface;

public class MyClass extends ParentClass implements MyInterface {

    @Override
    public void addOneObj(Object obj) {
        MyInterface.super.addOneObj(obj);
    }
}
