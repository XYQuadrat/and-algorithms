import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
    ArrayList<ArrayList<Pair>> graph;

    public int prim() {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        boolean visited[] = new boolean[graph.size()];
        int weight = 0;

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            if (visited[current.index])
                continue;

            visited[current.index] = true;
            weight += current.value;

            for (Pair edge : graph.get(current.index)) {
                if (visited[edge.index])
                    continue;

                pq.add(edge);
            }
        }

        return weight;
    }

    static class Pair implements Comparable<Pair> {

        public int index;
        public int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.value < other.value) {
                return -1;
            } else if (this.value == other.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}