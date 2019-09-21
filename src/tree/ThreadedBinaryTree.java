package tree;

import java.sql.SQLSyntaxErrorException;

public class ThreadedBinaryTree {
    private Node2 root;
    private Node2 pre = null;

    public void setRoot(Node2 root) {
        this.root = root;
    }

    public void CenterThread() {
        this.CenterThread(root);
    }

    public void CenterThread(Node2 node2) {
        if (node2 == null)
            return;
        CenterThread(node2.getLeft());  //左递归
        if (node2.getLeft() == null) {
            node2.setLeft(pre);
            node2.setLeftType(1);
        }
        if (pre.getRight() == null && pre != null) {
            pre.setRight(node2);
            pre.setRightType(1);
        }
        pre = node2;  //pre移动到node2处
        CenterThread(node2.getRight());  //右递归
    }

    public void CenterThreadSearch() {
        Node2 node2 = root;
        while (node2 != null) {
            while (node2.getLeftType() == 0)
                node2 = node2.getLeft();
            System.out.println(node2);
            while (node2.getRightType() == 1) {
                node2 = node2.getRight();
                System.out.println(node2);
            }
            node2=node2.getRight();
        }
    }
}

class Node2 {
    private int number;
    private String name;
    private Node2 left;
    private Node2 right;
    private int leftType = 0; //默认为0，表示left节点为一个子树的根节点,若为1，则表示left有前驱节点指向
    private int rightType = 0;//默认为0，表示right节点为一个子树的根节点，若为1，则表示right有后继节点

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node2(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Node2 getLeft() {
        return left;
    }

    public void setLeft(Node2 left) {
        this.left = left;
    }

    public void setRight(Node2 right) {
        this.right = right;
    }

    public Node2 getRight() {
        return right;
    }
}