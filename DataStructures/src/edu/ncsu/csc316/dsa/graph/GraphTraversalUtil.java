package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;
import edu.ncsu.csc316.dsa.queue.Queue;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * Graph Traversal
 * 
 * @author Anisha Ponnapati
 * 
 */
public class GraphTraversalUtil {

	/**
	 * Depth first search
	 * 
	 * @param graph Graph
	 * @param start Start
	 * @param       <V> vertex
	 * @param       <E> edge
	 * @return Map
	 */
	public static <V, E> Map<Vertex<V>, Edge<E>> depthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
		Set<Vertex<V>> s = new HashSet<>();
		Map<Vertex<V>, Edge<E>> m = new LinearProbingHashMap<>();
		dfsHelper(graph, start, s, m);
		return m;
	}

	private static <V, E> void dfsHelper(Graph<V, E> graph, Vertex<V> u, Set<Vertex<V>> known,
			Map<Vertex<V>, Edge<E>> forest) {
		known.add(u);
		for (Edge<E> e : graph.outgoingEdges(u)) {
			Vertex<V> temp = graph.opposite(u, e);
			if (!known.contains(temp)) {
				forest.put(temp, e);
				dfsHelper(graph, temp, known, forest);
			}
		}
	}

	/**
	 * Breadth first search
	 * 
	 * @param graph Graph
	 * @param start Start
	 * @param       <V> vertex
	 * @param       <E> edge
	 * @return Map
	 */
	public static <V, E> Map<Vertex<V>, Edge<E>> breadthFirstSearch(Graph<V, E> graph, Vertex<V> start) {
		HashSet<Vertex<V>> s = new HashSet<Vertex<V>>();
		Map<Vertex<V>, Edge<E>> m = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
		Queue<Vertex<V>> q = new ArrayBasedQueue<Vertex<V>>();
		s.add(start);
		q.enqueue(start);

		while (!q.isEmpty()) {
			Vertex<V> u = q.dequeue();
			for (Edge<E> e : graph.outgoingEdges(u)) {
				Vertex<V> weight = graph.opposite(u, e);
				if (!s.contains(weight)) {
					m.put(weight, e);
					s.add(weight);
					q.enqueue(weight);
				}
			}

		}
		return m;
	}
}
