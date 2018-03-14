package Tree;

import Tree.TreeNode;

/**
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 * @author superball
 * @time 2018年3月14日下午7:28:10
 */
public class $105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	public static void main(String[] args) {
		$105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal main = new $105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
		TreeNode root = main.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		System.out.println(root.val);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart >= preorder.length || inStart >= inorder.length || inEnd < inStart) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == preorder[preStart]) {
				inIndex = i;
				break;
			}
		}
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}
}
