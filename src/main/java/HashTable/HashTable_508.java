package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Tree.TreeNode;

/**
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 * @author superball
 * @time 2018年1月12日下午3:26:58
 */
public class HashTable_508 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode root_left = new TreeNode(2);
		TreeNode root_right = new TreeNode(-5);
		root.left = root_left;
		root.right = root_right;

		HashTable_508 main = new HashTable_508();
		int[] res = main.findFrequentTreeSum(root);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	int maxFrequent;
	Map<Integer, Integer> map;

	public int[] findFrequentTreeSum(TreeNode root) {
		maxFrequent = 0;
		map = new HashMap<>();
		sumOfRoot(root);
		List<Integer> list = new ArrayList<>();
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			if ((Integer) entry.getValue() == maxFrequent) {
				list.add((Integer) entry.getKey());
			}
		}
		int res[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private int sumOfRoot(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = sumOfRoot(root.left);
		int right = sumOfRoot(root.right);
		int sum = root.val + left + right;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		maxFrequent = Math.max(maxFrequent, map.get(sum));
		return sum;
	}
}
