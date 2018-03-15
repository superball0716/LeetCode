package DepthFirstSearch;

import java.util.Stack;

import Tree.TreeNode;

/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author superball
 * @time 2018年3月15日上午12:27:14
 */
public class $122_PathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(3);
		root.left = root_left;
		root.right = root_right;
		$122_PathSum main = new $122_PathSum();
		System.out.println(main.hasPathSum(root, 3));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
