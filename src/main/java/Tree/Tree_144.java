package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author superball
 * @time 2018年1月4日下午5:10:55
 */
public class Tree_144 {
	List<Integer> res = new ArrayList<Integer>();

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			res.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return res;
	}
	
    public List<Integer> preorderTraversal_(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null){
            list.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            root = root.left;
            if(root==null&&!stack.isEmpty()){
                root = stack.pop();
            }
        }
        return list;
    }
}
