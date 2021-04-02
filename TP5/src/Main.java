import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		System.out.println("TP05 : Graphes");
		
		// Partie 1: A completer : Création du graphe
		
		//inserting Nodes
		int[] id = {0,1,2,3,4,5,6};
		String[] name = {"A", "B", "C", "D", "E", "F", "G"};
		List<Node> nodes = new ArrayList<Node>();
	
		for (int i = 0; i < 7; i ++) {
			nodes.add(new Node(id[i], name[i]));
		}
		g.setNodes(nodes);
		
		//Inserting Edges
		int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5, G = 6;
		
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(nodes.get(A), nodes.get(B), 2)); //A-B, 2
		edges.add(new Edge(nodes.get(A), nodes.get(C), 1)); //A-C, 1
		edges.add(new Edge(nodes.get(B), nodes.get(D), 1)); //B-D, 1
		edges.add(new Edge(nodes.get(B), nodes.get(C), 2)); //B-C, 2
		edges.add(new Edge(nodes.get(B), nodes.get(E), 3)); //B-E, 3
		edges.add(new Edge(nodes.get(C), nodes.get(D), 4)); //C-D, 4
		edges.add(new Edge(nodes.get(C), nodes.get(E), 3)); //C-E, 3
		edges.add(new Edge(nodes.get(C), nodes.get(F), 5)); //C-F, 5
		edges.add(new Edge(nodes.get(D), nodes.get(F), 6)); //D-F, 6
		edges.add(new Edge(nodes.get(D), nodes.get(G), 5)); //D-G, 5
		edges.add(new Edge(nodes.get(E), nodes.get(F), 1)); //E-F, 1
		edges.add(new Edge(nodes.get(F), nodes.get(G), 2)); //F-G, 2
		
		//the edges are 2-way so for each edge from A to B there is another that is from B to A
		int edgesSize = edges.size();
		for(int i = 0; i < edgesSize; i++) {
			edges.add(new Edge(edges.get(i).getDestination(),
					edges.get(i).getSource(), 
					edges.get(i).getDistance()));
		}
		
		g.setEdges(edges);
		
		//Print the graph
		for (int j = 0; j < g.getNodes().size(); j++) {
			System.out.print(g.getNodes().get(id[j]).getName() + " -> ");
			for (int i = 0; i <g.getEdgesGoingFrom(g.getNodes().get(id[j])).size(); i++) {
				System.out.print( g.getEdgesGoingFrom(g.getNodes().get(id[j])).get(i).getDestination().getName() + "(" + g.getEdgesGoingFrom(g.getNodes().get(id[j])).get(i).getDistance() +")");
				if (i != g.getEdgesGoingFrom(g.getNodes().get(id[j])).size()-1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		
		
		
		// Partie 2: A completer : Implémentation de l’algorithme Dijkstra
		
		Dijkstra d = new Dijkstra(g);
		
		d.findPath(g.getNodes().get(A), g.getNodes().get(G));
		
		d.showTable();

		// Partie 3 : Afficher le chemin le plus court
		System.out.println(d.printShortPath(g.getNodes().get(A), g.getNodes().get(G)/* Spécifiez les paramètres */));
	
	}
}
