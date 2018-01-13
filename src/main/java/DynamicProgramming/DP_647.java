package DynamicProgramming;

/**
 Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
马拉车算法
 * @author superball
 * @time 2018年1月13日下午9:45:29
 */
public class DP_647 {
	public static void main(String[] args) {
		DP_647 main = new DP_647();
		System.out.println(main.countSubstrings("aaa"));
	}

	public int countSubstrings(String s) {
		StringBuffer sb = new StringBuffer("$#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append("#");
		}
		sb.append("@");
		int[] p = new int[sb.length()];
		int id = 0;
		int mx = 0;
		for (int i = 1; i < sb.length() - 1; i++) {
			if (i < mx) {
				p[i] = Math.min(mx - i, p[2 * id - i]);
			}
			while (sb.charAt(i + p[i] + 1) == sb.charAt(i - p[i] - 1)) {
				p[i]++;
			}
			if (i + p[i] > mx) {
				mx = i + p[i];
				id = i;
			}
		}
		int sum = 0;
		for (int i : p) {
			sum += (i + 1) / 2;
		}
		return sum;
	}
}
