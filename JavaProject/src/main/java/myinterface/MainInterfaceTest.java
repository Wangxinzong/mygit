package main.java.myinterface;

import main.java.myinterface.impl.MyInterfaceImpl1;
import main.java.myinterface.impl.MyInterfaceImpl2;

import java.util.ArrayList;
import java.util.List;

public class MainInterfaceTest {

    public static void main(String[] args) {
        List<MyInterface> list = new ArrayList<>();
        list.add(new MyInterfaceImpl1());
        list.add(new MyInterfaceImpl2());
        for (MyInterface myInterface : list) {
            myInterface.method1();
        }
    }
}
