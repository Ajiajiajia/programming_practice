package club.ajiajia.programming.week_4.tree.array;
/*
    Solution 1
 */
public class Find {

    public static boolean Find(int target, int array[][] ) {
        int column=0;
        int row=array.length-1;
        while(row>=0 && column<array.length){
            if(array[row][column]==target){
                return true;
            }
            else if(array[row][column]>target){
                row--;
            }
            else {
                column++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
34          * 1  2  8  9
35          * 2  4  9  12
36          * 4  7  10 13
37          * 6  8  11 15
38          */

        int array[][]=new int[4][4];
        array[0][0]=1;
        array[0][1]=2;
        array[0][2]=8;
        array[0][3]=9;
        array[1][0]=2;
        array[1][1]=4;
        array[1][2]=9;
        array[1][3]=12;
        array[2][0]=4;
        array[2][1]=7;
        array[2][2]=10;
        array[2][3]=13;
        array[3][0]=6;
        array[3][1]=8;
        array[3][2]=11;
        array[3][3]=15;
        System.out.println(Find(7, array));
        System.out.println(Find(5, array));
        }
}
