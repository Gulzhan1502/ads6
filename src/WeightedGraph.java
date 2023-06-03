import java.util.*;
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map;

    public WeightedGraph() {
        map = new HashMap<>();
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        Edge<V> edge = new Edge<>(source, dest, weight);
        map.computeIfAbsent(source, k -> new ArrayList<>()).add(edge);
    }

    public Map<Vertex<V>, List<Edge<V>>> getMap() {
        return map;
    }
}