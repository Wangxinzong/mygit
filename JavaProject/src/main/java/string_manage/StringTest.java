package main.java.string_manage;

public class StringTest {

    public static void main(String[] args){
        StringTest st = new StringTest();
        st.stringformate();
    }

    //String.formate()
    /**
     *      %s: 字符串类型，如："liweihan"
     * 		%b: 布尔类型，如：true
     * 		%d: 整数类型(十进制)，如：99
     * 		%f: 浮点类型，如：99.99
     * 		%%: 百分比类型，如：％
     * 		%n: 换行符
     * 		*/
    public void stringformate(){

        String s = String.format("/%s/", "a/b/c");
        System.out.println("=====:"+s);

        String str = null;
        str = String.format("Hi , %s","韩超"); //格式化字符串
        System.out.println(str); //输出字符串变量str的内容

        System.out.printf("3>7的结果是: %b %n",3>7);
        System.out.println(String.format("3>7的结果是: %b %n", 3>7));

        System.out.printf("100的一半时:%d %n",100/2);
        System.out.println(String.format("100的一半时:%d %n", 100/2));

        System.out.printf("50元书的8.5折是:%f 元 %n",50*0.85);
        System.out.println(String.format("50元书的8.5折是:%f 元 %n", 50*0.85));

        System.out.printf("上面的折扣是%d%% %n",85);
        System.out.println(String.format("上面的折扣是%d%% %n", 85));
    }
}
