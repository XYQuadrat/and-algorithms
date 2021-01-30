import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Dijkstra {
    private static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        while (scanner.hasNext()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.get(u).add(new Edge(weight, v));
        }

        scanner.close();

        int[] distance = dijkstra(0, graph.size());
        for (int x : distance) {
            System.out.println(x);
        }
    }

    private static int[] dijkstra(int start, int n) {
        Queue<Edge> queue = new PriorityQueue<Edge>();
        queue.add(new Edge(start, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (dist[current.pos] != -1 && dist[current.pos] < current.distance)
                continue;

            for (Edge next : graph.get(current.pos)) {
                if (dist[next.pos] != 1 && dist[current.pos] + next.distance > dist[next.pos]) {
                    continue;
                }

                dist[next.pos] = dist[current.pos] + next.distance;
                queue.add(new Edge(-dist[next.pos], next.pos));
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int distance;
        int pos;

        Edge(int distance, int pos) {
            this.distance = distance;
            this.pos = pos;
        }

        @Override
        public int compareTo(Edge b) {
            return this.distance - b.distance;
        }
    }
}
