// Builds an undirected weighted graph connecting actors to each other
// by movie/edges using adjacency lists.

package program3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;										// this is all the imports
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class UndirectedWeightedGraph {							// this is the public class

	private HashMap<String, LinkedList<Edge>> adjList;

	public UndirectedWeightedGraph() {
		this.adjList = new HashMap<>();
	}

	public void buildGraph(String filename) {					// builds the graph from an input file
		HashMap<String, List<String>> movieToActors = new HashMap<>();	// uses a map of movie -> list of actors
		try (Scanner scanner = new Scanner(new File(filename))) {		// then adds edges between each actors that 
			while (scanner.hasNextLine()) {								// was in the movie
				String line = scanner.nextLine();
				String[] parts = line.split("\\|");
				String actor = parts[0].trim();
				String movie = parts[1].trim();

				movieToActors.putIfAbsent(movie, new ArrayList<>());
				movieToActors.get(movie).add(actor);                	// adds the actor to the list of actors

			}

			for (String movie: movieToActors.keySet()) {				// goes through each movie
				List<String> actors = movieToActors.get(movie);

				for (int i = 0; i < actors.size(); i++) {
					for (int j = 0; j < actors.size(); j++) {
						if (i != j) {
							String actorA = actors.get(i);
							String actorB = actors.get(j);				// this creates the edge between the actors
							Edge edge = new Edge(actorA, actorB, movie);

							adjList.putIfAbsent(actorA, new LinkedList<>());
							if (!containsEdge(adjList.get(actorA), edge)) {	// adds actorA to adjacency list
								adjList.get(actorA).add(edge);			// only adds edge if it doesn't already exist for the movie
							}
						}
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		}
	}

	public void printGraph() {											// use this for debugging to see if everything gets added to the
		for (String actor : adjList.keySet()) {							// adjacency list correctly
			System.out.println(actor + ": " + adjList.get(actor));
		}
	}

	private boolean containsEdge(List<Edge> edges, Edge newEdge) {		// helper to check if an edge already exists in the list
		for (Edge edge : edges) {										// avoids duplicate edges
			if (edge.getOtherActor().equals(newEdge.getOtherActor()) && edge.getMovie().equals(newEdge.getMovie())) {
				return true;
			}
		}
		return false;
	}

	public List<Edge> getEdges() {										// returns a list of all unique edges in the graph
		List<Edge> allEdges = new ArrayList<>();
		HashSet<String> seen = new HashSet<>();							// avoids duplicates

		for (String actor : adjList.keySet()) {							
			for (Edge edge : adjList.get(actor)) {
				String key = actor + "-" + edge.getOtherActor() + "-" + edge.getMovie();
				String revKey = edge.getOtherActor() + "-" + actor + "-" + edge.getMovie();
				if (!seen.contains(key) && !seen.contains(revKey)) {
					allEdges.add(new Edge(actor, edge.getOtherActor(), edge.getMovie()));
					seen.add(key);
				}
			}															// this is just to make sure there isn't any duplicate edges
		}																// i also used it to format the prints
		return allEdges;
	}
	
	public List<String> getVertices() {									// getter for vertices
		return new ArrayList<>(adjList.keySet());
	}
	public List<Edge> getAdjacentEdges(String actor) {					// getter for adjacent edges
		return adjList.getOrDefault(actor, new LinkedList<>());
	}
}
