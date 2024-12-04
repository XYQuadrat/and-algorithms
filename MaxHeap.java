public class MaxHeap {
    final static int MAX_CAPACITY = 10000;

    int[] heap;

    int size = 0;

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        int[] values = {3, 1, 5, 7, 9, 2};

        heap.buildHeap(values);
        heap.printHeap();
    }

    public void buildHeap(int[] values) {
        heap = new int[MAX_CAPACITY];

        size = values.length;
        for (int i = 0; i < size; ++i) {
            heap[i] = values[i];
        }

        for (int i = size / 2; i >= 0; --i) {
            restoreHeap(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; ++i) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void restoreHeap(int i) {
        while (2 * i + 1 < size) {
            int j = 2 * i + 1;

            if (j + 1 < size && heap[j] > heap[j + 1]) {
                ++j;
            }

            if (heap[i] < heap[j]) {
                return;
            }

            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public int popMax() {
        int value = heap[0];
        heap[0] = heap[--size];
        restoreHeap(0);
        return value;
    }

}
