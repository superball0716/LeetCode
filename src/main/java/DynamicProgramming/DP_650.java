package DynamicProgramming;

/**
Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

Example 1:
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
 * @author superball
 * @time 2018年1月15日下午10:29:56
 */
public class DP_650 {

	public static void main(String[] args) {
		DP_650 main = new DP_650();
		System.out.println(main.minSteps(3));

	}

	public int minSteps(int n) {
		int res = 0;
		int prime[] = getPrime(n);
		int i = 0;
		while (n > 1) {
			while (n % prime[i] == 0) {
				res += prime[i];
				n /= prime[i];
			}
			i++;
		}
		return res;
	}

	private int[] getPrime(int n) {
		int[] prime = new int[n];
		prime[0] = 2;
		int k = 1;
		for (int i = 3; i <= n; i++) {
			int j = 0;
			while (prime[j] > 0 && prime[j] <= Math.sqrt(i)) {
				if (i % prime[j] == 0) {
					break;
				}
				j++;
			}
			if (prime[j] == 0 || prime[j] > Math.sqrt(i)) {
				prime[k] = i;
				k++;
			}
		}
		return prime;
	}

	// ————————————————————————————————————————
	int minSteps_(int n) {
		if (n == 1)
			return 0;
		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return i + minSteps(n / i);
		return n;
	}
	// ————————————————————————————————————————
}
