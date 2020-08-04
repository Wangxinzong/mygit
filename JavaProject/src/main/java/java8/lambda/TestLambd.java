package main.java.java8.lambda;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.*;

/**
 * lambda基础语法
 * 语法格式：([[参数类型] 接口方法参数名1,[参数类型] 参数名2...]) -> {表达式};
 * []代表非必选项，如果只有一个参数或实现体只有一条语句，则可以省略()和{}
 * <p>
 * 上面的lambda表达式相当于:
 * new 接口(){
 *
 * @Override 接口方法(参数类型 参数名1, 参数类型 参数名2...){
 * 表达式
 * }
 * };
 */
public class TestLambd {

    public static void main(String[] args) {
        TestLambd testLambd1 = new TestLambd();
        testLambd1.functionInterface();
    }

    /**
     * 测试
     */
    public void basicGrammar() {
        MyPredicate myPredicate = (params) -> System.out.println(params);
        myPredicate.test2("有参无返回值");
    }

    /**
     * 函数式接口
     * 函数式接口使用@FunctionalInterface修饰接口，接口中有且只能有一个抽象方法
     */
    public void functionInterface() {
        MyFunction myFunction = (Integer para1, Integer para2) -> {
            return para1 + para2;
        };
        Integer resutl = myFunction.method(10, 34);
        System.out.println(resutl);
    }

    /**
     * 四大内置核心函数式接口
     */
    public void kenel() {
        //Consumer<T>
        Consumer<String> consumer = (e) -> {
            System.out.println(e);
        };
        consumer.accept("消费型");

        //Supplier 消费型
        Supplier<Integer> supplier = () -> {
            return 2 * 3 + 90;
        };
        Integer result = supplier.get();
        System.out.println(result);

        //Function<T,R> 函数型
        Function<Integer, String> function = (x) -> {
            return String.valueOf(x * x);
        };
        String s = function.apply(98);
        System.out.println(s);

        //Predicate 断言型
        Predicate<Boolean> predicate = (x) -> {
            return x == true;
        };
        System.out.println(predicate.test(false));

        BiPredicate<String, String> biPredicate = (a, b) -> {
            return a.equals(b);
        };
        BiPredicate<String, String> biPredicate2 = String::equals;
    }
}
