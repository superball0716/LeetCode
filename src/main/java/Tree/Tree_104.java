package Tree;
/**
*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*@author superball
*@time 2017年12月29日下午4:27:32
*/
public class Tree_104 {
    public int maxDepth(TreeNode root) {
    	if (root==null) {
			return 0;
		}
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
    	return Math.max(left, right)+1;
    }
}
