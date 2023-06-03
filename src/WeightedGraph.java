import java.util.*;
class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> graph;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.graph = new HashMap<>();
        this.directed = directed;
    }

    public void addVertex(Vertex<V> vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        List<Edge<V>> edges = graph.get(source);
        edges.add(new Edge<>(source, destination, weight));

        if (!directed) {
            // If undirected graph, add reverse edge as well
            edges = graph.get(destination);
            edges.add(new Edge<>(destination, source, weight));
        }
    }

    public List<Edge<V>> getEdges(Vertex<V> vertex) {
        return graph.get(vertex);
    }
    public List<Vertex<V>> getVertices() {
        return new ArrayList<>(graph.keySet());
    }
}
