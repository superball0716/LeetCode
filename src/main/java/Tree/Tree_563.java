package Tree;

/**
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
 * @author superball
 * @time 2018年1月3日下午11:56:42
 */
public class Tree_563 {
	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(3);
		root.left = root_left;
		root.right = root_right;
		
		Tree_563 main = new Tree_563();
		System.out.println(main.findTilt(root));
	}

	private int res = 0;

	public int findTilt(TreeNode root) {
		getSum(root);
		return res;
	}

	private int getSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getSum(root.left);
		int right = getSum(root.right);
		res += Math.abs(left - right);
		return left + right + root.val;
	}
	/**
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). where n n is the number of nodes. Each node is visited once. 
	 * Space complexity : O(n). In worst case when the tree is skewed depth of tree will be n. In average case depth will be logn.
	 */
}
