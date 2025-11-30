import java.util.Arrays;
import java.util.Random;

public class DataGenerator {

    public static int[] generateSequence(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
        return a;
    }

    public static int[] applyOrder(int[] base, InsertionOrder order) {
        int[] copy = Arrays.copyOf(base, base.length);

        if (order == InsertionOrder.ORDENADA) {
            return copy;
        }

        if (order == InsertionOrder.INVERSA) {
            int[] inv = new int[copy.length];
            for (int i = 0; i < copy.length; i++)
                inv[i] = copy[copy.length - 1 - i];
            return inv;
        }

        Random rnd = new Random();
        for (int i = copy.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int tmp = copy[i];
            copy[i] = copy[j];
            copy[j] = tmp;
        }
        return copy;
    }

    public static int[] pickRandomExisting(int[] sequence, int k) {
        Random rnd = new Random();
        int[] out = new int[k];
        for (int i = 0; i < k; i++)
            out[i] = sequence[rnd.nextInt(sequence.length)];
        return out;
    }
}
