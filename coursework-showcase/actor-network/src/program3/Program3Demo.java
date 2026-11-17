// Main demo file that prints a menu and then calls all classes and organizes everything

package program3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Program3Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 							// create scanner
		UndirectedWeightedGraph graph = new UndirectedWeightedGraph();		// create graph and mstFinder
		MinimumSpanningTree mstFinder = new MinimumSpanningTree();
		HashSet<Edge> mst = null;											// create the HashSet
		graph.buildGraph("src/actors.txt");									// upload file and load the graph
		
		
		
		while (true) {
			System.out.println("Enter your choice:");						// print menu
			System.out.println("1. Print out MST Information");
			System.out.println("2. Find Shortest path from one Actor to another");
			System.out.println("3. Find Longest path in MST");
			System.out.println("4. Exit");
			if(scanner.hasNextInt()) {										// make sure the input is an int
				int input = scanner.nextInt();
				switch (input) {											// starts the switch statement
				case 1:
					mst = mstFinder.getMinimumSpanningTree(graph);			// 
					HashSet<String> movies = new HashSet<>(); 
					
					int counter = 1;										// initializes a counter to keep track of size and for formatting
					
					System.out.println("Edges in MST:");
					System.out.println("---------------------");			// more printing out the menu
					for(Edge movie: mst) {									// for loop to go through the mst for every movie
						System.out.println(counter + ". " + movie.toString());  // print the counter and mst line
						movies.add(movie.getMovie());						// add the current movie to the movies HashSet
						counter ++;											// keep track of the count
					}
					System.out.println("\nList of movies to watch that covers all " + counter + " Actors: ");
					System.out.println("---------------------");			// more menu stuff
					counter = 1;											// reset counter
					for(String movie: movies) {								// for loop through movies HashSet
						System.out.println(counter + ". " + movie.toString());  // print the counter and movies line
						counter++;											// add up counter
					}
					break;
				case 2:
					scanner.nextLine();										// this starts the second case
					System.out.println("Enter starting actor:");			// just gets the data for the origin and the destination
					String origin = scanner.nextLine().trim();
					
					System.out.println("Enter destination actor:");
					String dest = scanner.nextLine().trim();
					
					if (!graph.getVertices().contains(origin) || !graph.getVertices().contains(dest)) { // If the vertices doesn't
						System.out.println("One or both actors do not exist in the graph.");
						continue; 											// I originally had this as a break and was
					}														// confused when it didn't work
					
					ShortestPath pathFinder = new ShortestPath();			// calls ShortestPath class to find the 
					pathFinder.computeShortestPath(graph, origin);			// shortest path function
					if(!pathFinder.hasPathTo(dest)) {
						System.out.println("No path exists");				// if no path exists it prints that
					}
					else {
						LinkedList<Edge> path = pathFinder.getPathTo(dest);	// gets the linked list and prints everything out
						for (Edge e : path) {
							System.out.println(e.getMainActor() + " acted with " + e.getOtherActor() + " in " + e.getMovie());
						}
						System.out.println("Number of hops: " + path.size());
					}
					break;
				case 3:														// this ones easy to call because I did everything
					if (mst == null) {										// in the minimumSpanningTree file
				        mst = mstFinder.getMinimumSpanningTree(graph);		// just need to call that class
				    }
				    mstFinder.findLongestPathInMST(mst);
				    break;
				case 4:
					scanner.close();										// if 4 is inputed, close the scanner and return
					return;													// else if outside 1-4 is inputed redo entry
				default:
					System.out.println("Invalid choice. Enter a number 1-4.");

				}
			}
		}
	}
}

