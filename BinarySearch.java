/**
 * BinarySearch
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,3,5,6};
        System.out.println(binarySearch(array, 6));
    }

    // Returns the (0-based) index of the key element
    // Returns -1 if not found
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length;

        while(left <= right){
            // Computing the average with overflow protection
            int mid = left + (right - left) / 2;

            if(array[mid] == key){
                return mid;
            } else if (array[mid] < key){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}