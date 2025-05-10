package ics124.c0523788.assignment4;

import ics124.assignment4.*;

public class BinarySearchTree extends BstBase {

	@Override
	public void insert(int x) {
		BstNode parent = null;
		BstNode runner = root;
		while (runner != null) {
			parent = runner;
			if (runner.x == x) {
				throw new BstDuplicateKeyException();
			} else if (runner.x > x) {
				runner = runner.left;
			} else {
				runner = runner.right;
			}
		}
		if (parent == null) {
			root = new BstNode(x);
		} else if (parent.x > x) {
			parent.left = new BstNode(x, parent);
		} else {
			parent.right = new BstNode(x, parent);
		}
	}

	@Override
	public void delete(int x) {
		BstNode node = find(x);

		if (node == null) {
			throw new BstIllegalOperationException("Cannot find a node with value " + x);
		}

		if (node.left == null || node.right == null) {
			// zero or one child
			splice(node);
		} else {
			// replaces node val with the lowest val node from the right subtree
			BstNode minOfRight = min(node.right);
			node.x = minOfRight.x;
			splice(minOfRight);
		}
	}

	@Override
	public BstNode succ(BstNode node) {
		if (node == null) {
			return null;
		}

		if (node.right != null) {
			return min(node.right);
		}

		BstNode parent = node.parent;
		while (parent != null && node == parent.right) { // checks when node turns right
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}

	@Override
	public BstNode pred(BstNode node) {
		if (node == null) {
			return null;
		}

		if (node.left != null) {
			return max(node.left);
		}

		BstNode parent = node.parent;
		while (parent != null && node == parent.left) { // checks when node turns left
			node = parent;
			parent = node.parent;
		}
		return parent;
	}

	@Override
	public void splice(BstNode node) {
		if (node.left != null && node.right != null) {
			throw new BstIllegalOperationException("Cannot splice nodes with more than 1 child");
		}

		// get child node
		BstNode child;
		if (node.left != null) {
			child = node.left;
		} else {
			child = node.right; // returns null if there are no children
		}

		BstNode parent;
		if (node == root) {
			root = child;
			if (root != null) {
				root.parent = null;

			}
		} else {
			parent = node.parent;
			// essentially "skips over" the node
			if (parent.left == node) {
				parent.left = child;
			} else {
				parent.right = child;
			}

			// ensure child doesn't point to spliced node
			if (child != null) {
				child.parent = parent;
			}
		}
	}

	@Override
	public BstNode rotateLeft(BstNode tree) {
		// if the node doesn't have a right child this method throws a NullPointerException by default
		BstNode temp = tree;

		tree = tree.right;
		temp.right = tree.left;
		tree.left = temp;

		if (temp.right != null) {
			temp.right.parent = temp;
		}
		tree.parent = temp.parent;
		temp.parent = tree;

		// ensure that right child pointer of the new root of the subtree is correct
		if (tree.parent != null && tree.parent.right == temp) {
			tree.parent.right = tree;
		}

		// update global root pointer if necessary
		if (tree.parent == null) {
			root = tree;
		}

		return tree;
	}

	@Override
	public BstNode rotateRight(BstNode tree) {
		// if the node doesn't have a left child this method throws a NullPointerException by default
		BstNode temp = tree;

		tree = tree.left;
		temp.left = tree.right;
		tree.right = temp;

		if (temp.left != null) {
			temp.left.parent = temp;
		}
		tree.parent = temp.parent;
		temp.parent = tree;

		// ensure that right child pointer of the new root of the subtree is correct
		if (tree.parent != null && tree.parent.left == temp) {
			tree.parent.left = tree;
		}

		// update global root pointer if necessary
		if (tree.parent == null) {
			root = tree;
		}

		return tree;
	}

}
