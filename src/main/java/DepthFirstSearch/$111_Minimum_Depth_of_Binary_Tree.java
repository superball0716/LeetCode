package DepthFirstSearch;

import Tree.TreeNode;

/**

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author superball
 * @time 2018年3月14日下午10:45:00
 */
public class $111_Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left)+1;
		}
		return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
	}
}
