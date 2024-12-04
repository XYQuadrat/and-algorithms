import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] values = {6, 1, 2, 3, 4, 4, 0};
        mergeSort(values);

        for (int i : values) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void merge(int[] left, int[] right, int[] data) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                data[k++] = left[i++];
            } else {
                data[k++] = right[j++];
            }
        }

        // fill in remaining values
        while (i < left.length) {
            data[k++] = left[i++];
        }

        while (j < right.length) {
            data[k++] = right[j++];
        }
    }

    public static void mergeSort(int[] data) {
        if (data.length < 2) {
            return;
        }

        int[] left = Arrays.copyOf(data, data.length / 2);
        int[] right = Arrays.copyOfRange(data, left.length, data.length);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, data);
    }
}
