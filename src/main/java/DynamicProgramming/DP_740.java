package DynamicProgramming;

import java.util.Arrays;

/**
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
Example 2:
Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
 * @author superball
 * @time 2018年1月17日上午1:01:18
 */
public class DP_740 {
	public static void main(String[] args) {
		DP_740 main = new DP_740();
		System.out.println(main.deleteAndEarn(new int[] { 2, 3, 2, 3, 3, 4 }));
	}

	public int deleteAndEarn(int[] nums) {
		Arrays.sort(nums);
		int avoid = 0;
		int use = 0;
		int pre = -10;
		int i = 0;
		while (i < nums.length) {
			int m = Math.max(use, avoid);
			int count = 1;
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				count++;
				i++;
			}
			if (nums[i] - 1 != pre) {
				use = nums[i] * count + m;
			} else {
				use = nums[i] * count + avoid;
			}
			avoid = m;
			pre = nums[i];
			i++;
		}
		return Math.max(avoid, use);
	}
}
