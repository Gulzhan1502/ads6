import java.util.HashMap;
import java.util.Map;

class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    V getData() {
        return data;
    }

    void setData(V data) {
        this.data = data;
    }

    void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
