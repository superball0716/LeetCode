package DynamicProgramming;

/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 * @author superball
 * @time 2018年1月17日下午2:55:14
 */
public class DP_516 {
	public static void main(String[] args) {
		DP_516 main = new DP_516();
		System.out.println(main.longestPalindromeSubseq("aabcdba"));
	}

	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
		}
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < dp.length; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}
