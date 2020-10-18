package main.java.linked;

/**
 * 每个HeroNode代表一个节点
 * */
public class HeroNode {

    //编号
    private int no;
    //英雄名称
    private String name;
    //英雄外号
    private String nickName;
    //指向下一个节点
    private HeroNode heroNode;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public HeroNode(){

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getHeroNode() {
        return heroNode;
    }

    public void setHeroNode(HeroNode heroNode) {
        this.heroNode = heroNode;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", heroNode=" + heroNode +
                '}';
    }
}
