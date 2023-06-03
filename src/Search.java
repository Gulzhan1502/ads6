import java.util.*;
public interface Search<V> {
    List<Vertex<V>> pathTo(Vertex<V> key);
}
