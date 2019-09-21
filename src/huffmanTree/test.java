package huffmanTree;


public class test {
    public static void main(String[] args) {
        HuffmanTree huffmanTree1 = new HuffmanTree();
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffmanTree1.CreateHuffman(arr);
        huffmanTree1.PreOrder(root);
    }
}
