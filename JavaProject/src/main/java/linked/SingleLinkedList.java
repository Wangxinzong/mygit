package main.java.linked;

public class SingleLinkedList {

    //初始化头节点
    private HeroNode head = new HeroNode(0,"","");

    //添加节点(每次直接添加到链表的最后)
    /**
     * 思路：
     * 1、判断temp是否到最后一个节点，
     * 2、如果没有到最后一个节点则移动temp，
     * 3、否则将最后一个节点的next指向新添加的节点。
     * */
    public void add(HeroNode heroNode){
        //定义一个可移动的指针temp,初始化为head头指针
        HeroNode temp = head;
        while(true){
            //到最后一个节点，退出
            if(temp.getHeroNode()==null){
                break;
            }
            //移动temp指针
            temp = temp.getHeroNode();
        }
        //将最后一个节点的next指向新添加的节点。
        temp.setHeroNode(heroNode);
    }

    //按编号顺序添加节点
    /**
     * 思路：
     * 1、遍历链表，找到新节点要插入的位置。
     * 插入位置的查找方式为：
     * 1.1 判断链表是否为空或到了最后一个节点，如果是则插入，否则进入下一步
     * 1.2 如果链表不为空或没有到最有一个节点，则判断当前节点的next域的节点no编号(也当前节点的下个节点的no编号)是否大于新节点的no编号，
     * 如果大于则插入。
     * 2、将插入位置的上一个节点的next域赋给新节点的next域，同时将新节点赋给上一个节点的next域。
     * */
    public void addByOrderBy(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            //说明链表为空或者到了最后一个节点。
            if(temp.getHeroNode()==null){
                flag=true;
                break;
            }
            else if(temp.getHeroNode().getNo()>heroNode.getNo()){
                flag=true;
                break;
            }
            else if(heroNode.getNo()==temp.getHeroNode().getNo()){
                System.out.println("已经存在");
                break;
            }
            temp = temp.getHeroNode();
        }

        if(flag){
            heroNode.setHeroNode(temp.getHeroNode());
            temp.setHeroNode(heroNode);
        }
    }

    //遍历链表
    /**
     * 思路：
     * 1、判断链表是否为空，如果为空则结束
     * 2、定义一个temp指针，执行头结点的Next域
     * 3、遍历判断temp指针是否为空。如果不为空则输出；为空则表示遍历到了链表的最后，结束。
     * */
    public void list(){
        //判断链表是否为空
        if(head.getHeroNode()==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.getHeroNode();
        while (temp!=null){
            System.out.println(temp);
            temp=temp.getHeroNode();
        }

    }

    //删除节点
    /**
     * 思路：
     * 1、找到要删除节点的上一个节点
     * 2、将要删除节点的next域赋给上一个节点的next域
     * */
    public void delete(int no){
        HeroNode temp = head;
        //boolean flag = false;
        while (true){
            if(head.getHeroNode()==null){
                System.out.println("链表为空");
                return;
            }
            if(temp.getHeroNode()==null){
                System.out.println("没有找到要删除的节点");
                return;
            }
            if(temp.getHeroNode().getNo()==no){
                temp.setHeroNode(temp.getHeroNode().getHeroNode());
                return;
            }
            temp = temp.getHeroNode();
        }


    }
}
