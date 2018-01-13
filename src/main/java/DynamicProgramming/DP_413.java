package DynamicProgramming;

/**
 A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * @author superball
 * @time 2018年1月14日上午12:59:00
 */
public class DP_413 {
	public static void main(String[] args) {
		DP_413 main = new DP_413();
		System.out.println(main.numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));
	}

	public int numberOfArithmeticSlices(int[] A) {
		int sum = 0;
		int dp = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp++;
				sum += dp;
			} else {
				dp = 0;
			}
		}
		return sum;
	}
}
