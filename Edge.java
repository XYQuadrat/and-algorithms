public class Edge implements Comparable<Edge> {
    int weight;
    int from;
    int to;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int compareTo(Edge b) {
        return weight - b.weight;
    }

    @Override
    public String toString() {
        return "Edge from " + from + " to " + to + ", weight " + weight;
    }
}