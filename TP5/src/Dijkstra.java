import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;



public class Dijkstra {

	private Graph graph;
	private Map<Node, Edge> dijkstraTable[];
	private Stack<Edge> path;
	private Map<Node, Edge> dijkstraTab;
	

	public Dijkstra (Graph g) {
		this.graph = g;
	}

	//find path between node s and d
	public void findPath(Node s, Node d) {

		//dijkstraTable = new HashMap[graph.getNodes().size()];
		dijkstraTab = new HashMap(); // on a pas reussi a implementer le tableau de Map de taille predefinie
		path = new Stack<Edge>();
		
		// A compléte
        List<Node> nextNodes = new ArrayList<>(); // nodes pas encore parcouru
		List<Node> accessedNodes = new ArrayList<>(); // nodes deja parcourus
		Node currentNode; //node actuel
		Map<Node, Integer> totalNodeDistance = new HashMap(); // distance de source jusqu'au node
		boolean accessed; //si node a deja ete parcouru ou non
		int dist;
		
		//setting nodes with distance to infinity
		for (int i = 0; i < graph.getNodes().size(); i++) {
			totalNodeDistance.put(graph.getNodes().get(i), (int)Double.POSITIVE_INFINITY);
			//dijkstraTab.put(graph.getNodes().get(i), new Edge (graph.getNodes().get(i), graph.getNodes().get(i), (int)Double.POSITIVE_INFINITY));
		}
		
		//first node with edge to self and distance = 0
		dijkstraTab.replace(s, new Edge (s,s,0));
		totalNodeDistance.replace(s, 0);
		nextNodes.add(s); // add first node to go to
		
		
		while (!nextNodes.isEmpty()) {
			
			currentNode = nextNodes.get(0);
			
			for (int i = 0; i < nextNodes.size(); i++) {
				//is the nextNode closer to the current?
				if (totalNodeDistance.get(nextNodes.get(i)) < totalNodeDistance.get(currentNode)) {
					currentNode = nextNodes.get(i);
				}
			}
			
			if (currentNode.equals(d)) {
				break; // got to destination
			}
			nextNodes.remove(currentNode);
			accessedNodes.add(currentNode);
			
			for (int i = 0; i < graph.getEdgesGoingFrom(currentNode).size(); i++) {
				accessed = false;
				for (int j = 0; j < accessedNodes.size(); j++) {
					if (graph.getEdgesGoingFrom(currentNode).get(i).getDestination().equals(accessedNodes.get(j))) {
						accessed = true;
						break;
					}
				}
				if (!accessed) {
					//getMinimum(map)
					
					dist = totalNodeDistance.get(currentNode) + graph.getEdgesGoingFrom(currentNode).get(i).getDistance();
					
					if (dist < totalNodeDistance.get(graph.getEdgesGoingFrom(currentNode).get(i).getDestination())){
						totalNodeDistance.replace(graph.getEdgesGoingFrom(currentNode).get(i).getDestination(), dist);
						
						nextNodes.add(graph.getEdgesGoingFrom(currentNode).get(i).getDestination());
						
						path.add(graph.getEdgesGoingFrom(currentNode).get(i));
						
						dijkstraTab.replace(graph.getEdgesGoingFrom(currentNode).get(i).getDestination(), 
											new Edge(graph.getEdgesGoingFrom(currentNode).get(i).getDestination(),
													graph.getEdgesGoingFrom(currentNode).get(i).getSource(), 
													graph.getEdgesGoingFrom(currentNode).get(i).getDistance()));
					}
				}
			}		
		}
		
	}

	private Node getMinimum(Map<Node, Edge> map) {
		Edge min = null;
		for (Node Key : map.keySet()) {
			if ( min == null || map.get(Key).getDistance() < min.getDistance()) {
				min = map.get(Key); 
			}
		}
		return min.getDestination();
	}

	private Edge getMinimum (Edge e1, Edge e2) {
		// A completer
		if (e1.getDistance() <= e2.getDistance()) { // returning the 1st edge if both are equal distance
			return e1;
		}
		else {
			return e2;
		}
	}
	
	public String printShortPath(Node source, Node destination) {
		// A completer
		String shortestPath = new String();
		int totalDistance = 0;
		//shortestPath += source.getName();
		//shortestPath += " -> ";
		
		if (this.path.get(0).getSource().equals(source) && 
				this.path.get(this.path.size()-1).getDestination().equals(destination)) { //assures that path indeed goes from source to destination
			
			shortestPath += source.getName(); //starting node
			
			for (int i = 0; i < this.path.size(); i ++){	
				shortestPath += " -";
				shortestPath += this.path.get(i).getDistance();
				totalDistance += this.path.get(i).getDistance();
				shortestPath += "-> ";
				shortestPath += this.path.get(i).getDestination().getName();
				if (this.path.get(i).getDestination().equals(destination)) // assure d'arreter si on arrive a destination
					break;
			}
		}
		shortestPath += " the shortest path measures: ";
		shortestPath += totalDistance;
		
		return shortestPath;
	}

	public void showTable() {
		// A completer
		
	}
}
