package main.java.linked;

public class LinkedMain {

    public static void main(String[] args){
        //创建英雄节点
        HeroNode heroNode1 = new HeroNode(1,"松江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"无用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        //创建链表
//        SingleLinkedList singleLinkedList =new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);

        //按编号创建有序链表
        SingleLinkedList singleLinkedList2 =new SingleLinkedList();
        singleLinkedList2.addByOrderBy(heroNode1);
        singleLinkedList2.addByOrderBy(heroNode2);
        singleLinkedList2.addByOrderBy(heroNode4);
        singleLinkedList2.addByOrderBy(heroNode3);

        singleLinkedList2.list();

        System.out.println("-------------删除节点-------------------");
        //删除节点
        singleLinkedList2.delete(5);
        singleLinkedList2.list();

    }
}
