package practice.timeComplexity;
import java.util.*;


public class sort01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i< arr.length;i++){
            arr[i] = sc.nextInt();
        }

        partition(arr);
        print(arr);
    }

    public static void partition(int[] arr){
        int i = 0;
        int j = 0;

        while(i < arr.length){
            if(arr[i] == 1 ){
                i++;
            } else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }


    }


    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
