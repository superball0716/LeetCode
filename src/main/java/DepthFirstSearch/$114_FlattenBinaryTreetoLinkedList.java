package DepthFirstSearch;

import java.util.Stack;

import Tree.TreeNode;

/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author superball
 * @time 2018年3月28日上午12:43:58
 */
public class $114_FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode cur = stack.pop();
			if(cur.right!=null){
				stack.push(cur.right);
			}
			if(cur.left!=null){
				stack.push(cur.left);
			}
			if(!stack.isEmpty()){
				cur.right = stack.peek();
			}
			cur.left = null;
		}
	}
}
