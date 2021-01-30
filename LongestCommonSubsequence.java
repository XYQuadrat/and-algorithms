public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("TIGER", "ZIEGE"));
    }

    public static String longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String lcs = backtrackLCS(dp, a, b, n - 1, m - 1);

        return lcs;
    }

    private static String backtrackLCS(int[][] dp, String a, String b, int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        } else if (a.charAt(i) == b.charAt(j)) {
            return backtrackLCS(dp, a, b, i - 1, j - 1) + a.charAt(i);
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            return backtrackLCS(dp, a, b, i - 1, j);
        } else {
            return backtrackLCS(dp, a, b, i, j - 1);
        }
    }
}
