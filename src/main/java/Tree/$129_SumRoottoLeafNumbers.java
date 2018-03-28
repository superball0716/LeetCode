package Tree;

/**

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 * @author superball
 * @time 2018年3月28日下午2:35:12
 */
public class $129_SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		return sumRoot(root, 0);

	}

	private int sumRoot(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return num * 10 + root.val;
		}
		return sumRoot(root.left, num * 10 + root.val) + sumRoot(root.right, num * 10 + root.val);
	}
}
