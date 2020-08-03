package main.java.queue;

/**
 * 数组队列
 * */
public class ArrayQueue {

    private int maxSize;
    private int front;
    private int real;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        front=-1;
        real=-1;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return real == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front == real;
    }

    //将数据存入队列
    public void addQueue(int num){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        real++;
        arr[real] = num;
    }

    //从队列中获取数据
    public int  getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列中没有数据");
            return;
        }
        for(int i:arr){
            System.out.println("值:"+i);
        }
    }

    //显示队列头数据
    public int headQueue() throws Exception {
        if(isEmpty()){
            throw  new Exception("队列为空");
        }
        return  arr[front+1];
    }






}
