package Tree;

/**
 *
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L). You might
 * need to change the root of the tree, so the result should return the new root
 * of the trimmed binary search tree.
 * 
Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 * 
 * @author superball
 * @time 2017年12月29日上午12:10:48
 */
public class Tree_669 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(0);
		TreeNode root_right = new TreeNode(2);
		root.left = root_left;
		root.right = root_right;

		Tree_669 main = new Tree_669();
		System.out.println(main.trimBST(root, 1, 2).val);
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return root;
		}
		if (root.val < L) {
			return trimBST(root.right, L, R);
		}
		if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}
	/*
	 * Complexity Analysis
	 * Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each node at most once. 
	 * SpaceComplexity: O(N). Even though we don't explicitly use any additional memory, the call stack of our recursion could be as large as the number of nodes in the worst case.
	 * 
	 */
}
