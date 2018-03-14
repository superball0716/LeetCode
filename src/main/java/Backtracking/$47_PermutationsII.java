package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 * @author superball
 * @time 2018年3月14日下午1:40:21
 */
public class $47_PermutationsII {
	
	public static void main(String [] args){
		$47_PermutationsII main = new $47_PermutationsII ();
		List<List<Integer>> ress = main.permuteUnique(new int []{1,2,1});
		for(List<Integer> list:ress){
			System.out.println();
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
		}
	}
	
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		boolean visited[] = new boolean[nums.length];
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, list, 0, visited);
		return res;
	}

	private void helper(int nums[], List<Integer> list, int pos, boolean[] visited) {
		if (pos >= nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
				continue;
			}
			list.add(nums[i]);
			visited[i] = true;
			helper(nums, list, pos + 1, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}
}
