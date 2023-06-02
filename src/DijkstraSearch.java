import java.util.*;

class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public void search(Vertex<V> start) {
        Map<Vertex<V>, Double> distance = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
        }

        distance.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDistance = distance.get(current) + weight;

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start.getData() + ":");
        for (Map.Entry<Vertex<V>, Double> entry : distance.entrySet()) {
            System.out.println("Vertex: " + entry.getKey().getData() + ", Distance: " + entry.getValue());
        }
    }
}
