public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> v0 = new Vertex<>("A");
        Vertex<String> v1 = new Vertex<>("B");
        Vertex<String> v2 = new Vertex<>("C");
        Vertex<String> v3 = new Vertex<>("D");

        v0.addAdjacentVertex(v1, 2.0);
        v0.addAdjacentVertex(v2, 4.0);
        v1.addAdjacentVertex(v2, 1.0);
        v1.addAdjacentVertex(v3, 5.0);
        v2.addAdjacentVertex(v3, 3.0);

        graph.addVertex(v0);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("BFS:");
        bfs.search(v0);

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("\nDijkstra:");
        dijkstra.search(v0);
    }
}
