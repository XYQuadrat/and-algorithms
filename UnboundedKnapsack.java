public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] value = {1, 10};
        int[] weight = {1, 5};
        System.out.println(solve(value.length, 4, value, weight));
    }

    public static int solve(int n, int size, int[] value, int[] weight) {
        int[] dp = new int[size + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (j >= weight[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
                }
            }
        }

        return dp[size];
    }
}
