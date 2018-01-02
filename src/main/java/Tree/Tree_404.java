package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * @author superball
 * @time 2018年1月2日下午11:47:45
 */
public class Tree_404 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode root_left = new TreeNode(9);
		TreeNode root_right = new TreeNode(20);
		TreeNode root_right_left = new TreeNode(15);
		TreeNode root_right_right = new TreeNode(7);
		root.left = root_left;
		root.right = root_right;
		root_right.left = root_right_left;
		root_right.right = root_right_right;

		Tree_404 main = new Tree_404();
		System.out.println(main.sumOfLeftLeaves(root));
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return 0;
		}

		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr.left != null && curr.left.left == null && curr.left.right == null) {
				res += curr.left.val;
			}
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
		}
		return res;
	}
}
