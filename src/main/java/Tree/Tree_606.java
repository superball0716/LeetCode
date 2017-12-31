package Tree;
/**
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
      1
    /   \
   2     3
  /    
 4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
      1
    /   \
   2     3
    \  
     4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
* @author superball
* @time 2017年12月31日下午11:32:32
*/
public class Tree_606 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(3);
		TreeNode root_left_left = new TreeNode(4);
		root.left = root_left;
		root_left.left = root_left_left;
		root.right = root_right;

		Tree_606 main = new Tree_606();
		System.out.println(main.tree2str(root));
	}

	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		if (t.left == null && t.right == null)
			return t.val + "";
		if (t.right == null)
			return t.val + "(" + tree2str(t.left) + ")";
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
	}
	/*
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). The preorder traversal is done over the n nodes of the given Binary Tree.
	 * 
	 * Space complexity : O(n). The depth of the recursion tree can go upto n in case of a skewed tree.
	 */
}
