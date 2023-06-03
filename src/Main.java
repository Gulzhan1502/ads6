import java.util.*;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);

        System.out.println("Dijkstra:");
        Search<String> dijkstra = new DijkstraSearch<>(graph, almaty);
        outputPath(dijkstra, kyzylorda);

        System.out.println("\nDFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, almaty);
        outputPath(dfs, kyzylorda);

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, almaty);
        outputPath(bfs, kyzylorda);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        List<Vertex<String>> path = search.pathTo(key);
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            for (Vertex<String> v : path) {
                System.out.print(v.getData() + " -> ");
            }
        }
        System.out.println(key.getData());
    }
}

