package DepthFirstSearch;

import Tree.TreeLinkNode;

/**
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author superball
 * @time 2018年3月21日下午3:41:14
 */
public class $116_Populating_Next_Right_Pointers_in_Each_Node {
	public void connect(TreeLinkNode root) {
		TreeLinkNode pre = root;
		while(pre!=null){
			TreeLinkNode cur = pre;
			while(cur!=null){
				if(cur.left!=null){
					cur.left.next=cur.right;
				}
				if(cur.right!=null&&cur.next!=null){
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			pre = pre.left;
		}
	}
}
