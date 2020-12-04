/**
 * 
 */
package edu.ncsu.csc316.dsa.graph;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.dsa.Weighted;
import edu.ncsu.csc316.dsa.graph.Graph.Edge;
import edu.ncsu.csc316.dsa.graph.Graph.Vertex;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * Test class
 * 
 * @author Anisha Ponnapati
 * @param <V>
 *
 */
public class MinimumSpanningTreeUtilTest<V> {

	/**
	 * Test
	 */
	@Test
	public void test() {
		Graph<Integer, Highway> g = new AdjacencyMapGraph<Integer, Highway>();
		Vertex<Integer> v1 = g.insertVertex(1);
		Vertex<Integer> v2 = g.insertVertex(2);
		Vertex<Integer> v3 = g.insertVertex(3);
		Vertex<Integer> v4 = g.insertVertex(4);
		Vertex<Integer> v5 = g.insertVertex(5);

		g.insertEdge(v1, v2, new Highway("f1", 2));
		g.insertEdge(v1, v3, new Highway("f2", 4));
		g.insertEdge(v1, v4, new Highway("f3", 8));
		g.insertEdge(v3, v5, new Highway("f4", 16));
		g.insertEdge(v5, v3, new Highway("f5", 32));

		PositionalList<Edge<Highway>> m = MinimumSpanningTreeUtil.kruskal(g);
		assertFalse(m.isEmpty());

		PositionalList<Edge<Highway>> m1 = MinimumSpanningTreeUtil.primJarnik(g);
		assertFalse(m1.isEmpty());
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
