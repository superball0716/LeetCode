package Tree;

/**
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * @author superball
 * @time 2018年1月4日下午5:55:04
 */
public class Tree_543 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(3);
		TreeNode root_left_left = new TreeNode(4);
		TreeNode root_left_right = new TreeNode(5);
		root.left = root_left;
		root.right = root_right;
		root_left.left = root_left_left;
		root_left.right = root_left_right;
		
		Tree_543 main = new Tree_543();
		System.out.println(main.diameterOfBinaryTree(root));
	}

	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		getDeepth(root);
		return diameter;
	}

	private int getDeepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getDeepth(root.left);
		int right = getDeepth(root.right);
		diameter = Math.max(diameter, left + right);
		return Math.max(left, right) + 1;
	}
}
