import java.util.*;

class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void search(Vertex<V> start) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        Queue<Vertex<V>> queue = new LinkedList<>();

        visited[graph.getVertices().indexOf(start)] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            System.out.println("Visited vertex: " + current.getData());

            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                int index = graph.getVertices().indexOf(neighbor);
                if (index != -1 && !visited[index]) {
                    visited[index] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
