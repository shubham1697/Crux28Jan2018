package lec25apr28.Graph;

public class Graph_Client {

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
//		graph.addVertex("E");
//		graph.addVertex("F");
//		graph.addVertex("G");
		
		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 10);
		graph.addEdge("B", "C", 2);
		graph.addEdge("D", "C", 3);
//		graph.addEdge("E", "D", 4);
//		graph.addEdge("F", "E", 5);
//		graph.addEdge("E", "G", 12);
//		graph.addEdge("G", "F", 4);
				
//		graph.removeVertex("D");
		
		graph.display();
//		System.out.println(graph.hasPath("A", "G", new HashMap<>()));
//		System.out.println(graph.bfs("A", "G"));
//		System.out.println(graph.dfs("A", "G"));
//		System.out.println();
//		graph.dft();
//		System.out.println();
//		graph.bft();
		System.out.println();
		System.out.println("isConnected: " + graph.isConnected());
		
		System.out.println("isCyclic: " + graph.isCyclic());
		
		System.out.println(graph.getConnectedCompArrayList());
		System.out.println("isTree: " + graph.isTree());
		System.out.println("isBipartite: " + graph.biPartite());

		
	}

}
