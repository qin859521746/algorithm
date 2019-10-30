package com.ericqin.algorithm.day4;


/**
 *  查找单链表中倒数第k个节点
 */
public class Practive2 {
    public static void main(String[] args) {
        //1.添加节点

        //2.获取头部节点

        //3.查找单链表倒数第index个节点

    }
}

class Practive2NodeList{
//    private Practive2Node head = new Practive2Node();
    public int getlength(Practive2Node head){
        if(head.next == null){
            return 0;
        }
        Practive2Node temp =head.next;
        int count =0;
        while (temp !=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Practive2Node getLastNode(Practive2Node head,int index){
        if(head.next ==null){
            return null;
        }
        int size =getlength(head);
        if(index<0 || index>size){
            return null;
        }
        Practive2Node temp = head.next;
        for (int i=0;i<size-index;i++){
            temp = temp.next;
        }
     return temp;
    }

}

class Practive2Node{
    public Practive2Node next;

    public String name;
    public int age;

    @Override
    public String toString() {
        return "Practive2Node{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

