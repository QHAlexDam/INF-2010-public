import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> nodes; // Noeuds
	private List<Edge> edges; // Les arcs
	
	//Constructor
	public Graph() {
		nodes = new ArrayList<>();
        edges = new ArrayList<>();
	}
	
	//retourner tous les chemins allant d’un nœud « source »
	public List<Edge> getEdgesGoingFrom(Node source) {
		// A complÃ¨ter 
		List<Edge> tempEdges = new ArrayList<Edge>();
		
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getSource().equals(source)) {
				tempEdges.add(edges.get(i));
			}
		}
		return tempEdges;
		
	}
	
	// qui permet de trouver toutles chemins allant vers un node « Dest ».
	public List<Edge> getEdgesGoingTo(Node dest) {
		// A complÃ¨ter 
		List<Edge> tempEdges = new ArrayList<Edge>();
		
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getDestination().equals(dest)) {
				tempEdges.add(edges.get(i));
			}
		}
		return tempEdges;
	}
	
	// Accesseurs 
	public List<Node> getNodes() {
		return nodes;
	}
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
}
