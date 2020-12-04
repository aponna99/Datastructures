/**
 * 
 */
package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test case
 * 
 * @author Anisha Ponnapati
 *
 */
public class GraphTraversalUtilTest {

	/**
	 * Test
	 */
	@Test
	public void test() {
		Graph<String, Integer> g = new AdjacencyMapGraph<String, Integer>();
		Vertex<String> v1 = g.insertVertex("Anisha");
		Vertex<String> v2 = g.insertVertex("Ishani");
		Vertex<String> v3 = g.insertVertex("Kelly");
		Vertex<String> v4 = g.insertVertex("Mani");
		Vertex<String> v5 = g.insertVertex("Keerthana");

		g.insertEdge(v1, v2, 2);
		g.insertEdge(v2, v3, 4);
		g.insertEdge(v3, v4, 8);
		g.insertEdge(v1, v3, 16);
		g.insertEdge(v2, v4, 32);
		g.insertEdge(v2, v5, 64);
		Map<Vertex<String>, Edge<Integer>> m = GraphTraversalUtil.breadthFirstSearch(g, v4);
		assertFalse(m.isEmpty());
		m = GraphTraversalUtil.depthFirstSearch(g, v1);
		assertFalse(m.isEmpty());
	}

}
