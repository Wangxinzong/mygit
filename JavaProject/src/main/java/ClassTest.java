package main.java;


import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassTest extends Fruit {

    private String name;
    public int age;
    Double salary;

    public ClassTest() {

    }

    public ClassTest(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ClassTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public ClassTest(int name) {
        System.out.println("有参构造");
    }

    private void info() {
        System.out.println("执行无惨方法info");
    }

    public void info(String str) {
        System.out.println("执行有参方法info,参数为:" + str);
    }

    class Inner {

    }

    public static void main(String[] args) {
        Class clazz = ClassTest.class;

        try {
            Object obj = clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            field.set(obj, "nihao");
            System.out.println(field.get(obj));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
