package main.java.java8.stream;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args){
        //创建Optional实例,参数不能为null
        Optional<Employee> employeeOptional = Optional.of(new Employee());

        //创建空Optional
        Optional emptyOptional = Optional.empty();

        //创建Optional实例，参数可以为null
        Optional<Employee> optional = Optional.ofNullable(null);

        //判断Optional实例是否为空
        boolean b = optional.isPresent();
        System.out.println(b);

        //如果Optional实例中有值，则返回值，否则返回T
        Employee employee = optional.orElse(new Employee("测试",0,0d));
        System.out.println(employee);




    }


}
