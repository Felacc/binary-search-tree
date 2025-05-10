package ics124.assignment4;

/*
 * Abstract base class for your BinarySearchTree class.
 * 
 * This holds helper functions and useful fields for you.
 * 
 */
public abstract class BstBase implements BST {
    public BstNode root;
    
    public BstBase() {
        root = null;
    }
    @Override
    public BstNode find(int x) {
        return findIterative(x, root);
    }
    public BstNode findRecursive(int x, BstNode tree) {
        if (tree == null || x == tree.x)
            return tree;
        else if (x < tree.x)
            return findRecursive(x, tree.left);
        else 
            return findRecursive(x, tree.right);
    }
    public BstNode findIterative(int x, BstNode root) {
        BstNode runner = root;
        while (runner != null && x != runner.x) {
            if (x < runner.x)
                runner = runner.left;
            else
                runner = runner.right;
        }
        return runner;
    }
    
    /*
     * Return the minimumn node in the tree
     */
    @Override
    public BstNode min() {
        return min(root);
    }
    
    /*
     * Return the minimum node of a subtree
     */
    @Override
    public BstNode min(BstNode tree) {
        if (tree == null) return tree;
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /*
     * Return the maximum node of the tree
     */
    @Override
    public BstNode max() {
        return max(root);
    }
    
    /*
     * Return the maximum node of a subtree.
     */
    @Override
    public BstNode max(BstNode tree) {
        if (tree == null) return tree;
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

   /*
     * The following are useful debugging tools for 
     * displaying the structure of a tree (or subtree).  Preorder
     * allows us to easily show the 2-D structure in a 1-D form.
     * Inorder shows us the lexicographic ordering.  Postorder is
     * only here for completeness.
     */
    
    public String inOrder(BstNode tree) {
        if (tree == null) return "";
        
        return String.format("%s %s %s", 
            inOrder(tree.left),
            tree.x,
            inOrder(tree.right));
    }

    public String preOrder(BstNode tree) {
        if (tree == null) return "";
        
        return String.format("%s <%s> <%s>", 
                tree.x,
                preOrder(tree.left),
                preOrder(tree.right));
    }

    public String postOrder(BstNode tree) {
        if (tree == null) return "";
        
        return String.format("%s %s %s", 
            postOrder(tree.left),
            postOrder(tree.right),
            tree.x);
    }
    
}
