package DynamicProgramming;

/**
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * @author superball
 * @time 2018年1月13日下午2:13:09
 */
public class DP_338 {
	public static void main(String[] args) {
		DP_338 main = new DP_338();
		int[] res = main.countBits(5);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		for (int i = 1; i <= num; i++) {
			res[i] = res[i / 2] + i % 2;
		}
		return res;
	}
}
