package com.ericqin.algorithm.day3;

public class SingleLinkedListInsert {
}


class SingleList{
    private SingleLinkedInsert head = new SingleLinkedInsert();

    public void addOrder(SingleLinkedInsert singleLinkedInsert){
        SingleLinkedInsert temp = head;
        boolean flag=false;
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no>singleLinkedInsert.no){
                break;
            }else if (temp.next.no==singleLinkedInsert.no){
                flag = true;
                break;
            }
            temp  = temp.next;
        }
        if(flag){
            System.out.println(" no存在,不能加入");
        }else {
            singleLinkedInsert.next = temp.next;
            temp.next = singleLinkedInsert;
        }
    }

    public void alterOrder(SingleLinkedInsert singleLinkedInsert){
        if (head.next == null){
            System.out.println("单链表为空");
            return;
        }
        SingleLinkedInsert temp = head.next;
        boolean flag =false;
        while(true){
            if (temp.next ==null){
                System.out.println("单链表遍历完毕");
                break;
            }
            if (temp.no == singleLinkedInsert.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(!flag){
            System.out.println("没有该数据");
        }else {
            temp.name=singleLinkedInsert.name;
            temp.nickName=singleLinkedInsert.nickName;
        }

    }

    public void deleteOrder(SingleLinkedInsert singleLinkedInsert){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        SingleLinkedInsert temp = head;
        boolean flag =false;
        while (true){
            if (temp.next ==null){
                System.out.println("该值不存在");
            }
            if(temp.next.no == singleLinkedInsert.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag){
            temp.next= temp.next.next;
        }

    }




}

class SingleLinkedInsert{
    public SingleLinkedInsert next;

    public int no;
    public String name;
    public String nickName;

    @Override
    public String toString() {
        return "SingleLinkedInsert{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}