public class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (Math.random() > 0.5) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}