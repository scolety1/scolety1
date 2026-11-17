// Uses Dijkstra's algorithm to find the shortest path between two actors

package program3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath {

	private HashMap<String, Double> distance;								// stores shortest distance 
	private HashMap<String, Edge> previous;									// keep track of how we reach actors
	
	public void computeShortestPath(UndirectedWeightedGraph graph, String startActor) {
																			// Run's Dijkstra's algorithm
		distance = new HashMap<>();											// distance from startActor to each actor
		previous = new HashMap<>();											// stores the edge used to reach actors
		
		
		for (String actor : graph.getVertices()) {							// initializes all distances to infinity
			distance.put(actor, Double.POSITIVE_INFINITY);
		}
		distance.put(startActor, 0.0);
		
		
		//start Dijkistra's algorithm
		PriorityQueue<PriorityVertex> visitQueue = new PriorityQueue<>();
		visitQueue.add(new PriorityVertex(startActor, 0.0));
		
		
		while(!visitQueue.isEmpty()) {										// Dijkistra's core loop
			
			PriorityVertex currentVertex = visitQueue.poll();
			
			String currentActor = currentVertex.getActor();
			
			for(Edge edge: graph.getAdjacentEdges(currentActor)) {			// as it goes through the graph
				String neighborVertex = edge.getOtherActor();				// get nieghbors and edges		
				double newDistance = distance.get(currentActor) + edge.getWeight();

				//currentVertex = v
				//neighborVertex = v
				if(newDistance < distance.get(neighborVertex)) {
					//update our best estimate, remove any old instance from PQ, add new best estimates from stuff
					distance.put(neighborVertex, newDistance);
					previous.put(neighborVertex, new Edge(currentActor, neighborVertex, edge.getMovie()));
					
					visitQueue.add(new PriorityVertex(neighborVertex, newDistance));
				}															// add updated estimate to queue
			}
				
		}
		
		
	}
	
	public double distanceTo(String actor) {
		return distance.getOrDefault(actor, Double.POSITIVE_INFINITY);		// returns the shortest distance to given actor
	}

	public boolean hasPathTo(String actor) {								// checks if a path to the other actor exists
		return distance.containsKey(actor) && distance.get(actor) < Double.POSITIVE_INFINITY;
	}
	
	public LinkedList<Edge> getPathTo(String actor) {						// builds and returns the path (as a linked list)
																			// to the target actor
		if(!hasPathTo(actor)) {
			return null;													// checks if it has a valid path
		}
		else {
			LinkedList<Edge> path = new LinkedList<>();						// this walks backwards from destination to origin
			while (previous.containsKey(actor)) {							// using the previous map 
				Edge edge = previous.get(actor);
				path.addFirst(edge);
				actor = edge.getMainActor();
			}
			return path;
		}
	}
}
