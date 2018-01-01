package Tree;

/**
 Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 * 
 * @author superball
 * @time 2018年1月1日下午10:59:55
 */
public class Tree_538 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(13);
		root.left = root_left;
		root.right = root_right;

		Tree_538 main = new Tree_538();
		System.out.println(main.convertBST(root_right).val);
	}

	private int sum = 0;

	public TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}
	/*
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n)
	 * 
	 * A binary tree has no cycles by definition, so convertBST gets called on
	 * each node no more than once. Other than the recursive calls, convertBST
	 * does a constant amount of work, so a linear number of calls to convertBST
	 * will run in linear time.
	 * 
	 * Space complexity : O(n)
	 * 
	 * Using the prior assertion that convertBST is called a linear number of
	 * times, we can also show that the entire algorithm has linear space
	 * complexity. Consider the worst case, a tree with only right (or only
	 * left) subtrees. The call stack will grow until the end of the longest
	 * path is reached, which in this case includes all n n nodes.
	 */
}
