package tree;

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void PreOrder() {
        if (this.root != null) {
            this.root.PreOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void CenterOrder() {
        if (this.root != null) {
            this.root.CenterOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void PostOrder() {
        if (this.root != null) {
            this.root.PostOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    public Node PreOrderSearch(int number){
        if(this.root!=null){
            return this.root.PreOrderSearch(number);
        }else {
            return null;
        }
    }
    public Node CenterOrderSearch(int number){
        if(this.root!=null){
            return this.root.CenterOrderSearch(number);
        }else {
            return null;
        }
    }
    public Node PostOrderSearch(int number){
        if(this.root!=null){
            return this.root.PostOrderSearch(number);
        }else {
            return null;
        }
    }
    public void DeleteNode(int number){
        if(this.root!=null){
            if(this.root.getNumber()==number)
                this.root=null;
            this.root.DeleteNode(number);
        }else{
            System.out.println("未找到要删除的节点");
        }

    }
}

class Node {
    private int number;
    private String name;
    private Node left;
    private Node right;

    public Node(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void PreOrder() {
        System.out.printf("number=%d,name=%s\n", this.number, this.name);
        if (this.left != null) {
            this.left.PreOrder();
        }
        if (this.right != null) {
            this.right.PreOrder();
        }

    }

    public void CenterOrder() {
        if (this.left != null) {
            this.left.CenterOrder();
        }
        System.out.printf("number=%d,name=%s\n", number, name);
        if (this.right != null) {
            this.right.CenterOrder();
        }
    }

    public void PostOrder() {
        if (this.left != null) {
            this.left.PostOrder();
        }
        if (this.right != null) {
            this.right.PostOrder();
        }
        System.out.printf("number=%d,name=%s\n", number, name);
    }

    public Node PreOrderSearch(int number) {
        Node temp = null;
        if (this.number == number) {
            return this;
        }
        if (this.left != null) {
            temp = this.left.PreOrderSearch(number);
        }
        if (temp != null)
            return temp;
        if (this.right != null) {
            temp = this.right.PreOrderSearch(number);
        }
        return temp;
    }

    public Node CenterOrderSearch(int number) {
        Node temp = null;
        if (this.left != null) {
            temp = this.left.CenterOrderSearch(number);
        }
        if (temp != null) {
            return temp;
        }
        if (this.number == number) {
            return this;
        }
        if (this.right != null) {
            temp = this.right.CenterOrderSearch(number);
        }
        return temp;
    }

    public Node PostOrderSearch(int number) {
        Node temp = null;
        if (this.left != null) {
            temp = this.left.PostOrderSearch(number);
        }
        if (temp != null)
            return temp;
        if (this.right != null) {
            temp = this.right.PostOrderSearch(number);
        }
        if (temp != null)
            return temp;
        if (this.number == number) {
            return this;
        }
        return null;
    }

    public void DeleteNode(int number){
        if(this.left!=null&&this.left.number==number){
            this.left=null;
            return;
        }
        if(this.right!=null&&this.right.number==number){
            this.right=null;
        }
        if(this.left!=null){
            this.left.DeleteNode(number);
        }
        if(this.right!=null){
            this.right.DeleteNode(number);
        }
    }
}
