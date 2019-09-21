package tree;
/*
   数组的前序遍历
 */

public class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void PreOrder(int index) { //前序遍历
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.print(arr[index] + " ");
        if (index * 2 + 1 < arr.length) {
            PreOrder(index * 2 + 1);
        }
        if (index * 2 + 2 < arr.length) {
            PreOrder(index * 2 + 2);
        }
    }
}
