/*
    本例使用环形链表解决约瑟夫问题。
*/
package linkedList;

public class circleLinkedList {
    public static void main(String[] args) {
        CircleList circlelist = new CircleList();
        circlelist.addBoy(6);
        circlelist.CountBoy(6,2,4);
    }
}

class CircleList {
    private Boy first = null;

    public void CountBoy(int number, int startPosition, int m) {//number为小孩个数，
        if (first == null || startPosition < 1 || startPosition > number) {
            System.out.println("参数错误。");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first)
                break;
            helper = helper.getNext();
        }
        for (int i = 1; i < startPosition; i++) {//把first指针移动到开始数数的位置，helper在其后面。用于去掉找到的first节点时，连接链表。
            first = first.getNext();
            helper = helper.getNext();
        }
        while(true) {
            if(helper==first)
                break;
            for (int i = 1; i < m; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("编号为%d的小孩出圈\n",first.getNumber());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后一个出圈的是编号为%d的小孩",first.getNumber());
    }

    public void addBoy(int Tnumber) {
        Boy curBoy = null;
        if (Tnumber < 1) {
            System.out.println("参数错误");
            return;
        } else {
            for (int i = 1; i <= Tnumber; i++) {
                Boy boy = new Boy(i);
                if (i == 1) {
                    first = boy;
                    first.setNext(first);
                    curBoy = boy;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }
        }
    }

    public void showBoy() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {//这里不能写while(cur.Boy!=first),这样会少一个输出。
            System.out.printf("小孩的编号是 %d\n", curBoy.getNumber());
            if (curBoy.getNext() == first)
                break;
            curBoy = curBoy.getNext();
        }
    }
}

class Boy {
    private int number;
    private Boy next;

    public Boy getNext() {
        return next;
    }

    public int getNumber() {
        return number;
    }

    public Boy(int number) {
        this.number = number;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
