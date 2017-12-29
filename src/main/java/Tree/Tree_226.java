package Tree;

/**
Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * @author superball
 * @time 2017年12月29日下午4:36:16
 */
public class Tree_226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	/*
	 * Complexity Analysis
	 * 
	 * Since each node in the tree is visited only once, the time complexity is O(n), where n is the number of nodes in the tree. 
	 * We cannot do better than that, since at the very least we have to visit each node to invert it.
	 * 
	 * Because of recursion, O(h) function calls will be placed on the stack in the worst case, where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
	 */
}
