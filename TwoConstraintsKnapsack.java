public class TwoConstraintsKnapsack {

    public static void main(String[] args) {
        int[] value = {1, 2, 3};
        int[] weight = {6, 1, 1};
        int[] volume = {1, 5, 5};
        System.out.println(solve(value.length, 5, 4, value, weight, volume));
    }

    public static int solve(int n, int max_weight, int max_volume, int[] value, int[] weight, int[] volume) {
        int[][][] dp = new int[n + 1][max_weight + 1][max_volume + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= max_weight; ++j) {
                for (int k = 0; k <= max_volume; ++k) {
                    dp[i][j][k] = dp[i - 1][j][k];

                    if (j >= weight[i - 1] && k >= volume[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i - 1][j - weight[i - 1]][k - volume[i - 1]] + value[i - 1]);
                    }
                }
            }
        }

        return dp[n][max_weight][max_volume];
    }
}
