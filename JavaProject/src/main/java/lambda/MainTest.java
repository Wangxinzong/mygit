package main.java.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainTest {

    public static void main(String[] args) {
        MainTest mt = new MainTest();
        mt.happy(1000, (c) -> System.out.println("消费：" + c));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}
