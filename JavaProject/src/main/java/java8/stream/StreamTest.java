package main.java.java8.stream;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", 20, 10000.0));
        list.add(new Employee("李四", 28, 5555.55));
        list.add(new Employee("王五", 26, 3333.33));
        list.add(new Employee("赵六", 36, 6666.66));
        list.add(new Employee("田七", 12, 8888.88));
        list.add(new Employee("田七", 12, 8886.66));
        list.add(new Employee("田七", 13, 8888.88));

        List<Double> slist = new ArrayList<>();
        slist.add(10d);
        slist.add(11d);
        slist.add(12d);
        slist.add(12d);
        slist.add(10d);
        slist.add(11.0);

        StreamTest streamTest = new StreamTest();
//        streamTest.paixu();
//        streamTest.paixu(list);
        //streamTest.findAndMatch(list);
        //streamTest.mapping();
        //streamTest.reduceStream(list);
        streamTest.collect(list);
    }

    //映射(map&flatmap)
    public void mapping() {
        List<String> list = new ArrayList<>();
        list.add("your");
        list.add("name");

        Stream stream = list.stream().map((e) -> {
            List<Character> charList = new ArrayList<>();
            e = e.toUpperCase();
            for (char ch : e.toCharArray()) {
                charList.add(ch);
            }
            return charList;
        });
        System.out.println(JSON.toJSONString(stream.toArray()));

        Stream stream2 = list.stream().flatMap((e) -> {
            List<Character> charList = new ArrayList<>();
            e = e.toUpperCase();
            for (char ch : e.toCharArray()) {
                charList.add(ch);
            }
            return charList.stream();
        });
        System.out.println(JSON.toJSONString(stream2.toArray()));


    }

    //自然排序
    public void paixu() {
        List<String> list = Arrays.asList("z", "b", "a", "A", "Z", "c");
        list.stream().sorted().forEach(System.out::println);
    }

    //定制排序
    public void paixu(List<Employee> employeeList) {
        employeeList.stream().sorted((e1, e2) -> {
            if (e1.getAge().equals(e2.getAge())) {
                return e1.getSalary().compareTo(e2.getSalary());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    //查找与匹配(终止操作)
    public void findAndMatch(List<Employee> employeeList) {
        boolean b = false;
        //检查是否匹配所有元素
        b = employeeList.stream().allMatch(e -> {
            return e.getAge().equals(12);
        });
        System.out.println(b);

        //检查是否至少匹配一个元素
        b = employeeList.stream().anyMatch(e -> {
            return e.getAge().equals(12);
        });
        System.out.println(b);

        //检查是否没有匹配到任何元素
        b = employeeList.stream().noneMatch(e -> {
            return e.getAge().equals(12);
        });
        System.out.println(b);

        Optional<Employee> employeeOptional = null;
        Employee employee;
        //获取流中第一个元素
        employeeOptional = employeeList.stream().findFirst();
        employee = employeeOptional.get();
        System.out.println(employee);

        //获取流中任意一个元素
        employeeOptional = employeeList.stream().findAny();
        employee = employeeOptional.get();
        System.out.println(employee);

        //获取流中元素的个数
        long count = employeeList.stream().count();
        System.out.println(count);

        //获取流中最大值
        employee = employeeList.stream().max((a1, a2) -> {
            return a1.getSalary().compareTo(a2.getSalary());
        }).get();
        System.out.println(employee);

        //获取流中最小值
        employee = employeeList.stream().min((a1, a2) -> {
            if (a1.getAge().equals(a2.getAge())) {
                return a1.getSalary().compareTo(a2.getSalary());
            } else {
                return a1.getAge().compareTo(a2.getAge());
            }
        }).get();
        System.out.println(employee);
    }

    //归约
    public void reduceStream(List<Employee> employeeList) {
        Double integer = employeeList.stream()
                .map(x -> {
                    return x.getSalary();
                })
                .reduce((x, y) -> {
                    return x + y;
                }).get();
        System.out.println(integer);
    }

    //收集
    public void collect(List<Employee> employeeList) {
        List<String> list = employeeList.stream()
                .map(x -> {
                    return x.getName();
                })
                .collect(Collectors.toList());
        System.out.println(list);

//        Map<String,Integer> map = employeeList.stream()
//                .collect(Collectors.toMap(x->{return x.getName();},y->{return y.getAge();}));
//        System.out.println(map);

        HashSet<Double> hashSet = employeeList.stream()
                .map(x -> {
                    return x.getSalary();
                })
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hashSet);

    }
}
