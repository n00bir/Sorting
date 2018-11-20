import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr;
        int n2 = (int) (n / 2.0 + 0.5);

        int[] arr0 = new int[n2];
        int[] arr1 = new int[n - n2];

        for (int i = 0; i < n2; i++) {
            arr0[i] = arr[i];
        }

        for (int i = n2; i < n; i++) {
            arr1[i - n2] = arr[i];
        }

        arr0 = MergeSort.mergeSort(arr0);
        arr1 = MergeSort.mergeSort(arr1);

        return MergeSort.merge(arr0, arr1);
    }

    public static int[] merge(int[] arr0, int[] arr1) {
        int[] c = new int[arr0.length + arr1.length];
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;

        while (i1 < arr0.length && i2 < arr1.length) {
            if (arr0[i1] > arr1[i2]) {
                c[i0] = arr1[i2];
                i2++;
            } else {
                c[i0] = arr0[i1];
                i1++;
            }
            i0++;
        }

        while (i1 < arr0.length) {
            c[i0] = arr0[i1];
            i0++;
            i1++;
        }

        while (i2 < arr1.length) {
            c[i0] = arr1[i2];
            i0++;
            i2++;
        }
        return c;
    }

    public static void main(String[] args) {
        int nMax = 100000;
        int chosenN = (int) (Math.random() * nMax + 1);

        int[] test0 = new int[chosenN];

        for (int i = 0; i < test0.length; i++) {
            test0[i] = (int) (Math.random() * nMax + 1);
        }

        System.out.println(Arrays.toString(test0));
        test0 = MergeSort.mergeSort(test0);
        System.out.println(Arrays.toString(test0));
    }
}
