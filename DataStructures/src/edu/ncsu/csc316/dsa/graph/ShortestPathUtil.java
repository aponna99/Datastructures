package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;
import edu.ncsu.csc316.dsa.priority_queue.AdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.HeapAdaptablePriorityQueue;
import edu.ncsu.csc316.dsa.priority_queue.PriorityQueue.Entry;
import edu.ncsu.csc316.dsa.set.HashSet;
import edu.ncsu.csc316.dsa.set.Set;

/**
 * Shortest Path Util
 * 
 * @author Anisha Ponnapati
 *
 */
public class ShortestPathUtil {

	/**
	 * Dijkstra
	 * 
	 * @param g   Graph
	 * @param src Vertex
	 * @param     <V> vertex
	 * @param     <E> edge
	 * @return Map
	 */
	public static <V, E extends Weighted> Map<Vertex<V>, Integer> dijkstra(Graph<V, E> g, Vertex<V> src) {
		Map<Vertex<V>, Integer> m = new LinearProbingHashMap<Vertex<V>, Integer>();
		AdaptablePriorityQueue<Integer, Vertex<V>> pq = new HeapAdaptablePriorityQueue<>();
		Set<Vertex<V>> known = new HashSet<>();
		Map<Vertex<V>, Entry<Integer, Vertex<V>>> pqEntries = new LinearProbingHashMap<>();
		Map<Vertex<V>, Integer> lpm = new LinearProbingHashMap<>();

		for (Vertex<V> v : g.vertices()) {
			if (v.equals(src)) {
				lpm.put(v, 0);
			} else {
				lpm.put(v, Integer.MAX_VALUE);
			}
			pqEntries.put(v, pq.insert(lpm.get(v), v));
		}

		while (!pq.isEmpty()) {
			Entry<Integer, Vertex<V>> entry = pq.deleteMin();
			int k = entry.getKey();
			Vertex<V> u = entry.getValue();
			m.put(u, k);
			known.add(u);
			for (Edge<E> e : g.outgoingEdges(u)) {
				Vertex<V> v = g.opposite(u, e);

				int r = e.getElement().getWeight() + lpm.get(u);
				if (!known.contains(v) && r < lpm.get(v)) {
					lpm.put(v, r);
					pq.replaceKey(pqEntries.get(v), r);
				}

			}
		}
		return m;
	}

	/**
	 * Shortest path tree
	 * 
	 * @param g         Graph
	 * @param s         Vertex
	 * @param distances Distance
	 * @param           <V> vertex
	 * @param           <E> edge
	 * @return Map
	 */
	public static <V, E extends Weighted> Map<Vertex<V>, Edge<E>> shortestPathTree(Graph<V, E> g, Vertex<V> s,
			Map<Vertex<V>, Integer> distances) {
		Map<Vertex<V>, Edge<E>> m = new LinearProbingHashMap<Vertex<V>, Edge<E>>();
		for (Vertex<V> v : distances)
			if (v != s)
				for (Edge<E> e : g.incomingEdges(v)) {
					Vertex<V> u = g.opposite(v, e);
					if (distances.get(v) == distances.get(u) + e.getElement().getWeight())
						m.put(v, e);
				}
		return m;
	}
}