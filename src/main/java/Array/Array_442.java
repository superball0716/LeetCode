package Array;

import java.util.ArrayList;
import java.util.List;

/**
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * @author superball
 * @time 2018年1月19日下午8:20:15
 */
public class Array_442 {
	public static void main(String[] args) {
		Array_442 main = new Array_442();
		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> res = main.findDuplicates(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public List<Integer> findDuplicates(int[] nums) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] temp = new int[nums.length + 1];
		for (int i : nums) {
			temp[i]++;
		}
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] == 2) {
				list.add(i);
			}
		}
		return list;
	}
}
