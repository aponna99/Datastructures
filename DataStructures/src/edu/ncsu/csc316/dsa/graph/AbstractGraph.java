package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Position;

/**
 * Abstract Graph
 * 
 * @author Anisha Ponnapati
 *
 * @param <V>
 * @param <E>
 */
public abstract class AbstractGraph<V, E> implements Graph<V, E> {

	private boolean isDirected;

	/**
	 * Constructor
	 * 
	 * @param directed Directed
	 */
	public AbstractGraph(boolean directed) {
		setDirected(directed);
	}

	/**
	 * Set directed
	 * 
	 * @param directed Directed
	 */
	private void setDirected(boolean directed) {
		isDirected = directed;
	}

	/**
	 * Is directed
	 * 
	 * @return true or false
	 */
	public boolean isDirected() {
		return isDirected;
	}

	@Override
	public Vertex<V>[] endVertices(Edge<E> edge) {
		return validate(edge).getEndpoints();
	}

	@Override
	public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) {
		GraphEdge temp = validate(edge);
		Vertex<V>[] ends = temp.getEndpoints();
		if (ends[0] == vertex) {
			return ends[1];
		}
		if (ends[1] == vertex) {
			return ends[0];
		}
		throw new IllegalArgumentException("Vertex is not incident on this edge.");
	}

	/**
	 * Graph Vertex
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	protected class GraphVertex implements Vertex<V> {
		private V element;
		private Position<Vertex<V>> position;

		/**
		 * Constructor
		 * 
		 * @param element Element
		 */
		public GraphVertex(V element) {
			setElement(element);
		}

		/**
		 * Set Element
		 * 
		 * @param element Element
		 */
		public void setElement(V element) {
			this.element = element;
		}

		/**
		 * Get Element
		 * 
		 * @return Vertex
		 */
		public V getElement() {
			return element;
		}

		/**
		 * Get Position
		 * 
		 * @return Vertex
		 */
		public Position<Vertex<V>> getPosition() {
			return position;
		}

		/**
		 * Sets Position
		 * 
		 * @param pos Position
		 */
		public void setPosition(Position<Vertex<V>> pos) {
			position = pos;
		}
	}

	/**
	 * Inner class Graph Edge
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	protected class GraphEdge implements Edge<E> {
		private E element;
		private Vertex<V>[] endpoints;
		private Position<Edge<E>> position;

		/**
		 * GraphEdge
		 * 
		 * @param element Element
		 * @param v1      Vertex one
		 * @param v2      Vertex two
		 */
		@SuppressWarnings("unchecked")
		public GraphEdge(E element, Vertex<V> v1, Vertex<V> v2) {
			setElement(element);
			endpoints = (Vertex<V>[]) new Vertex[] { v1, v2 };
		}

		/**
		 * Sets element
		 * 
		 * @param element Element
		 */
		public void setElement(E element) {
			this.element = element;
		}

		/**
		 * Get element
		 * 
		 * @return Element
		 */
		public E getElement() {
			return element;
		}

		/**
		 * Gets EndPoints
		 * 
		 * @return Vertex
		 */
		public Vertex<V>[] getEndpoints() {
			return endpoints;
		}

		/**
		 * Gets Position
		 * 
		 * @return Position
		 */
		public Position<Edge<E>> getPosition() {
			return position;
		}

		/**
		 * Sets Position
		 * 
		 * @param pos Position
		 */
		public void setPosition(Position<Edge<E>> pos) {
			position = pos;
		}

		@Override
		public String toString() {
			return "Edge[element=" + element + "]";
		}
	}

	/**
	 * Validate
	 * 
	 * @param e Edge
	 * @return GraphEdge
	 */
	protected GraphEdge validate(Edge<E> e) {
		if (!(e instanceof AbstractGraph.GraphEdge)) {
			throw new IllegalArgumentException("Edge is not a valid graph edge.");
		}
		return (GraphEdge) e;
	}
}
