public class MeuVetor {

    private int[] data;
    private int size;

    public MeuVetor() {
        data = new int[16];
        size = 0;
    }

    public void insert(int v) {
        if (size == data.length) resize();
        data[size++] = v;
    }

    private void resize() {
        int[] n = new int[data.length * 2];
        for (int i = 0; i < data.length; i++)
            n[i] = data[i];
        data = n;
    }

    public int sequentialSearch(int v) {
        for (int i = 0; i < size; i++)
            if (data[i] == v) return i;
        return -1;
    }

    public static int binarySearch(int[] sorted, int v) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (sorted[m] == v) return m;
            if (sorted[m] < v) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public int[] toArray() {
        int[] out = new int[size];
        for (int i = 0; i < size; i++) out[i] = data[i];
        return out;
    }
}
