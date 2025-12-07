import java.util.Arrays;

public class Sorts {

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) return a;

        int mid = a.length / 2;

        int[] left = Arrays.copyOfRange(a, 0, mid);
        int[] right = Arrays.copyOfRange(a, mid, a.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] L, int[] R) {
        int[] out = new int[L.length + R.length];
        int i = 0, l = 0, r = 0;

        while (l < L.length && r < R.length) {
            if (L[l] <= R[r]) out[i++] = L[l++];
            else out[i++] = R[r++];
        }

        while (l < L.length) out[i++] = L[l++];
        while (r < R.length) out[i++] = R[r++];

        return out;
    }
}
