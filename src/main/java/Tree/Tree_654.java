package Tree;
/**
*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

*@author superball
*@time 2017年12月28日下午1:26:40
*/
public class Tree_654 {
	
	public static void main(String [] args){
		int [] nums = new int [] {3,2,1,6,0,5};
		Tree_654 main = new Tree_654();
		System.out.println(main.constructMaximumBinaryTree(nums).val);
	}
	
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }
    
    private TreeNode construct(int [] nums,int l,int r){
    	if(l==r){
    		return null;
    	}
    	int maxIndex = l;
    	for(int i=l;i<r;i++){
    		if(nums[i]>nums[maxIndex]){
    			maxIndex = i;
    		}
    	}
    	TreeNode root = new TreeNode(nums[maxIndex]);
    	root.left = construct(nums,l,maxIndex);
    	root.right = construct(nums,maxIndex+1,r);
    	return root;
    }
    
    /*
    Complexity Analysis
	Time complexity : O(n2). 
	The function construct is called n times. At each level of the recursive tree, we traverse over all the n elements to find the maximum element. 
	In the average case, there will be a log(n) levels leading to a complexity of O(nlog(n)). 
	In the worst case, the depth of the recursive tree can grow upto n, which happens in the case of a sorted nums array, giving a complexity of O(n2).
	Space complexity : O(n). 
	The size of the set can grow upto n in the worst case. 
	In the average case, the size will be log(n) for n elements in nums, giving an average case complexity of O(log(n)).
     */
}
