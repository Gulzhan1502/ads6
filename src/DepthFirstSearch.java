import java.util.*;

class DepthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    DepthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void search(Vertex<V> start) {
        boolean[] visited = new boolean[graph.getVertices().size()];
        dfs(start, visited);
    }

    private void dfs(Vertex<V> vertex, boolean[] visited) {
        visited[vertex.hashCode()] = true;
        System.out.println("Visited vertex: " + vertex.getData());

        for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
            if (!visited[neighbor.hashCode()]) {
                dfs(neighbor, visited);
            }
        }
    }
}
