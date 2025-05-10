package ics124.assignment4;

/**
 * A binary search tree.
 * 
 * Tree consists of BstNodes, arranged such that the value stored
 * at a node is greater than the value stored at its left child
 * and less than the value stored at its right child.  Duplicate
 * values are not allowed, will throw BstDuplicateKeyException.
 */
public interface BST {
    BstNode find(int x);
    void insert(int x);
    void delete(int x);
    
    BstNode min();
    BstNode max();
    BstNode min(BstNode tree);
    BstNode max(BstNode tree);
    
    BstNode succ(BstNode node);
    BstNode pred(BstNode node);
    
    void splice(BstNode node);
    
    // These return the new subtree, simulating a "var" parameter.
    // Call them like `myNode.left = bst.rotateXXX(myNode.left);` so the
    // tree gets updated.
    BstNode rotateLeft(BstNode tree);
    BstNode rotateRight(BstNode tree);
}
