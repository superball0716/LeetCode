package Array;

import java.util.Arrays;

/**
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * @author superball
 * @time 2018年1月19日下午7:51:27
 */
public class Array_561 {

	public static void main(String[] args) {
		Array_561 main = new Array_561();
		System.out.println(main.arrayPairSum(new int[] { 1, 4, 3, 2 }));
	}

	public int arrayPairSum(int[] nums) {
		int res = 0;
		Arrays.sort(nums);
		for (int i = nums.length - 2; i >= 0; i -= 2) {
			res += nums[i];
		}
		return res;
	}
}
