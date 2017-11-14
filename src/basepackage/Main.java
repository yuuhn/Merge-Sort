package basepackage;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int[] arr1 = new int[arr.length / 2];
        int[] arr2 = new int[arr.length - arr.length / 2];

        System.arraycopy(arr, 0, arr1, 0, arr.length / 2);
        System.arraycopy(arr, arr.length / 2, arr2, 0, arr.length - arr.length / 2);

        return merge(mergeSort(arr1), mergeSort(arr2));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int     arr1Pos = 0,
                arr2Pos = 0,
                mergedPos = 0;

        int[] mergedArr = new int[arr1.length+arr2.length];

        while (arr1Pos < arr1.length && arr2Pos < arr2.length) {
            if (arr1[arr1Pos] > arr2[arr2Pos]) {
                mergedArr[mergedPos] = arr2[arr2Pos];
                arr2Pos += 1;
            }
            else {
                mergedArr[mergedPos] = arr1[arr1Pos];
                arr1Pos += 1;
            }

            mergedPos +=1;
        }

        while (arr1Pos < arr1.length) {
            mergedArr[mergedPos] = arr1[arr1Pos];
            arr1Pos += 1;
            mergedPos +=1;
        }

        while (arr2Pos < arr2.length) {
            mergedArr[mergedPos] = arr2[arr2Pos];
            arr2Pos += 1;
            mergedPos +=1;
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        // int[] inArr = new int[] {2, 5, 4, 11, 15, 2, 6, 9, 0, 4, 3, 7, 8, 6, 1, 8};

        Scanner sc = new Scanner(System.in);
        String arrLine = sc.nextLine();
        String[] numbers = arrLine.split(" ");
        int[] inArr = new int[numbers.length];

        for (int i = 0; i < inArr.length; i++) {
            inArr[i] = Integer.parseInt(numbers[i]);
        }

        int[] sortedArr  = mergeSort(inArr);
        System.out.println(Arrays.toString(sortedArr ));
    }
}
