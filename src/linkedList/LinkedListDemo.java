package linkedList;

import java.util.Stack;

public class LinkedListDemo {
    public static void main(String[] args) {
        heroNode heroNode1 = new heroNode(1, "林冲", "豹子头");
        heroNode heroNode2 = new heroNode(2, "宋江", "及时雨");
        heroNode heroNode3 = new heroNode(3, "吴用", "智多星");
        heroNode heroNode4 = new heroNode(4, "卢俊义", "玉麒麟");
        heroNode node1 = new heroNode(1, "小明", "帅哥");
        LikedList linkedlist = new LikedList();
//        linkedlist.add(heroNode1);
//        linkedlist.add(heroNode2);
//        linkedlist.add(heroNode3);
//        linkedlist.add(heroNode4);
        linkedlist.addByOrder(heroNode3);
        linkedlist.addByOrder(heroNode1);
        linkedlist.addByOrder(heroNode4);
        linkedlist.addByOrder(heroNode2);
//        System.out.println("这是修改之前的");
//        linkedlist.show();
//        linkedlist.update(node1);
//        System.out.println("这是修改之后的");
//        linkedlist.show();
//        linkedlist.delete(node1);
//        System.out.println("这是删除后的节点");
//        linkedlist.show();
//        linkedlist.reverseList();
        linkedlist.show();
        linkedlist.reversePrint();
    }
}

class LikedList {
   private heroNode head = new heroNode(0, "", "");

    //直接将要添加的节点加到链表末尾
    //public heroNode gethead(){return head;}
    public void add(heroNode node) {
        heroNode temp = head;
        while (true) {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(heroNode node) {
        boolean flag = false;
        heroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.number > node.number)
                break;
            if (temp.next.number == node.number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("当前链表已经包含要插入的节点，请勿重复插入");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //修改节点的值
    public void update(heroNode node) {
        boolean flag = false;
        heroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.number == node.number) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickname = node.nickname;
        } else {
            System.out.println("当前链表中不存在要更新的节点");
        }
    }

    public void reverseList() {
        heroNode reverseHead = new heroNode(0, "", "");
        heroNode next = null;
        heroNode cur = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    public void delete(heroNode node) {
        boolean flag = false;
        heroNode temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next == node) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = node.next;
        } else System.out.println("链表中没有要删除的节点");
    }

    //显示链表
    public void show() {
        if (head.next == null)
            System.out.println("链表为空");
        heroNode temp = head.next;
        while (true) {
            if (temp == null)
                return;
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void reversePrint() {
        if (head.next == null) {
            return;
        }
        Stack<heroNode> stack = new Stack<heroNode>();
        heroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}

class heroNode {
    public double number;
    public String name;
    public String nickname;
    public heroNode next;

    public heroNode(double number, String name, String nickname) {
        this.number = number;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        return "heroNode [number=" + number + ",name=" + name + ",nickname=" + nickname;
    }
}
