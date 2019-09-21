package linkedList;

public class doubleListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        heroNode2 hero1=new heroNode2(1,"林冲","豹子头");
        heroNode2 hero2=new heroNode2(2,"宋江","及时雨");
        heroNode2 hero3=new heroNode2(3,"吴用","智多星");
        heroNode2 hero4=new heroNode2(4,"卢俊义","玉麒麟");
        DoubleList doublelist = new DoubleList();
        doublelist.add(hero1);
        doublelist.add(hero2);
        doublelist.add(hero3);
        doublelist.add(hero4);
        doublelist.show();
        System.out.println();
        doublelist.update(hero1,"小明","帅哥");
        doublelist.show();
        System.out.println();
        doublelist.delete(hero3);
        doublelist.show();
    }
}

class DoubleList {
    public heroNode2 head = new heroNode2(0, "", "");

    public void add(heroNode2 node) {
        heroNode2 temp = head;
        while (true) {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //修改节点的值
    public void update(heroNode2 node,String name1,String nickname1) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        heroNode2 temp = head.next;
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
            temp.name = name1;
            temp.nickname = nickname1;
        } else {
            System.out.println("当前链表中不存在要更新的节点");
        }
    }

    public void delete(heroNode2 node) {
        boolean flag = false;
        heroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp == node) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null)
                temp.next.pre = temp.pre;
        } else System.out.println("链表中没有要删除的节点");
    }
    public void show() {
        if (head.next == null)
            System.out.println("链表为空");
        heroNode2 temp = head.next;
        while (true) {
            if (temp == null)
                return;
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class heroNode2 {
    public double number;
    public String name;
    public String nickname;
    public heroNode2 next;
    public heroNode2 pre;

    public heroNode2(double number, String name, String nickname) {
        this.number = number;
        this.name = name;
        this.nickname = nickname;
    }

    public String toString() {
        return "heroNode2 [number=" + number + ",name=" + name + ",nickname=" + nickname;
    }
}
