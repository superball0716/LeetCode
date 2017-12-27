package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class Tree_637 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode root_left = new TreeNode(9);
		TreeNode root_right = new TreeNode(20);
		TreeNode root_right_left = new TreeNode(15);
		TreeNode root_right_right = new TreeNode(7);
		root.left = root_left;
		root.right = root_right;
		root_right.left = root_right_left;
		root_right.right = root_right_right;
		
		Tree_637 main = new Tree_637();
		System.out.print(main.averageOfLevels(root));
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<Double>();
		if (root == null) {
			return res;
		}
		double thisAverage = root.val;
		List<TreeNode> thisLevel = new ArrayList<TreeNode>();
		thisLevel.add(root);
		while (thisLevel.size() != 0) {
			thisAverage = averageOfLevel(thisLevel);
			res.add(thisAverage);
			thisLevel = nextLevel(thisLevel);
		}
		return res;
	}

	private List<TreeNode> nextLevel(List<TreeNode> list) {
		List<TreeNode> nextLevel = new ArrayList<TreeNode>();
		for (TreeNode node : list) {
			if (node.left != null) {
				nextLevel.add(node.left);
			}
			if (node.right != null) {
				nextLevel.add(node.right);
			}
		}
		return nextLevel;
	}

	private Double averageOfLevel(List<TreeNode> list) {
		double average = 0.0;
		for (TreeNode node : list) {
			average += node.val;
		}
		return average / list.size();
	}
	
	//——————————————————————————————————————————————————————————————
    public List<Double> averageOfLevels_(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();

        queue.add(root);
        while (queue.size()!=0){
            int n = queue.size();
            double sum = 0;
            for (int i = 0; i < n; i++){
                TreeNode p = queue.peek();
                queue.remove();
                sum += p.val;
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);             
            }
            
            list.add(sum/n);
        }
        return list;
    }
    //——————————————————————————————————————————————————————————————
    /* 
     * LinkedList提供了方法支持队列的行为，并且它实现了Queue接口，因此LinkedList可以用作Queue的一种实现。
     * 
     * offer()和add()将一个元素插入到队尾,查看源码发现offer()的实现即调用add()
     * peek()和element()都是在移除的情况下返回队头 
     *     peek()方法在队列为空时返回null，element()会抛出NoSuchElementException异常 
     * poll()和remove()方法将移除并返回队头 
     *     poll()在队列为空时返回null，而remove()会抛出NoSuchElementException异常 
     */  
}
