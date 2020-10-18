package main.java.stack;

public class StackArray {

    private int maxSize;
    private int[] array;
    private int top;
    private OperatorUtil operatorUtil;

    public StackArray(int maxSize){
        this.maxSize=maxSize;
        array = new int[this.maxSize];
        top = -1;
        operatorUtil = new OperatorUtil();
    }

    //判断栈是否已满
    public boolean isFull(){
        return top==maxSize-1 ? true : false;
    }

    //判断栈是否已空
    public boolean isEmpty(){
        return top==-1?true:false;
    }

    //添加数据到栈
    public void add(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        array[top] = value;
    }
    //从栈中弹出一个数据
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = array[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        for(int i=top;i>-1;i--){
            System.out.println("值："+array[i]);
        }
    }

    //查看栈顶数据
    public int pick(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return array[top];
    }

}
