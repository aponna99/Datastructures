package edu.ncsu.csc316.dsa.graph;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalLinkedList;
import edu.ncsu.csc316.dsa.list.positional.PositionalList;
import edu.ncsu.csc316.dsa.map.Map;
import edu.ncsu.csc316.dsa.map.hashing.LinearProbingHashMap;

/**
 * Adjacency Matrix Graph
 * 
 * @author Anisha Ponnapati
 *
 * @param <V>
 * @param <E>
 */
public class AdjacencyMatrixGraph<V, E> extends AbstractGraph<V, E> {

	private GraphEdge[][] matrix;
	private PositionalList<Vertex<V>> vertexList;
	private PositionalList<Edge<E>> edgeList;
	private Map<Vertex<V>, Integer> vertexMap;

	/**
	 * Constructor
	 */
	public AdjacencyMatrixGraph() {
		this(false);
	}

	/**
	 * Constructor
	 * 
	 * @param directed Is directed
	 */
	@SuppressWarnings("unchecked")
	public AdjacencyMatrixGraph(boolean directed) {
		super(directed);
		matrix = (GraphEdge[][]) (new AbstractGraph.GraphEdge[0][0]);
		vertexList = new PositionalLinkedList<Vertex<V>>();
		edgeList = new PositionalLinkedList<Edge<E>>();
		vertexMap = new LinearProbingHashMap<Vertex<V>, Integer>();
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
	public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
		GraphVertex v1 = validate(vertex1);
		GraphVertex v2 = validate(vertex2);
		return matrix[vertexMap.get(v1)][vertexMap.get(v2)];
	}

	@Override
	public Vertex<V>[] endVertices(Edge<E> edge) {
		GraphEdge e = validate(edge);
		return e.getEndpoints();
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

	@Override
	public int outDegree(Vertex<V> vertex) {
		return outgoingEdgeList(vertex).size();
	}

	private List<Edge<E>> outgoingEdgeList(Vertex<V> vertex) {
		GraphVertex v = validate(vertex);
		List<Edge<E>> list = new SinglyLinkedList<Edge<E>>();
		for (GraphEdge e : matrix[vertexMap.get(v)]) {
			if (e != null) {
				list.addLast(e);
			}
		}
		return list;
	}

	private List<Edge<E>> incomingEdgeList(Vertex<V> vertex) {
		GraphVertex v = validate(vertex);
		List<Edge<E>> list = new SinglyLinkedList<Edge<E>>();
		for (int i = 0; i < matrix.length; i++) {
			GraphEdge e = matrix[i][vertexMap.get(v)];
			if (e != null) {
				list.addLast(e);
			}
		}
		return list;
	}

	@Override
	public int inDegree(Vertex<V> vertex) {
		return incomingEdgeList(vertex).size();
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
		return outgoingEdgeList(vertex);
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
		return incomingEdgeList(vertex);
	}

	@Override
	public Vertex<V> insertVertex(V vertexData) {
		GraphVertex v = new GraphVertex(vertexData);
		Position<Vertex<V>> pos = vertexList.addLast(v);
		vertexMap.put(v, vertexMap.size());
		v.setPosition(pos);
		growArray();
		return v;
	}

	@SuppressWarnings("unchecked")
	private void growArray() {
		// We will grow the matrix each time a new vertex is added
		GraphEdge[][] temp = new AbstractGraph.GraphEdge[matrix.length + 1][matrix.length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				temp[i][j] = matrix[i][j];
			}
		}
		matrix = temp;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> vertex1, Vertex<V> vertex2, E edgeData) {
		GraphVertex origin = validate(vertex1);
		GraphVertex destination = validate(vertex2);
		GraphEdge e = new GraphEdge(edgeData, origin, destination);
		Position<Edge<E>> pos = edgeList.addLast(e);
		e.setPosition(pos);
		matrix[vertexMap.get(origin)][vertexMap.get(destination)] = e;
		if (!isDirected()) {
			matrix[vertexMap.get(destination)][vertexMap.get(origin)] = e;
		}
		return e;
	}

	@Override
	public Vertex<V> removeVertex(Vertex<V> vertex) {
		GraphVertex v = validate(vertex);
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			if (matrix[i][vertexMap.get(v)] != null) {
				removeEdge(matrix[i][vertexMap.get(v)]);
			}
			if (matrix[vertexMap.get(v)][i] != null) {
				removeEdge(matrix[vertexMap.get(v)][i]);
			}
		}
		vertexList.remove(v.getPosition());
		return v;
	}

	@Override
	public Edge<E> removeEdge(Edge<E> edge) {
		GraphEdge e = validate(edge);
		Vertex<V>[] ends = e.getEndpoints();
		GraphVertex origin = validate(ends[0]);
		GraphVertex dest = validate(ends[1]);
		matrix[vertexMap.get(origin)][vertexMap.get(dest)] = null;
		matrix[vertexMap.get(dest)][vertexMap.get(origin)] = null;
		edgeList.remove(e.getPosition());
		return e;
	}

	private GraphVertex validate(Vertex<V> v) {
		if (!(v instanceof AbstractGraph.GraphVertex)) {
			throw new IllegalArgumentException("Vertex is not a valid graph vertex.");
		}
		return (GraphVertex) v;
	}
}
