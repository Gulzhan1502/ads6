import java.util.*;
class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public void search(Vertex<V> start) {
        PriorityQueue<Edge<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(Edge::getWeight));
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previousVertices = new HashMap<>();

        // Initialize distances
        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        queue.offer(new Edge<>(null, start, 0.0));

        while (!queue.isEmpty()) {
            Edge<V> edge = queue.poll();
            Vertex<V> current = edge.getDestination();

            if (distances.get(current) < edge.getWeight()) {
                continue;
            }

            for (Edge<V> nextEdge : graph.getEdges(current)) {
                Vertex<V> next = nextEdge.getDestination();
                double newDistance = distances.get(current) + nextEdge.getWeight();

                if (newDistance < distances.get(next)) {
                    distances.put(next, newDistance);
                    previousVertices.put(next, current);
                    queue.offer(new Edge<>(current, next, newDistance));
                }
            }
        }

        for (Vertex<V> vertex : graph.getVertices()) {
            if (!vertex.equals(start)) {
                System.out.println("Shortest path to " + vertex.getData() + ":");
                printShortestPath(vertex, previousVertices);
                System.out.println();
            }
        }
    }

    private void printShortestPath(Vertex<V> vertex, Map<Vertex<V>, Vertex<V>> previousVertices) {
        Stack<Vertex<V>> stack = new Stack<>();
        stack.push(vertex);

        while (previousVertices.containsKey(vertex)) {
            vertex = previousVertices.get(vertex);
            stack.push(vertex);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getData() + " ");
        }
    }
}