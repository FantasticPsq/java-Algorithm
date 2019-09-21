package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static sortAgorithm.quickSort.QuickSort;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 2, 25, 92, 98, 1000, 1000, 1000, 2000, 5000};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        List<Integer> list = BinarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }

    public static List<Integer> BinarySearch(int[] arr, int left, int right, int Findvalue) {
        int mid = (left + right) / 2;
        if (left > right) {
            return new ArrayList<>();
        }
        if (Findvalue < arr[mid]) {
            return BinarySearch(arr, left, mid - 1, Findvalue);
        } else if (Findvalue > arr[mid]) {
            return BinarySearch(arr, mid + 1, right, Findvalue);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != Findvalue)
                    break;
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != Findvalue)
                    break;
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

}
