package edu.ncsu.csc316.dsa.graph;

/**
 * Graph Interface
 * 
 * @author Anisha Ponnapati
 *
 * @param <V>
 * @param <E>
 */
public interface Graph<V, E> {
	/**
	 * Is directed
	 * 
	 * @return True/False
	 */
	boolean isDirected();

	/**
	 * Number of vertices
	 * 
	 * @return Integer value
	 */
	int numVertices();

	/**
	 * Vertices
	 * 
	 * @return Vertex
	 */
	Iterable<Vertex<V>> vertices();

	/**
	 * Number of edges
	 * 
	 * @return Integer value
	 */
	int numEdges();

	/**
	 * Edges
	 * 
	 * @return Edge
	 */
	Iterable<Edge<E>> edges();

	/**
	 * Get Edge
	 * 
	 * @param vertex1 Vertex one
	 * @param vertex2 Vertex two
	 * @return Edge
	 */
	Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2);

	/**
	 * End vertices
	 * 
	 * @param edge Edge
	 * @return Vertex
	 */
	Vertex<V>[] endVertices(Edge<E> edge);

	/**
	 * Opposite
	 * 
	 * @param vertex Vertex
	 * @param edge   Edge
	 * @return Vertex
	 */
	Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge);

	/**
	 * Out degree
	 * 
	 * @param vertex Vertex
	 * @return Integer
	 */
	int outDegree(Vertex<V> vertex);

	/**
	 * In degree
	 * 
	 * @param vertex Vertex
	 * @return Integer
	 */
	int inDegree(Vertex<V> vertex);

	/**
	 * Outgoing edges
	 * 
	 * @param vertex Vertex
	 * @return Edge
	 */
	Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex);

	/**
	 * Incoming Edges
	 * 
	 * @param vertex Vertex
	 * @return Edge
	 */
	Iterable<Edge<E>> incomingEdges(Vertex<V> vertex);

	/**
	 * Inserts Vertex
	 * 
	 * @param vertexData Vertex Data
	 * @return Vertex
	 */
	Vertex<V> insertVertex(V vertexData);

	/**
	 * Inserts Edge
	 * 
	 * @param v1       Vertex one
	 * @param v2       Vertex two
	 * @param edgeData EdgeDate
	 * @return Edge
	 */
	Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData);

	/**
	 * Removes vertex
	 * 
	 * @param vertex Vertex
	 * @return Vertex
	 */
	Vertex<V> removeVertex(Vertex<V> vertex);

	/**
	 * Removes edge
	 * 
	 * @param edge Edge
	 * @return Edge
	 */
	Edge<E> removeEdge(Edge<E> edge);

	/**
	 * Inner interface
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	interface Edge<E> {
		/**
		 * Get element
		 * 
		 * @return Element
		 */
		E getElement();
	}

	/**
	 * Inner interface
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <V>
	 */
	interface Vertex<V> {
		/**
		 * Get element
		 * 
		 * @return Element
		 */
		V getElement();
	}
}
