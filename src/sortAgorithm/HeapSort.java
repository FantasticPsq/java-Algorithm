package sortAgorithm;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("堆排序");
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);  //还没有元素被分离，所以length为arr.length
        }
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);  //最大的数已经被剔出
        }
    }

    public static void adjustHeap(int[] arr, int index, int length) {  //调整（创建）堆，如果是要升序排序，就建立一个大顶堆
        int temp = arr[index];
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[index] = arr[i];
                index = i;  //向上递归继续调换
            } else break;
        }
        arr[index] = temp;
    }
}
