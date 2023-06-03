public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(false);

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);
        graph.addVertex(vertexF);

        graph.addEdge(vertexA, vertexB, 0.5);
        graph.addEdge(vertexA, vertexC, 1);
        graph.addEdge(vertexC, vertexE, 4);
        graph.addEdge(vertexE, vertexB, 4);
        graph.addEdge(vertexE, vertexF, 1);
        graph.addEdge(vertexD, vertexF, 1);
        graph.addEdge(vertexC, vertexD, 1);

        System.out.println("Breadth First Search:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        bfs.search(vertexA);

        System.out.println("\nDijkstra Search:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        dijkstra.search(vertexA);
    }
}