package main.java.digui;

public class Queue8 {

    private int MAX =8;
    private int[] array = new int[MAX];
    private static int count = 0;
    public static void main(String[] args){
        Queue8 queue8 = new Queue8();
        queue8.execute(0);
        System.out.println("总共："+count);
    }

    /**
     * num:第几个皇后，从0开始
     * */
    public void execute(int num){
        if(num==MAX){
            //打印数组
            for(int j=0;j<array.length;j++){
                System.out.print(array[j]+" ");
            }
            System.out.println("");
            count++;
            return;
        }
        //这里的i代表了列
        for(int i=0;i<8;i++){
            array[num]=i;
            //判断是否在同一列或统一斜线，返回true表示不在同一列或斜线上
            if(check(num)){
                execute(num+1);
            }
        }
    }

    /**
     * 判断是否在同一列或统一斜线
     * 数组值等于列：所以array[i]==array[num]表示在同一列
     * 如果 棋子所在行减另一个棋子所在行的绝对值等于棋子所在列减另一个棋子所在列的绝对值，说明在同一斜线上：
     * 所以Math.abs(num-i)==Math.abs(array[num]-array[i])表示在同一斜线
     * */
    public boolean check(int num){
        for(int i=0;i<num;i++){
            if(array[i]==array[num] || Math.abs(num-i)==Math.abs(array[num]-array[i])){
                return false;
            }
        }
        return true;
    }
}
