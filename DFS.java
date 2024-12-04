import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        graph = new ArrayList<>();
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
                dfsWithStack(i);
            }
            for (boolean isVisited : visited) {
                System.out.print(isVisited + " ");
            }
            System.out.println();
        }
    }

    public static void dfsRecursive(int pos) {
        visited[pos] = true;

        for (int neighbor : graph.get(pos)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor);
            }
        }
    }

    public static void dfsWithStack(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            int pos = stack.pop();
            visited[pos] = true;

            for (int neighbor : graph.get(pos)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
