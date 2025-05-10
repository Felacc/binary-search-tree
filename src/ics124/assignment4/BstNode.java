package ics124.assignment4;

/**
 * A node in the binary search tree.
 * 
 * This is a container class, so all the fields are public.
 */
public class BstNode {
    /**
     * The "payload" or "key" of the node.
     *
     * Nodes are arranged in the BST such that this value is greater
     * than the value in the left child and less than the value in
     * the right child.  Duplicate values are not allowed.
     */
    public int x;

    /**
     * The parent node of this node.  May be null.
     * 
     * The root of the tree will have a null parent.
     */
    public BstNode parent;
    
    /**
     * The left child node of this node.  May be null.
     */
    public BstNode left;
    
    /**
     * The right child node of this node.  May be null.
     */
    public BstNode right;

    /**
     * Constructor.
     * 
     * When we're adding nodes into the tree they will go in as
     * leaf nodes, so the left and right will be null.  We'll have to
     * update the parent once we know where this node has been placed.
     * 
     * @param x Value to store in this node.
     */
    public BstNode(int x) {
        this(x, null);
    }
    /**
     * Constructor where we know the parent.
     * 
     * @param x
     * @param parent 
     */
    public BstNode(int x, BstNode parent) {
        this.x = x;
        this.parent = parent;
        left = right = null;
    }

    /**
     * Pretty printer.
     * 
     * @return string representation for debugging
     */
    @Override
    public String toString() {
        return "<Node: "+x+">";
    }   
}
