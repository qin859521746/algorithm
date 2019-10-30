package com.ericqin.algorithm.day4;

public class Practice {

    //1. 获取单链表的个数
    public static void main(String[] args) {

    }

}

class PracticeListNode{
    int count =0;
    public int getNodeNumber(PracticeNode head){
        if(head.next==null){
            return 0;
        }
        PracticeNode temp =head.next;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}



class PracticeNode{
    public PracticeNode next;

    public String name;
    public int no;

    @Override
    public String toString() {
        return "PracticeNode{" +
                ", name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
