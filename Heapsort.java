public class Heapsort {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        int[] values = {5, 3, 4, 1, 2};
        heap.buildHeap(values);
        for (int i = 0; i < values.length; ++i) {
            System.out.print(heap.popMax() + " ");
        }
        System.out.println();
    }
}
