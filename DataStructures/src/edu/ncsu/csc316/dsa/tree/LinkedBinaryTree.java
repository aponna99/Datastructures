package edu.ncsu.csc316.dsa.tree;

import edu.ncsu.csc316.dsa.Position;
import edu.ncsu.csc316.dsa.list.List;
import edu.ncsu.csc316.dsa.list.SinglyLinkedList;
import edu.ncsu.csc316.dsa.queue.ArrayBasedQueue;
import edu.ncsu.csc316.dsa.queue.Queue;

/**
 * Linked Binary Tree
 * 
 * @author Anisha Ponnapati
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

	private Node<E> root;
	private int size;

	/**
	 * Constructor
	 */
	public LinkedBinaryTree() {
		root = null;
		size = 0;
	}

	/**
	 * Validates node
	 * 
	 * @param p Position
	 * @return Node
	 */
	protected Node<E> validate(Position<E> p) {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Position is not a valid linked binary node");
		}
		return (Node<E>) p;
	}

	/**
	 * Node inner class
	 * 
	 * @author Anisha Ponnapati
	 *
	 * @param <E>
	 */
	public static class Node<E> extends AbstractNode<E> {
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;

		/**
		 * Constructor
		 * 
		 * @param element Element
		 */
		public Node(E element) {
			this(element, null);
		}

		/**
		 * Consructor
		 * 
		 * @param element Element
		 * @param parent  Parent
		 */
		public Node(E element, Node<E> parent) {
			super(element);
			setParent(parent);
		}

		/**
		 * Gets node to the right
		 * 
		 * @return Node
		 */
		public Node<E> getLeft() {
			return left;
		}

		/**
		 * Gets node to the right
		 * 
		 * @return Node
		 */
		public Node<E> getRight() {
			return right;
		}

		/**
		 * Sets node to the left
		 * 
		 * @param left Left
		 */
		public void setLeft(Node<E> left) {
			this.left = left;
		}

		/**
		 * Sets node to the right
		 * 
		 * @param right Right
		 */
		public void setRight(Node<E> right) {
			this.right = right;
		}

		/**
		 * Gets parent
		 * 
		 * @return Node
		 */
		public Node<E> getParent() {
			return parent;
		}

		/**
		 * Sets parent
		 * 
		 * @param parent Parent
		 */
		public void setParent(Node<E> parent) {
			this.parent = parent;
		}
	}

	@Override
	public Position<E> left(Position<E> p) {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) {
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> addLeft(Position<E> p, E value) {
		Node<E> node = validate(p);
		if (left(node) != null) {
			throw new IllegalArgumentException("Node already has a left child.");
		}

		Node<E> child = createNode(value, node, null, null);
		node.setLeft(child);
		size++;
		return child;
	}

	@Override
	public Position<E> addRight(Position<E> p, E value) {
		Node<E> node = validate(p);
		if (right(node) != null) {
			throw new IllegalArgumentException("Node already has a right child.");
		}

		Node<E> child = createNode(value, node, null, null);
		node.setRight(child);
		size++;
		return child;
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) {
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public Position<E> addRoot(E value) {
		if (root() != null) {
			throw new IllegalArgumentException("The tree already has a root.");
		}
		this.root = createNode(value, null, null, null);
		size++;
		return root;
	}

	@Override
	public E remove(Position<E> p) {
		if (numChildren(p) == 2) {
			throw new IllegalArgumentException("The node has two children");
		}
		Node<E> node = validate(p);

		Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
		if (child != null)
			child.setParent(node.getParent());
		if (node == root)
			root = child;
		else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft())
				parent.setLeft(child);
			else
				parent.setRight(child);
		}

		size--;
		E temp = node.getElement();
		node.setElement(null);
		node.setLeft(null);
		node.setRight(null);
		node.setParent(node);
		return temp;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Creates node
	 * 
	 * @param e      Element
	 * @param parent Parent
	 * @param left   Left
	 * @param right  Right
	 * @return Node
	 */
	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		Node<E> newNode = new Node<E>(e);
		newNode.setParent(parent);
		newNode.setLeft(left);
		newNode.setRight(right);
		return newNode;
	}

	// setRoot is needed for a later lab...
	// ...but THIS DESIGN IS BAD! If a client arbitrarily changes
	// the root by using the method, the size may no longer be correct/valid.
	// Instead, the precondition for this method is that
	// it should *ONLY* be used when rotating nodes in
	// balanced binary search trees. We could instead change
	// our rotation code to not need this setRoot method, but that
	// makes the rotation code messier. For the purpose of this lab,
	// we will sacrifice a stronger design for cleaner/less code.

	/**
	 * Sets root with the position
	 * 
	 * @param p Position
	 * @return Position
	 */
	protected Position<E> setRoot(Position<E> p) {
		root = validate(p);
		return root;
	}

	@Override
	public Iterable<Position<E>> preOrder() {
		List<Position<E>> traversal = new SinglyLinkedList<Position<E>>();
		if (!isEmpty()) {
			preOrderHelper(root(), traversal);
		}
		return traversal;
	}

	private void preOrderHelper(Position<E> p, List<Position<E>> traversal) {
		traversal.addLast(p);
		for (Position<E> c : children(p)) {
			preOrderHelper(c, traversal);
		}
	}

	@Override
	public Iterable<Position<E>> postOrder() {
		List<Position<E>> list = new SinglyLinkedList<Position<E>>();
		if (!isEmpty()) {
			postOrderHelper(root(), list);
		}
		return list;
	}

	private void postOrderHelper(Position<E> p, List<Position<E>> list) {
		for (Position<E> c : children(p)) {
			postOrderHelper(c, list);
		}

		list.addLast(p);
	}

	@Override
	public Iterable<Position<E>> levelOrder() {
		List<Position<E>> s = new SinglyLinkedList<Position<E>>();
		if (!isEmpty()) {
			Queue<Position<E>> fringe = new ArrayBasedQueue<Position<E>>();
			fringe.enqueue(root());
			while (!fringe.isEmpty()) {
				Position<E> p = fringe.dequeue();
				s.addLast(p);
				for (Position<E> c : children(p)) {
					fringe.enqueue(c);
				}
			}

		}

		return s;
	}
}