import java.util.ArrayList;

/**
 * BellmanFord
 */
public class BellmanFord {
    ArrayList<Edge> edges;
    int n;

    public int[] bellmandFord(int start) {
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