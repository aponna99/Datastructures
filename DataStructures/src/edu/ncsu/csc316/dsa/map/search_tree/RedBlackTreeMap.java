package edu.ncsu.csc316.dsa.map.search_tree;

import java.util.Comparator;

import edu.ncsu.csc316.dsa.Position;

/**
 * Red and Black Tree Map
 * 
 * @author Anisha Ponnapati
 *
 * @param <K>
 * @param <V>
 */
public class RedBlackTreeMap<K extends Comparable<K>, V> extends BinarySearchTreeMap<K, V> {

	/**
	 * Default constructor
	 */
	public RedBlackTreeMap() {
		super(null);
	}

	/**
	 * Constructor with parameter
	 * 
	 * @param compare comparator
	 */
	public RedBlackTreeMap(Comparator<K> compare) {
		super(compare);
	}

	// Helper method to abstract the idea of black
	private boolean isBlack(Position<Entry<K, V>> p) {
		return getProperty(p) == 0;
	}

	// Helper method to abstract the idea of red
	private boolean isRed(Position<Entry<K, V>> p) {
		return getProperty(p) == 1;
	}

	// Set the color for a node to be black
	private void makeBlack(Position<Entry<K, V>> p) {
		setProperty(p, 0);
	}

	// Set the color for a node to be red
	private void makeRed(Position<Entry<K, V>> p) {
		setProperty(p, 1);
	}

	private void resolveRed(Position<Entry<K, V>> node) {
		Position<Entry<K, V>> parent, uncle, middle, grand;
		parent = parent(node);
		if (isRed(parent)) {
			uncle = sibling(parent);
			if (isBlack(uncle)) {
				middle = restructure(node);
				makeBlack(middle);
				makeRed(left(middle));
				makeRed(right(middle));
			} else {
				makeBlack(parent);
				makeBlack(uncle);
				grand = parent(parent);
				if (!isRoot(grand)) {
					makeRed(grand);
					resolveRed(grand);
				}
			}
		}
	}

	private void remedyDoubleBlack(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> parent = parent(p);
		Position<Entry<K, V>> sibiling = sibling(p);
		if (isBlack(sibiling)) {
			if (isRed(left(sibiling)) || isRed(right(sibiling))) {
				Position<Entry<K, V>> x = (isRed(left(sibiling)) ? left(sibiling) : right(sibiling));
				Position<Entry<K, V>> middle = restructure(x);
				if (isRed(parent)) {
					makeRed(middle);
				} else {
					makeBlack(middle);
				}
				makeBlack(left(middle));
				makeBlack(right(middle));
			} else {
				makeRed(sibiling);
				if (isRed(parent)) {
					makeBlack(parent);
				} else if (!isRoot(parent)) {
					remedyDoubleBlack(parent);
				}
			}
		} else {
			rotate(sibiling);
			makeBlack(sibiling);
			makeRed(parent);
			remedyDoubleBlack(p);
		}
	}

	@Override
	protected void actionOnInsert(Position<Entry<K, V>> p) {
		if (!isRoot(p)) {
			makeRed(p);
			resolveRed(p);
		}
	}

	@Override
	protected void actionOnDelete(Position<Entry<K, V>> p) {
		if (isRed(p)) {
			makeBlack(p);
		} else if (!isRoot(p)) {
			Position<Entry<K, V>> sib = sibling(p);
			if (isInternal(sib) && (isBlack(sib) || isInternal(left(sib)))) {
				remedyDoubleBlack(p);
			}
		}
	}
}
