package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
*@author superball
*@time 2017年12月29日下午2:40:38
*/
public class Tree_513 {
	public static void main(String [] args){
		TreeNode root = new TreeNode(2);
		TreeNode root_left = new TreeNode(1);
		TreeNode root_right = new TreeNode(3);
		root.left = root_left;
		root.right = root_right;
		
		Tree_513 main = new Tree_513();
		System.out.println(main.findBottomLeftValue(root));
	}
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode node = queue.poll();
            	if(i==0){
            		res = node.val;
            	}
                if(node.left!=null){
                    queue.add(node.left);
                }	
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
