/**
 * 
 */
package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.map.Map;

/**
 * Test Class 
 * 
 * @author Anisha Ponnapati
 *
 */
public class ShortestPathUtilTest {
	private Graph<String, Highway> g;

	/**
	 * Sets up graph for testing
	 */
	@Before
	public void setUp() {
		g = new AdjacencyListGraph<String, Highway>(false);
	}

	/**
	 * Test
	 */
	@SuppressWarnings("static-access")
	@Test
	public void test() {
		Vertex<String> v1 = g.insertVertex("Anisha");
		Vertex<String> v2 = g.insertVertex("Ishani");
		Vertex<String> v3 = g.insertVertex("Kelly");
		Vertex<String> v4 = g.insertVertex("Mani");
		Vertex<String> v5 = g.insertVertex("Keerthana");

		g.insertEdge(v1, v2, new Highway("f1", 2));
		g.insertEdge(v1, v3, new Highway("f2", 4));
		g.insertEdge(v1, v4, new Highway("f3", 8));
		g.insertEdge(v3, v5, new Highway("f4", 16));
		g.insertEdge(v5, v3, new Highway("f5", 32));

		Map<Vertex<String>, Integer> map = new ShortestPathUtil().dijkstra(g, v1);
		assertEquals(20, (int) map.get(v5));

		Map<Vertex<String>, Integer> edges = ShortestPathUtil.dijkstra(g, v1);

		Map<Vertex<String>, Edge<Highway>> mEdges = ShortestPathUtil.shortestPathTree(g, v1, edges);

		assertEquals(4, mEdges.get(v3).getElement().getWeight());

	}

	/**
	 * Inner class
	 */
	public class Highway implements Weighted {

		@SuppressWarnings("unused")
		private String name;

		private int length;

		/**
		 * Constructor
		 *
		 * @param n n
		 * @param l one
		 */
		public Highway(String n, int l) {
			setName(n);
			setLength(l);
		}

		/**
		 * Sets the name
		 *
		 * @param name name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets the length
		 *
		 * @return Integer value
		 */
		public int getLength() {
			return length;
		}

		/**
		 * Sets the length
		 *
		 * @param length length
		 */
		public void setLength(int length) {
			this.length = length;
		}

		@Override
		public int getWeight() {
			return getLength();
		}
	}
}
