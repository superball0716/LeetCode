package DynamicProgramming;

/**
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99]) * @author superball
 * @time 2018年1月14日下午11:10:38
 */
public class DP_357 {

	public static void main(String[] args) {
		DP_357 main = new DP_357();
		System.out.println(main.countNumbersWithUniqueDigits(3));
	}

	public int countNumbersWithUniqueDigits(int n) {
		int d = 1;
		int c = 9;
		for (int i = 1; i <= n; i++) {
			d += c;
			c *= (10 - i);
		}
		return d;
	}
	/*
	 * d[0]=1
	 * d[1]=9*9+d[1]
	 * d[2]=9*9*8+d[2]
	 * d[3]=9*9*8*7+d[3]
	 */

}
