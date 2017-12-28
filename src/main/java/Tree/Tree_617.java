package Tree;
/**
*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
Note: The merging process must start from the root nodes of both trees.

*@author superball
*@time 2017年12月28日下午1:58:03
*/
public class Tree_617 {
	
	public static void main(String [] args){
		TreeNode root1 = new TreeNode(1);
		TreeNode root1_left = new TreeNode(3);
		TreeNode root1_right = new TreeNode(2);
		TreeNode root1_left_left = new TreeNode(5);
		root1.left = root1_left;
		root1.right = root1_right;
		root1_left.left = root1_left_left;
		
		TreeNode root2 = new TreeNode(2);
		TreeNode root2_left = new TreeNode(1);
		TreeNode root2_right = new TreeNode(3);
		TreeNode root2_left_right = new TreeNode(4);
		TreeNode root2_right_right = new TreeNode(7);
		root2.left = root2_left;
		root2.right = root2_right;
		root2_left.right =  root2_left_right;
		root2_right.right = root2_right_right;
		
		Tree_617 main = new Tree_617();
		System.out.println(main.mergeTrees(root1,root2).val);
	}
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
        	return t2;
        }
        if(t2==null){
        	return t1;
        }
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}
