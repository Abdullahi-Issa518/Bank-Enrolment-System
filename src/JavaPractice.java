import java.util.Arrays;
import java.util.Scanner;

public class JavaPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,3,4,5};

        arr = insertAt(arr,2,6);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] append(int[] arr, int n){

        for (int value : arr) {
            if (value == n){
                System.out.println("Duplicate number!");
                return arr;
            }
        }

        int[] arrCopy = new int[arr.length + 1];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        arrCopy[arr.length] = n;
        return arrCopy;
    }

    public static int[] insertAt(int[] arr, int index, int value){
        if (index < 0 || index > arr.length) {
            System.out.println("Invalid index!");
                return arr;
            }

            int[] arrCopy = new int[arr.length + 1];

            // Copy left side: [0, index)
            System.arraycopy(arr, 0, arrCopy, 0, index);

            // Insert
            arrCopy[index] = value;

            // Copy right side: [index, arr.length)
            System.arraycopy(arr, index, arrCopy, index + 1, arr.length - index);

            return arrCopy;
        }

}
