package edu.ncsu.csc316.dsa.graph;

import java.util.Iterator;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;

/**
 * AdjacencyListGraph
 * 
 * @author Anisha Ponnapati
 *
 * @param <V>
 * @param <E>
 */
public class AdjacencyListGraph<V, E> extends AbstractGraph<V, E> {

	private PositionalList<Vertex<V>> vertexList;
	private PositionalList<Edge<E>> edgeList;

	/**
	 * Constructor
	 */
	public AdjacencyListGraph() {
		this(false);
	}

	/**
	 * Constructor with parameter
	 * 
	 * @param directed Directed
	 */
	public AdjacencyListGraph(boolean directed) {
		super(directed);
		vertexList = new PositionalLinkedList<Vertex<V>>();
		edgeList = new PositionalLinkedList<Edge<E>>();
	}

	@Override
	public int numVertices() {
		return vertexList.size();
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		return vertexList;
	}

	@Override
	public int numEdges() {
		return edgeList.size();
	}

	@Override
	public Iterable<Edge<E>> edges() {
		return edgeList;
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
		return validate(vertex).getOutgoing();
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
		return validate(vertex).getIncoming();
	}

	@Override
	public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
		ALVertex v1 = validate(vertex1);
		ALVertex v2 = validate(vertex2);
		Iterator<Edge<E>> it = edgeList.iterator();
		while (it.hasNext()) {
			GraphEdge current = validate(it.next());
			Vertex<V>[] ends = current.getEndpoints();
			if (!isDirected() && ends[1] == v1 && ends[0] == v2) {
				return current;
			}
			if (ends[0] == v1 && ends[1] == v2) {
				return current;
			}
		}
		return null;
	}

	@Override
	public int outDegree(Vertex<V> vertex) {
		return validate(vertex).getOutgoing().size();
	}

	@Override
	public int inDegree(Vertex<V> vertex) {
		return validate(vertex).getIncoming().size();
	}

	@Override
	public Vertex<V> insertVertex(V vertexData) {
		ALVertex vertex = new ALVertex(vertexData, isDirected());
		Position<Vertex<V>> pos = vertexList.addLast(vertex);
		vertex.setPosition(pos);
		return vertex;

	}

	@Override
	public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData) {
		ALVertex origin = validate(v1);
		ALVertex destination = validate(v2);
		ALEdge edge = new ALEdge(edgeData, origin, destination);
		Position<Edge<E>> pos = edgeList.addLast(edge);
		edge.setPosition(pos);
		edge.setOutgoingListPosition(origin.getOutgoing().addLast(edge));
		edge.setIncomingListPosition(destination.getIncoming().addLast(edge));
		return edge;
	}

	@Override
	public Vertex<V> removeVertex(Vertex<V> vertex) {
		ALVertex v = validate(vertex);
		if (!isDirected()) {
			for (Edge<E> e : v.getIncoming()) {
				removeEdge(e);
			}
		} else {
			for (Edge<E> e : v.getIncoming()) {
				removeEdge(e);
			}
			for (Edge<E> e : v.getOutgoing()) {
				removeEdge(e);
			}
		}
		vertexList.remove(v.getPosition());
		return v;
	}

	@Override
	public Edge<E> removeEdge(Edge<E> edge) {
		ALEdge e = validate(edge);
		Vertex<V>[] ends = e.getEndpoints();
		ALVertex origin = validate(ends[0]);
		ALVertex dest = validate(ends[1]);
		origin.getOutgoing().remove(e.getOutgoingListPosition());
		dest.getIncoming().remove(e.getIncomingListPosition());
		edgeList.remove(e.getPosition());
		return e;
	}

	/**
	 * ALVertex
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ALVertex extends GraphVertex {

		private PositionalList<Edge<E>> outgoing;
		private PositionalList<Edge<E>> incoming;

		/**
		 * Constructor
		 * 
		 * @param data       Data
		 * @param isDirected IsDirected
		 */
		public ALVertex(V data, boolean isDirected) {
			super(data);
			outgoing = new PositionalLinkedList<Edge<E>>();
			if (isDirected) {
				incoming = new PositionalLinkedList<Edge<E>>();
			} else {
				incoming = outgoing;
			}
		}

		/**
		 * Get outgoing
		 * 
		 * @return Edge
		 */
		public PositionalList<Edge<E>> getOutgoing() {
			return outgoing;
		}

		/**
		 * Get incoming
		 * 
		 * @return Edge
		 */
		public PositionalList<Edge<E>> getIncoming() {
			return incoming;
		}
	}

	/**
	 * ALEdge Inner Class
	 * 
	 * @author Anisha Ponnapati
	 *
	 */
	private class ALEdge extends GraphEdge {
		private Position<Edge<E>> outgoingListPosition;
		private Position<Edge<E>> incomingListPosition;

		/**
		 * Constructor
		 * 
		 * @param element Element
		 * @param v1      Vertex 1
		 * @param v2      Vertex 2
		 */
		public ALEdge(E element, Vertex<V> v1, Vertex<V> v2) {
			super(element, v1, v2);
		}

		/**
		 * Get outgoing list position
		 * 
		 * @return Edge
		 */
		public Position<Edge<E>> getOutgoingListPosition() {
			return outgoingListPosition;
		}

		/**
		 * Set outgoing list position
		 * 
		 * @param outgoingListPosition ongoing list
		 */
		public void setOutgoingListPosition(Position<Edge<E>> outgoingListPosition) {
			this.outgoingListPosition = outgoingListPosition;
		}

		/**
		 * Get incoming list
		 * 
		 * @return Edge
		 */
		public Position<Edge<E>> getIncomingListPosition() {
			return incomingListPosition;
		}

		/**
		 * Set incoming list
		 * 
		 * @param incomingListPosition incoming list
		 */
		public void setIncomingListPosition(Position<Edge<E>> incomingListPosition) {
			this.incomingListPosition = incomingListPosition;
		}
	}

	private ALVertex validate(Vertex<V> v) {
		if (!(v instanceof AdjacencyListGraph.ALVertex)) {
			throw new IllegalArgumentException("Vertex is not a valid adjacency list vertex.");
		}
		return (ALVertex) v;
	}

	/**
	 * Validate
	 * 
	 * @param e Edge
	 * @return ALEdge
	 */
	protected ALEdge validate(Edge<E> e) {
		if (!(e instanceof AdjacencyListGraph.ALEdge)) {
			throw new IllegalArgumentException("Edge is not a valid adjacency list edge.");
		}
		return (ALEdge) e;
	}
}
