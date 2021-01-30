public class EditDistance {
    public static void main(String[] args) {
        System.out.println(editDistance("TIGER", "ZIEGE"));
    }

    private static int editDistance(String a, String b) {
        int n = a.length() + 1;
        int m = b.length() + 1;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; ++i) {
            dp[i][0] = i;
        }

        for (int i = 0; i < m; ++i) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1),
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }

        return dp[n - 1][m - 1];
    }
}
