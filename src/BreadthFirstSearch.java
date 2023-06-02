import java.util.*;

class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void search(Vertex<V> start) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited[start.hashCode()] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            System.out.println("Visited vertex: " + current.getData());

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited[neighbor.hashCode()]) {
                    visited[neighbor.hashCode()] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
