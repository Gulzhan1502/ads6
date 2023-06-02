import java.util.ArrayList;
import java.util.List;

class WeightedGraph<V> {
    private List<Vertex<V>> vertices;

    WeightedGraph() {
        this.vertices = new ArrayList<>();
    }

    void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    List<Vertex<V>> getVertices() {
        return vertices;
    }
}
