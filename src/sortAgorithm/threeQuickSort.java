package sortAgorithm;

public class threeQuickSort {
    public static void Quick_3_Ways(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int i = low + 1;
        int lt = low;
        int gt = high;
        int temp = arr[low];
        while (i <= gt) {
            if (arr[i] < temp) {
                exch(arr, lt++, i++);
            } else if (arr[i] > temp) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }
        Quick_3_Ways(arr, low, lt - 1);
        Quick_3_Ways(arr, gt + 1, high);
    }

    public static void exch(int[] arr, int i, int j) {
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
