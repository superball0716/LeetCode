package Tree;

/**
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 * @author superball
 * @time 2018年1月4日下午2:32:15
 */
public class Tree_100 {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root1_left = new TreeNode(2);
		TreeNode root1_right = new TreeNode(3);
		root1.left = root1_left;
		root1.right = root1_right;

		TreeNode root2 = new TreeNode(1);
		TreeNode root2_left = new TreeNode(2);
		TreeNode root2_right = new TreeNode(3);
		root2.left = root2_left;
		root2.right = root2_right;

		Tree_100 main = new Tree_100();
		System.out.println(main.isSameTree(root1, root2));

		TreeNode root3 = new TreeNode(1);
		TreeNode root3_left = new TreeNode(2);
		TreeNode root4 = new TreeNode(1);
		TreeNode root4_right = new TreeNode(2);
		root3.left = root3_left;
		root4.right = root4_right;
		System.out.println(main.isSameTree(root3, root4));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
