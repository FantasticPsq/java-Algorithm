package huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public Node CreateHuffman(int[] arr) {
        //将Node放到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {   //每循环一次节点数都会减小1个，最后只剩下权值为wpl的一个
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.remove(leftNode);   //删除两个已经用过的节点，因为下次选取最小的时不能再选取这两个。
            nodes.remove(rightNode);
            nodes.add(parent);  //把取出的节点新构造的节点加入，让下次取出
        }
        return nodes.get(0);
    }

    public void PreOrder(Node root) {
        if (root != null) {
            root.PreOrder();
        } else {
            System.out.println("树为空");
        }
    }
}

class Node implements Comparable<Node> {
    private int value;
    private Node left;
    private Node right;

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node [value=" +value+ "]";
    }

    public int getValue() {
        return value;
    }

    public void PreOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.PreOrder();
        if (this.right != null)
            this.right.PreOrder();
    }
}