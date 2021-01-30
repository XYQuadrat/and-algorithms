import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n];

        while (scanner.hasNext()) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.get(u).add(v);
        }

        scanner.close();

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                bfs(i);
            }
            for (boolean isVisited : visited) {
                System.out.print(isVisited + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            visited[pos] = true;

            for (int neighbor : graph.get(pos)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
