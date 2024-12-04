import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    private static ArrayList<Edge> edges;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = scanner.nextInt();

        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();

            edges.add(new Edge(weight, u, v));
        }

        scanner.close();

        System.out.println(Arrays.toString(bellmanFord(start)));
    }

    public static int[] bellmanFord(int start) {
        int[] distance = new int[n];

        for (int i = 0; i < n; ++i) {
            distance[i] = Integer.MAX_VALUE / 3;
        }

        distance[start] = 0;

        for (int i = 0; i < n - 1; ++i) {
            for (Edge edge : edges) {
                distance[edge.to] = Math.min(distance[edge.from] + edge.weight, distance[edge.to]);
            }
        }

        // check for negative vertices
        for (Edge edge : edges) {
            if (distance[edge.from] + edge.weight < distance[edge.to]) {
                throw new IllegalStateException("Graph contains negative cycle!");
            }
        }

        return distance;
    }
}