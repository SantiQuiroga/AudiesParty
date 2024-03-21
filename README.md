The chosen algorithm is a variant of the Kruskal's algorithm, which is a greedy algorithm used for finding the Minimum Spanning Tree (MST) of a graph. The algorithm is chosen because it efficiently finds the MST in a graph, which is useful in this case where we want to find the minimum set of connections that connects all nodes (parties).

The correctness of Kruskal's algorithm is well-established. It works by sorting all the edges (connections) from the least to the most expensive, and then it adds them to the MST in order, as long as the edge doesn't form a cycle with the MST formed so far. The algorithm is greedy because it makes the best choice (the least expensive edge) at each step.

The time complexity of the solution is primarily determined by the sorting operation and the Union-Find operations. 

1. Sorting the connections takes O(E log E) time, where E is the number of edges (connections).
2. For each connection, we perform Union and Find operations. In the worst case, these operations can take O(E log V) time, where V is the number of vertices (nodes).

Therefore, the overall time complexity of the solution is O(E log E) + O(E log V), which simplifies to O(E log E) as E can be at most V^2 and hence log(E) is greater than log(V) for large values of V.
