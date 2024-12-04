public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] values = {1, 3, 4, 2, 0, 7, 5, 6};
        System.out.println(longestIncreasingSubsequence(values));
    }

    public static int longestIncreasingSubsequence(int[] data) {
        int n = data.length;
        int[] dp = new int[n];

        int globalMax = 0;

        for (int i = 0; i < n; ++i) {
            int localMax = 0;
            for (int j = i; j >= 0; --j) {
                if (data[j] < data[i]) {
                    localMax = Math.max(localMax, dp[j]);
                }
            }
            dp[i] = localMax + 1;
            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
    }
}
