package club.ajiajia.programming.algorithm.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    public static void BubbleSort(int[] array){
        int temp = 0;
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int arr[]=new int[] {2,4,2,1,3,9,3};
        System.out.println(arr.length);
        BubbleSort.BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}