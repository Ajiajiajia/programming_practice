package club.ajiajia.programming.classification.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortSearch {

    /**
     * printArray() 打印数组
     */
    public static void printArray(String message, int array[]){
        System.out.println(message+": [length: "+array.length+ "]");
            for(int i=0;i<array.length;i++){
                if (i !=0){
                    System.out.print(",");
                }
                System.out.print(array[i]);
            }
            System.out.println();
    }

    /**
     *
     *  insertElement () 插入元素
     */
    private static int[] insertElement(int original[],
                                       int element, int index) {
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index
                + 1, length - index);
        return destination;
    }

    public static void main(String [] args){
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        /**
         * 数据排序
         */
        Arrays.sort(array);
        printArray("数组的排序结果为",array);
        /**
         * binarySearch() 查找元素
         */
        int index = Arrays.binarySearch(array,2);
        System.out.println("元素为2在第"+ index+"个位置");

        int index_insert = Arrays.binarySearch(array,1);
        System.out.println("插入元素的位置"+ index_insert);
        int newIndex = -index - 1;
    }
}
