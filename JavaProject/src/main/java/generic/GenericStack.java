package main.java.generic;

import main.java.Fruit;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T extends Fruit> {

    private List<T> list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public T pop() {
        T t = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return t;
    }

    public void push(T t) {
        list.add(t);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
