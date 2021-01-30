public class Quicksort {
    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 2, 4 };
        quicksort(values, 0, values.length);

        for (int i : values) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quicksort(int[] data, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int pivot = data[left];
        int leftPartitionLength = 0;
        int rightPartitionLength = 0;
        int index = left;

        while (index < right - rightPartitionLength) {
            if (data[index] > pivot) {
                rightPartitionLength++;
                swap(data, index, right - rightPartitionLength);
            } else if (data[index] < pivot) {
                swap(data, index, left + leftPartitionLength);
                leftPartitionLength++;
                index++;
            } else {
                index++;
            }
        }

        quicksort(data, left, left + leftPartitionLength);
        quicksort(data, right - rightPartitionLength, right);
    }

    private static void swap(int[] data, int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
