package DynamicProgramming;

/**
In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.

Example:
Input: [1,2,1,2,6,7,5,1], 2
Output: [0, 3, 5]
Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 * @author superball
 * @time 2018年1月17日下午6:54:19
 */
public class DP_689 {

	public static void main(String[] args) {
		DP_689 main = new DP_689();
		int[] res = main.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sums = new int[nums.length - k + 1];
		for (int i = 0; i < sums.length; i++) {
			for (int j = i; j < i + k; j++) {
				sums[i] += nums[j];
			}
		}
		int[] left = new int[sums.length];
		int best = 0;
		for (int i = 0; i < left.length; i++) {
			if (sums[i] > sums[best]) {
				best = i;
			}
			left[i] = best;
		}
		int[] right = new int[sums.length];
		best = sums.length - 1;
		for (int i = sums.length - 1; i >= 0; i--) {
			if (sums[i] >= sums[best]) {
				best = i;
			}
			right[i] = best;
		}
		int[] res = new int[] { -1, -1, -1 };
		for (int a2 = k; a2 < sums.length - k; a2++) {
			if (res[0] == -1 || sums[a2] + sums[left[a2 - k]] + sums[right[a2 + k]] > sums[res[0]] + sums[res[1]]
					+ sums[res[2]]) {
				res[0] = left[a2 - k];
				res[1] = a2;
				res[2] = right[a2 + k];
			}
		}
		return res;
	}

}
