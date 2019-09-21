//package listStock;
//
//public class ListStockDemo {
//    public static void main(String[] args) {
//
//    }
//}
//
//class ListStock {
//    private Node head = null;
//    private int maxSize;
//
//    public ListStock(int maxSize) {
//        this.maxSize = maxSize;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public boolean isFull() {
//        return head.getNumber() == maxSize - 1;
//    }
//
//    public void push(Node node) {
//        if (isFull()){
//            System.out.println("栈已满，不能压入");
//            return;
//        }
//        head.setNext(node);
//        head=head.getNext();
//        System.out.printf("压入：%d",head.getNumber());
//    }
//    public int pop(){
//        if(isEmpty()){
//            throw new RuntimeException("栈为空,无法弹出");
//        }
//        System.out.println("弹出:"+head.getNumber());
//
//    }
//}
//
//class Node {
//    private Node next;
//    private int number;
//    private Node pre;
//
//    public int getNumber() {
//        return number;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//}