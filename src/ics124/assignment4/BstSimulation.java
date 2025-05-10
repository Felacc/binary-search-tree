package ics124.assignment4;

import ics124.c0523788.assignment4.BinarySearchTree;
import ics124.assignment4.*;
import java.util.Random;

public class BstSimulation {

	public static void main(String[] args) {
		final int NODES = 1023;
		final int MAX = 32768;
		assert (MAX > NODES);

		Random random = new Random();
		BinarySearchTree bst = new BinarySearchTree();
		
		for (int i = 0; i < NODES; i += 1) {
			// Easier to examine if they're all positive and not too large.
			int x = Math.abs(random.nextInt()) % MAX;
//			int x = i;
			try {
				bst.insert(x);
			} catch (BstDuplicateKeyException e) {
				// Try again
				i -= 1;
			}
		}
		BstNode n = bst.find(10);
		bst.rotateLeft(bst.root);
		
		System.out.println("Number of nodes: " + NODES);
		System.out.println("Theoretical minimum height: "
			+ (int) (Math.ceil(Math.log(NODES + 1) / Math.log(2))));
		System.out.println("Tree height: " + treeHeight(bst));

		int leftHeight, rightHeight;

		leftHeight = tryLR(bst, bst.root);
		if (leftHeight > 0) {
			System.out.println("Tree height after LR: " + leftHeight);
		}
		rightHeight = tryRR(bst, bst.root);
		if (rightHeight > 0) {
			System.out.println("Tree height after RR: " + rightHeight);
		}

	}

	public static int tryLR(BinarySearchTree bst, BstNode subtree) {
		boolean atRoot = subtree == bst.root;
		int height = 0;
		// Can only do a left rotation if there is a right child.
		if (subtree.right != null) {
			subtree = bst.rotateLeft(subtree);
			if (atRoot) {
				bst.root = subtree;
			}

			height = treeHeight(bst);

			// Put it back.
			subtree = bst.rotateRight(subtree);
			if (atRoot) {
				bst.root = subtree;
			}
		}
		return height;
	}

	public static int tryRR(BinarySearchTree bst, BstNode subtree) {
		boolean atRoot = subtree == bst.root;
		int height = 0;
		if (subtree.left != null) {
			// Try a right rotation.
			subtree = bst.rotateRight(subtree);
			if (atRoot) {
				bst.root = subtree;
			}

			height = treeHeight(bst);

			// Put it back.
			subtree = bst.rotateLeft(subtree);
			if (atRoot) {
				bst.root = subtree;
			}
		}
		return height;
	}

	public static int treeHeight(BinarySearchTree bst) {
		int maxDepth = 0;
		BstNode runner = bst.min();
//		BstNode runner = bst.find(11);
		while (runner != null) {
//			System.out.println("Visting node: " + runner.x);
			maxDepth = Math.max(maxDepth, getDepth(runner));
			runner = bst.succ(runner);
		}
		return maxDepth;
	}

	public static int getDepth(BstNode node) {
		int i = 0;
		while (node != null) {
			i += 1;
			node = node.parent;
		}
		return i;
	}
}
