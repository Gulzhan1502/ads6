import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;
    private Vertex<V> start;
    private Map<Vertex<V>, Double> distances;
    private Map<Vertex<V>, Vertex<V>> predecessors;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.graph = graph;
        this.start = start;
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();
        performDijkstra();
    }

    private void performDijkstra() {
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::getOrDefault));

        for (Vertex<V> vertex : graph.getMap().keySet()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
            queue.offer(vertex);
        }

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Edge<V> edge : graph.getMap().getOrDefault(current, Collections.emptyList())) {
                Vertex<V> neighbor = edge.getDest();
                double distanceThroughCurrent = distances.getOrDefault(current, 0.0) + edge.getWeight();

                if (distanceThroughCurrent < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    queue.remove(neighbor);
                    distances.put(neighbor, distanceThroughCurrent);
                    predecessors.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public List<Vertex<V>> pathTo(Vertex<V> key) {
        if (!distances.containsKey(key))
            return Collections.emptyList();

        List<Vertex<V>> path = new ArrayList<>();
        Vertex<V> current = key;

        while (current != null) {
            path.add(0, current);
            current = predecessors.get(current);
        }

        return path;
    }
}
