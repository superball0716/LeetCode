package Tree;

/**
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * @author superball
 * @time 2018年3月14日下午8:23:05
 */
public class $106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public static void main(String[] args) {
		$106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal main = new $106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
		TreeNode root = main.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
		System.out.println(root.val);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
		if (postEnd < 0 || inEnd < inStart) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				inIndex = i;
			}
		}
		root.left = helper(postEnd - (inEnd - inIndex + 1), inStart, inIndex - 1, inorder, postorder);
		root.right = helper(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
		return root;
	}
}
