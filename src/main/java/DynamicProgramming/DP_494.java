package DynamicProgramming;

/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 * @author superball
 * @time 2018年1月16日下午9:44:04
 */
public class DP_494 {

	public static void main(String[] args) {
		DP_494 main = new DP_494();
		System.out.println(main.findTargetSumWays(new int[] {0,0,0,0,0,0,0,0,1}, 1));
	}

	public int findTargetSumWays(int[] nums, int S) {
		return helper(nums, nums.length, S);
	}

	private int helper(int[] nums, int n, int S) {
		if (n == 1) {
			if (nums[0] == S || nums[0] == -S) {
				if (S == 0) {
					return 2;
				} else {
					return 1;
				}
			} else {
				return 0;
			}
		}
		return helper(nums, n - 1, S + nums[n - 1]) + helper(nums, n - 1, S - nums[n - 1]);
	}
}
