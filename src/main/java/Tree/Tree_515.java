package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
*You need to find the largest value in each row of a binary tree.
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*@author superball
*@time 2017年12月27日下午11:52:28
*/
public class Tree_515 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(3);
		TreeNode root_right = new TreeNode(2);
		TreeNode root_left_left = new TreeNode(5);
		TreeNode root_left_right = new TreeNode(3);
		TreeNode root_right_right = new TreeNode(9);
		root.left = root_left;
		root.right = root_right;
		root_left.left = root_left_left;
		root_left.right = root_left_right;
		root_right.right = root_right_right;
		
		Tree_515 main = new Tree_515();
		System.out.print(main.largestValues(root));
	}
	
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root==null){
    		return res;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(queue.size()!=0){
    		int n = queue.size();
    		int max = Integer.MIN_VALUE;
    		for(int i=0;i<n;i++){
    			TreeNode node = queue.poll();
    			max = Math.max(max, node.val);
    			if(node.left!=null){
    				queue.add(node.left);
    			}
    			if(node.right!=null){
    				queue.add(node.right);
    			}
    		} 
    		res.add(max);
    	}
        return res;
    }
    
    //————————————————————————————————————————————————————————————
    public List<Integer> largestValues_(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = null;
        q.add(root);
        q.add(null);
        
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            cur = q.poll();
            while (cur != null) {
                max = Math.max(max, cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                cur = q.poll();
            }
            res.add(max);
            if (!q.isEmpty()) {
                q.add(null);
            }
        }
        
        return res;
    }
    //————————————————————————————————————————————————————————————
}
