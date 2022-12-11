package group.rookie.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode riNode) {
        this.val = val;
        this.right = riNode;
        this.left = left;
    }
}
