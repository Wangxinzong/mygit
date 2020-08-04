package main.java.queue;

/**
 * 环形数组队列
 * */
public class AnnulusQueue {

    private int maxSize;
    private int front;
    private int real;
    private int[] arr;

    public AnnulusQueue(int maxSize){
        this.maxSize=maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否已满
    public boolean isFull(){
        return (real+1)%maxSize == front;
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
        arr[real] = num;
        real=(real+1)%maxSize;
    }

    //从队列中获取数据
    public int  getQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列中没有数据");
            return;
        }
        /**
         * 数组中有效值个数的计算
         * 当real>front时，有效值个数为real-front
         * 当real<front时，有效值个数为maxSize-front+real
         * 因此总的通用公式为：(maxSize-front+real)%maxSize
         * */
        for(int i=front;i<front+(real+maxSize-front)%maxSize;i++){
            System.out.println("值:"+arr[i%maxSize]);
        }
    }

    //显示队列头数据
    public int headQueue() throws Exception {
        if(isEmpty()){
            throw  new Exception("队列为空");
        }
        return  arr[front];
    }
}
