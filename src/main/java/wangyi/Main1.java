package wangyi;

import java.util.Scanner;

/**
 *
 * @author superball
 * @time 2018年3月27日下午8:34:42
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int sum = 0;
		// for(int i=k;i<n;i++){
		// sum+=(n-i);
		// }
		sum += (n - k + 1) * (n - k) / 2;
		for (int i = k; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				sum += (n - i) / j;
			}
		}
		System.out.println(sum);
	}
}
