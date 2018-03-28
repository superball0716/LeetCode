package Tree;

/**
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * @author superball
 * @time 2018年3月28日上午11:16:09
 */
public class $124_BinaryTreeMaximumPathSum {

	int maxSum;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		if (root == null) {
			return 0;
		}
		maxChildSum(root);
		return maxSum;
	}

	private int maxChildSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, maxChildSum(root.left));
		int right = Math.max(0, maxChildSum(root.right));
		maxSum = Math.max(maxSum, root.val + left + right);
		return root.val + Math.max(left, right);
	}
}
