import java.util.*;
public class DepthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Vertex<V> start;
    private Set<Vertex<V>> visited;
    private Map<Vertex<V>, Vertex<V>> pathTo;

    public DepthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.graph = graph;
        this.start = start;
        this.visited = new HashSet<>();
        this.pathTo = new HashMap<>();
    }

    public List<Vertex<V>> pathTo(Vertex<V> key) {
        Vertex<V> keyVertex = key;

        if (start == null || keyVertex == null)
            return Collections.emptyList();

        dfs(start);

        return buildPath(keyVertex);
    }

    private void dfs(Vertex<V> vertex) {
        visited.add(vertex);

        for (Edge<V> edge : graph.getMap().get(vertex)) {
            Vertex<V> neighbor = edge.getDest();
            if (!visited.contains(neighbor)) {
                pathTo.put(neighbor, vertex);
                dfs(neighbor);
            }
        }
    }

    private List<Vertex<V>> buildPath(Vertex<V> keyVertex) {
        List<Vertex<V>> result = new ArrayList<>();
        Vertex<V> current = keyVertex;

        while (current != null) {
            result.add(0, current);
            current = pathTo.get(current);
        }

        return result;
    }
}
