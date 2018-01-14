package DynamicProgramming;

/**
Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2. 
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2). 
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5. 
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 * @author superball
 * @time 2018年1月14日下午11:27:32
 */
public class DP_486 {
	public static void main(String[] args) {

		DP_486 main = new DP_486();
		System.out.println(main.PredictTheWinner(new int[] { 9337301, 0, 2, 2245036, 4, 1997658, 5, 2192224, 960000,
				1261120, 8824737, 1, 1161367, 9479977, 7, 2356738, 5, 4, 9 }));
	}

	public boolean PredictTheWinner(int[] nums) {
		// int[][] dp = new int[nums.length][nums.length];
		// for (int i = 0; i < nums.length; i++) {
		// dp[i][i] = nums[i];
		// }
		// for (int i = nums.length - 2; i >= 0; i--) {
		// for (int j = i + 1; j < nums.length; j++) {
		// dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
		// }
		// }
		// return dp[0][nums.length - 1] >= 0;
		int[] dp = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			dp[i] = nums[i];
		}
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				dp[j] = Math.max(nums[i]-dp[j], nums[j]-dp[j-1]);
			}
		}
		return dp[nums.length - 1] >= 0;
	}
}
