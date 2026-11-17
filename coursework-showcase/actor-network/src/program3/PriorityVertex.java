// Helper class for Dijkstra's algorithm. Used for comparing distances

package program3;

public class PriorityVertex implements Comparable<PriorityVertex> {
	private String actor;									// this class is used in Dijikstra's algorithm
	private double priority;								// basically just used in min heap

	public PriorityVertex(String startActor, double d) {

		this.actor = startActor;							// gets the actors variable and initializes
		this.priority = d;									// current best known distance from startActor to this acto
	}
	
	public String getActor() {								// getter for actor's name
		return actor;
	}

	@Override
	public int compareTo(PriorityVertex o) {				// allows PrioritQueue to order these vertices by their distance
		// TODO Auto-generated method stub					// so the smallest verte gets polled first
		return Double.compare(this.priority, o.priority);
	}

}
