package com.ericqin.algorithm.day3;

public class SingleLinkedList {

    public static void main(String[] args) {

    }

}

class SinLinkedList{
    private HeroNode head = new HeroNode(0,"","");
    //add node to single linked list
    // 核心：头指针不能动
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next =heroNode;
    }

    public void list(){
        if(head.next ==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp =head.next;
        while (true){
            if(temp ==null){
                break;
            }
            System.out.print(temp + "  ");
            temp =temp.next;
        }
    }
}


class HeroNode{
    public int no;
    public String name;
    public String nickName;

    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}