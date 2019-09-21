package Search;


import static Search.fibonacciSearch.FibonacciSearch;
import static Search.insertValueSearch.InsertValueSearch;
import static sortAgorithm.threeQuickSort.Quick_3_Ways;

public class test {
    public static void main(String[] args){
        int[] arr={-1,34,23,56,99,34,89};
        Quick_3_Ways(arr,0,arr.length-1);
        //System.out.println(InsertValueSearch(arr,0,arr.length-1,23));
        System.out.println(FibonacciSearch(arr,56));
    }
}
