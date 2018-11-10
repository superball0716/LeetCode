package huawei;

import java.util.Scanner;

/**
 *
 * @author superball
 * @time 2018年3月28日下午7:18:49
 */
public class Main1 {
	public static void main(String[] args) {
		int n = 21;
		int m = 4;
		Scanner scanner = new Scanner(System.in);
		int[] rake = new int[n];
		for (int i = 0; i < n; i++) {
			rake[i] = scanner.nextInt();
		}
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += rake[i];
		}
		int maxsum = sum;
		int maxi = 0;
		for (int i = 0; i < n - m; i++) {
			sum = sum + rake[i + m] - rake[i];
			if (sum > maxsum) {
				maxsum = sum;
				maxi = i + 1;
			}
		}
		System.out.println(maxi);
	}
}
