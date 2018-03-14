package Backtracking;

import java.util.ArrayList;
import java.util.List;

import javax.media.j3d.IndexedPointArray;

/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author superball
 * @time 2018年3月14日下午3:21:36
 */
public class $78_Subsets {

	public static void main(String[] args) {
		$78_Subsets main = new $78_Subsets();
		List<List<Integer>> ress = main.subsets(new int[] { 1, 2, 3 });
		for (List<Integer> list : ress) {
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, 0, res, list);
		return res;

	}

	private void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
		res.add(new ArrayList<Integer>(list));
		if (start == nums.length) {
			return;
		}
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(nums, i + 1, res, list);
			list.remove(list.size() - 1);
		}
	}
}
