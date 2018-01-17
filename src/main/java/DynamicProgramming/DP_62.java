package DynamicProgramming;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * @author superball
 * @time 2018年1月17日下午5:32:07
 */
public class DP_62 {
	public static void main(String[] args) {
		DP_62 main = new DP_62();
		System.out.println(main.uniquePaths(2, 2));
	}

	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		while (m > 1) {
			for (int i = n - 2; i >= 0; i--) {
				dp[i] = dp[i] + dp[i + 1];
			}
			m--;
		}
		return dp[0];
	}
}
