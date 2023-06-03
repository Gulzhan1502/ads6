import java.util.*;
public class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Vertex<V> start;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.graph = graph;
        this.start = start;
    }

    public List<Vertex<V>> pathTo(Vertex<V> key) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        Map<Vertex<V>, Vertex<V>> path = new HashMap<>();
        Vertex<V> keyVertex = key;

        if (start == null || keyVertex == null)
            return Collections.emptyList();

        queue.offer(start);
        path.put(start, null);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(keyVertex)) {
                return buildPath(path, keyVertex);
            }

            for (Edge<V> edge : graph.getMap().get(current)) {
                Vertex<V> neighbor = edge.getDest();
                if (!path.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    path.put(neighbor, current);
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Vertex<V>> buildPath(Map<Vertex<V>, Vertex<V>> path, Vertex<V> keyVertex) {
        List<Vertex<V>> result = new ArrayList<>();
        Vertex<V> current = keyVertex;

        while (current != null) {
            result.add(0, current);
            current = path.get(current);
        }

        return result;
    }
}