// Uses Kruskal's algorithm to find the MST and uses Depth First to get the Longest Path

package program3;

import java.util.HashMap;
import java.util.HashSet;															// All imports
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

	public HashSet<Edge> getMinimumSpanningTree(UndirectedWeightedGraph graph) {

		HashSet<Edge> mst = new HashSet<Edge>();									// import and set Hashes
		HashMap<String, String> ccm = new HashMap<>();

		for(String actor : graph.getVertices()) {									// this goes through all actors and adds them to the connected component map 
			ccm.put(actor, actor);
		}

		PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(graph.getEdges());		// all edges go into a heap


		while(!edgeQueue.isEmpty()) {												// only add edges if it doesn't create a cycle

			Edge edge = edgeQueue.poll();
			String a = edge.getMainActor();
			String b = edge.getOtherActor();

			if(!ccm.get(a).equals(ccm.get(b))) {

				mst.add(edge);														// merge components: update all actors with old marker to the new one
				String newMarker = ccm.get(a);
				String oldMarker = ccm.get(b);

				for(String key: ccm.keySet()) {
					if(ccm.get(key).equals(oldMarker)) {
						ccm.put(key, newMarker);
					}
				}	
			}
		}
		return mst;

	}

	private HashMap<String, LinkedList<String>> buildMSTAdjList(HashSet<Edge> mst) {  	// Converts the MST into adj list
		HashMap<String, LinkedList<String>> adj = new HashMap<>();						// Need for DFS

		for (Edge edge : mst) {
			String a = edge.getMainActor();
			String b = edge.getOtherActor();

			adj.putIfAbsent(a, new LinkedList<>());
			adj.putIfAbsent(b, new LinkedList<>());								// if empty it adds the edge

			adj.get(a).add(b);
			adj.get(b).add(a);													// undirected edge, so it goes both ways
		}

		return adj;
	}

	private class DFSResult {													// helper class to store the result of a DFS search

		String actor;															// initializes the variables
		int distance;
		LinkedList<String> path;

		DFSResult(String actor, int distance, LinkedList<String> path) {
			this.actor = actor;
			this.distance = distance;
			this.path = new LinkedList<>(path);									// copies the path
		}
	}

	private DFSResult dfsWithPath(HashMap<String, LinkedList<String>> adj, String current, HashSet<String> visited, int depth, LinkedList<String> path) {
		visited.add(current);
		path.add(current);														// this provides the print

		DFSResult farthest = new DFSResult(current, depth, path);				// this stores the best path

		for (String neighbor : adj.getOrDefault(current, new LinkedList<>())) {
			if (!visited.contains(neighbor)) {									// if it didn't visit neighbors
				DFSResult result = dfsWithPath(adj, neighbor, new HashSet<>(visited), depth + 1, new LinkedList<>(path));
				if (result.distance > farthest.distance) {
					farthest = result;											// updates the best path if this path is longer
				}
			}
		}

		return farthest;
	}


	public void findLongestPathInMST(HashSet<Edge> mst) {						// this function is for finding the longest path
		HashMap<String, LinkedList<String>> adj = buildMSTAdjList(mst);


		String start = adj.keySet().iterator().next();							// starts with any actor

																				// first is to find the farthest actor from starting point
		DFSResult first = dfsWithPath(adj, start, new HashSet<>(), 0, new LinkedList<>());

																				// second is to find the longest path
		DFSResult second = dfsWithPath(adj, first.actor, new HashSet<>(), 0, new LinkedList<>());

		// Print full path
		System.out.print("Longest path in the MST is: ");
		System.out.print("[");
		for (int i = 0; i < second.path.size(); i++) {
			System.out.print(second.path.get(i));
			if (i < second.path.size() - 1) System.out.print(" --> ");			// this just prints everything out and formats it
		}
		System.out.println("]");
		System.out.println("Number of Hops: " + second.distance);
	}



}
