import java.util.Random;
import java.util.Arrays;

public class Main {

    static final int REPETITIONS = 5;

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        InsertionOrder[] orders = InsertionOrder.values();

        System.out.println("==INICIO DOS TESTES==");

        for (int size : sizes) {
            for (InsertionOrder order : orders) {

                System.out.println("\nTamanho: " + size + " | Ordem: " + order);

                int[] base = DataGenerator.generateSequence(size);
                int[] sequence = DataGenerator.applyOrder(base, order);

                double[] insertV = new double[REPETITIONS];
                double[] seqSearchV = new double[REPETITIONS];
                double[] binSearchV = new double[REPETITIONS];
                double[] sortInsV = new double[REPETITIONS];
                double[] sortMergeV = new double[REPETITIONS];

                for (int r = 0; r < REPETITIONS; r++) {

                    MeuVetor vec = new MeuVetor();

                    long start = System.nanoTime();
                    for (int v : sequence) vec.insert(v);
                    long end = System.nanoTime();
                    insertV[r] = (end - start) / 1e6;

                    int first = sequence[0];
                    int last = sequence[sequence.length - 1];
                    int mid = sequence[sequence.length / 2];
                    int[] random = DataGenerator.pickRandomExisting(sequence, 3);
                    int non = -999999;

                    long total = 0;

                    start = System.nanoTime();
                    vec.sequentialSearch(first);
                    end = System.nanoTime(); total += end - start;

                    start = System.nanoTime();
                    vec.sequentialSearch(last);
                    end = System.nanoTime(); total += end - start;

                    start = System.nanoTime();
                    vec.sequentialSearch(mid);
                    end = System.nanoTime(); total += end - start;

                    for (int v : random) {
                        start = System.nanoTime();
                        vec.sequentialSearch(v);
                        end = System.nanoTime(); total += end - start;
                    }

                    start = System.nanoTime();
                    vec.sequentialSearch(non);
                    end = System.nanoTime(); total += end - start;

                    seqSearchV[r] = (total / 6.0) / 1e6;

                    int[] arr = vec.toArray();
                    int[] sortedCopy = Sorts.mergeSort(arr);

                    long totalBin = 0;

                    start = System.nanoTime();
                    MeuVetor.binarySearch(sortedCopy, first);
                    end = System.nanoTime(); totalBin += end - start;

                    start = System.nanoTime();
                    MeuVetor.binarySearch(sortedCopy, last);
                    end = System.nanoTime(); totalBin += end - start;

                    start = System.nanoTime();
                    MeuVetor.binarySearch(sortedCopy, mid);
                    end = System.nanoTime(); totalBin += end - start;

                    for (int v : random) {
                        start = System.nanoTime();
                        MeuVetor.binarySearch(sortedCopy, v);
                        end = System.nanoTime(); totalBin += end - start;
                    }

                    start = System.nanoTime();
                    MeuVetor.binarySearch(sortedCopy, non);
                    end = System.nanoTime(); totalBin += end - start;

                    binSearchV[r] = (totalBin / 6.0) / 1e6;

                    int[] c1 = vec.toArray();
                    start = System.nanoTime();
                    Sorts.insertionSort(c1);
                    end = System.nanoTime();
                    sortInsV[r] = (end - start) / 1e6;

                    int[] c2 = vec.toArray();
                    start = System.nanoTime();
                    Sorts.mergeSort(c2);
                    end = System.nanoTime();
                    sortMergeV[r] = (end - start) / 1e6;
                }

                System.out.printf("Vetor - Insercao: %.4f ms\n", avg(insertV));
                System.out.printf("Vetor - Busca Sequencial: %.6f ms\n", avg(seqSearchV));
                System.out.printf("Vetor - Busca Binaria: %.6f ms\n", avg(binSearchV));
                System.out.printf("Vetor - Insertion Sort: %.4f ms\n", avg(sortInsV));
                System.out.printf("Vetor - Merge Sort: %.4f ms\n\n", avg(sortMergeV));

                double[] insertBST = new double[REPETITIONS];
                double[] searchBST = new double[REPETITIONS];

                for (int r = 0; r < REPETITIONS; r++) {
                    BSTree bst = new BSTree();

                    long start = System.nanoTime();
                    for (int v : sequence) bst.insert(v);
                    long end = System.nanoTime();
                    insertBST[r] = (end - start) / 1e6;

                    int first = sequence[0];
                    int last = sequence[sequence.length - 1];
                    int mid = sequence[sequence.length / 2];
                    int[] random = DataGenerator.pickRandomExisting(sequence, 3);
                    int non = -999999;

                    long total = 0;

                    start = System.nanoTime(); bst.search(first); end = System.nanoTime(); total += end - start;
                    start = System.nanoTime(); bst.search(last);  end = System.nanoTime(); total += end - start;
                    start = System.nanoTime(); bst.search(mid);   end = System.nanoTime(); total += end - start;
                    for (int v : random) { start = System.nanoTime(); bst.search(v); end = System.nanoTime(); total += end - start; }
                    start = System.nanoTime(); bst.search(non);   end = System.nanoTime(); total += end - start;

                    searchBST[r] = (total / 6.0) / 1e6;
                }

                System.out.printf("BST - Insercao: %.4f ms\n", avg(insertBST));
                System.out.printf("BST - Busca: %.6f ms\n\n", avg(searchBST));

                double[] insertAVL = new double[REPETITIONS];
                double[] searchAVL = new double[REPETITIONS];

                for (int r = 0; r < REPETITIONS; r++) {
                    AVLTree avl = new AVLTree();

                    long start = System.nanoTime();
                    for (int v : sequence) avl.insert(v);
                    long end = System.nanoTime();
                    insertAVL[r] = (end - start) / 1e6;

                    int first = sequence[0];
                    int last = sequence[sequence.length - 1];
                    int mid = sequence[sequence.length / 2];
                    int[] random = DataGenerator.pickRandomExisting(sequence, 3);
                    int non = -999999;

                    long total = 0;

                    start = System.nanoTime(); avl.search(first); end = System.nanoTime(); total += end - start;
                    start = System.nanoTime(); avl.search(last);  end = System.nanoTime(); total += end - start;
                    start = System.nanoTime(); avl.search(mid);   end = System.nanoTime(); total += end - start;
                    for (int v : random) { start = System.nanoTime(); avl.search(v); end = System.nanoTime(); total += end - start; }
                    start = System.nanoTime(); avl.search(non);   end = System.nanoTime(); total += end - start;

                    searchAVL[r] = (total / 6.0) / 1e6;
                }

                System.out.printf("AVL - Insercao: %.4f ms\n", avg(insertAVL));
                System.out.printf("AVL - Busca: %.6f ms\n", avg(searchAVL));

                System.out.println("----------------------------------------");
            }
        }

        System.out.println("==FIM==");
    }

    static double avg(double[] a) {
        double s = 0;
        for (double x : a) s += x;
        return s / a.length;
    }
}
