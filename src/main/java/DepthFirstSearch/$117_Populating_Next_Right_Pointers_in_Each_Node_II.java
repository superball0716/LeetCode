package DepthFirstSearch;

import Tree.TreeLinkNode;

/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author superball
 * @time 2018年3月28日上午10:56:02
 */
public class $117_Populating_Next_Right_Pointers_in_Each_Node_II {
	public void connect(TreeLinkNode root) {
		TreeLinkNode curHead = root;
		while (curHead != null) {
			TreeLinkNode nextHeadPre = new TreeLinkNode(0);
			TreeLinkNode nextTail = nextHeadPre;
			TreeLinkNode node = curHead;
			while (node != null) {
				if (node.left != null) {
					nextTail.next = node.left;
					nextTail = node.left;
				}
				if (node.right != null) {
					nextTail.next = node.right;
					nextTail = node.right;
				}
				node = node.next;
			}
			curHead = nextHeadPre.next;
		}
	}
}
