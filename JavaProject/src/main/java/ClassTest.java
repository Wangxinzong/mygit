package main.java;


import com.sun.org.glassfish.gmbal.Description;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassTest extends Fruit{

    private String name;
    public int age;
    Double salary;

    public ClassTest(){

    }

    public ClassTest(int name){
        System.out.println("有参构造");
    }

    private void info(){
        System.out.println("执行无惨方法info");
    }

    public void info(String str){
        System.out.println("执行有参方法info,参数为:"+str);
    }

    class Inner{

    }

    public static void main(String[] args){
        Class clazz  = ClassTest.class;

        try {
            Object obj = clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            field.set(obj,"nihao");
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
