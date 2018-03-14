package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author superball
 * @time 2018年3月14日上午12:30:02
 */
public class $46_Permutations {
	
	public static void main(String [] args){
		$46_Permutations main = new $46_Permutations ();
		List<List<Integer>> ress = main.permute(new int []{1,2,3});
		for(List<Integer> list:ress){
			System.out.println();
			for(int i=0;i<list.size();i++){
				System.out.print(list.get(i)+" ");
			}
		}
	}
	
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, 0, list);
		return res;
	}

	private void helper(int[] nums, int pos, List<Integer> list) {
		if(pos == nums.length){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(list.contains(nums[i])){
				continue;
			}
			list.add(nums[i]);
			helper(nums, pos+1, list);
			list.remove(list.size()-1);
		}
	}
}
