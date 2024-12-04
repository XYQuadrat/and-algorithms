import java.util.ArrayList;
import java.util.Scanner;

public class FloydWarshall {
    private static ArrayList<Edge> edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        edges = new ArrayList<>();

        while (scanner.hasNext()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();

            edges.add(new Edge(weight, u, v));
        }

        scanner.close();

        int[][] distance = floydWarshall(n);
        for (int x : distance[0]) {
            System.out.println(x);
        }
    }

    private static int[][] floydWarshall(int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // If you use Integer.MAX_VALUE, there are overflows
                dp[i][j] = i == j ? 0 : 10000000;
            }
        }

        for (Edge edge : edges) {
            dp[edge.from][edge.to] = Math.min(dp[edge.from][edge.to], edge.weight);
        }

        for (int i = 0; i < n; ++i) {
            for (int u = 0; u < n; ++u) {
                for (int v = 0; v < n; ++v) {
                    dp[u][v] = Math.min(dp[u][v], dp[u][i] + dp[i][v]);
                }
            }
        }

        return dp;
    }
}
