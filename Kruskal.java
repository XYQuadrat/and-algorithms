import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {
    public static ArrayList<Edge> edges;

    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        edges = new ArrayList<Edge>();
        for (int i = 0; i < m; ++i) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        scanner.close();
        ArrayList<Edge> mst = kruskal(n, m);
        for (Edge edge : mst) {
            System.out.println(edge);
        }
    }

    public static ArrayList<Edge> kruskal(int n, int m) {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        UnionFind unionFind = new UnionFind(n);

        Collections.sort(edges);

        for (Edge edge : edges) {
            if (unionFind.find(edge.from) == unionFind.find(edge.to))
                continue;

            mst.add(edge);
            unionFind.union(edge.from, edge.to);
        }

        return mst;
    }

}
