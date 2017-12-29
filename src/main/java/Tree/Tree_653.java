package Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 * @author superball
 * @time 2017年12月30日上午1:57:39
 */
public final class Tree_653 {
	public boolean findTarget(TreeNode root, int k) {
		Set<Integer> set = new HashSet<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int val = node.val;
			if (set.contains(k - val)) {
				return true;
			} else {
				set.add(val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return false;
	}
	/*
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). We need to traverse over the whole tree once in the worst case. Here, n n refers to the number of nodes in the given tree.
	 * 
	 * Space complexity :O(n). The size of the s e t set can grow atmost upto n n.
	 */
}
