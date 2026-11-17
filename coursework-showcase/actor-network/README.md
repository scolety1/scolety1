# Actor Network
**Java · Spring 2025 · Graph algorithms**

Find connections between actors through shared films, construct a spanning tree, and explore its longest path by number of edges.

## Code tour

1. [UndirectedWeightedGraph.java](src/program3/UndirectedWeightedGraph.java) reads actor–film pairs, groups actors by film, and builds adjacency lists.
2. [ShortestPath.java](src/program3/ShortestPath.java) uses a priority queue and distance relaxation, then reconstructs a route through predecessor edges.
3. [MinimumSpanningTree.java](src/program3/MinimumSpanningTree.java) builds a spanning tree using Kruskal's algorithm and component labels. Two depth-first traversals find a longest path within the selected tree.
4. [Program3Demo.java](src/program3/Program3Demo.java) connects these operations through an interactive menu.

[Edge.java](src/program3/Edge.java) and [PriorityVertex.java](src/program3/PriorityVertex.java) hold the graph and queue data.

## Run

From the repository root:

```sh
cd coursework-showcase/actor-network
javac -encoding UTF-8 -d build src/program3/*.java
java -cp build program3.Program3Demo
```

Choose **2**, then enter `Cillian Murphy` and `Emma Stone` to request a route using the supplied dataset. Choose **1** to inspect a spanning tree, **3** to explore its longest path, or **4** to exit.

## Engineering choices

All edges in this version have weight 1. Dijkstra's algorithm therefore finds a minimum-hop route; breadth-first search would also suit this dataset. The spanning-tree implementation tracks components by relabeling their members rather than using a disjoint-set structure. These choices make the underlying algorithms visible.

## Scope

This is the original coursework implementation. Equal-weight edges can produce different valid spanning trees. The longest-path routine assumes a nonempty tree and explores one component; it is not a general longest-path solver for arbitrary graphs. The console expects the documented numeric choices and well-formed data.

The files are preserved without algorithm rewrites. Original course period: Spring 2025, based on the source archive and my account of the coursework. [Source notes](../SOURCES.md) · [All projects](../README.md)
