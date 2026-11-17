// This is just a node to set up the Edges to connect two actors
// by their shared movie

package program3;

public class Edge implements Comparable<Edge>{

	private String mainActor;
	private String otherActor;					// the first and second actor in the edge		
	private String movie;						// the movie/edge that connects them
	private int weight = 1;						// because it's unweighted each is weighted 1
	
	public Edge(String mainActor, String otherActor, String movie) {
		this.mainActor = mainActor;
		this.otherActor = otherActor;			// initializes everything
		this.movie = movie;
	}
	
	public String getMainActor() { 				// getter for the main actor
		return mainActor; 
	}
	public String getOtherActor() { 			// getter for the other actor
		return otherActor; 
	}
	public String getMovie() { 					// getter for the movie
		return movie; 
	}
	public int getWeight() { 					// getter for the weight
		return weight; 
	}
	

	@Override
	public String toString() {					// this formats everything nice
		return mainActor + " - " + otherActor + " (" + movie + ")";
	}

	@Override
	public int compareTo(Edge other) {			// needed for kruskal's algorithm
		return Integer.compare(this.weight, other.weight);	// must be defined for comparable interface
	}											//since all edges are weighted 1, this treats edges as equals
	
}
