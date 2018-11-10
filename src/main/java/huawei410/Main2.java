package huawei410;

import java.util.Scanner;


/**
 * 题目描述
 * 给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，每个数的值表示你从这个位置可以跳跃的最大长度。计算如何以最少的跳跃次数跳到最后一个数。
 * 
 * 输入描述: 第一行表示有多少个数n 第二行开始依次是1到n个数，一个数一行 输出描述: 输出一行，表示最少跳跃的次数。 示例1 输入 7 2 3 2 1
 * 2 1 5 输出 3 说明
 * 7表示接下来要输入7个正整数，从2开始。数字本身代表可以跳跃的最大步长，此时有2种跳法，为2-2-2-5和2-3-2-5都为3步
 * 
 * @author superball
 * @time 2018年4月10日下午7:23:49
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}
		for (int i = n - 2; i >= 0; i--) {
			if (i + nums[i] >= n - 1) {
				dp[i] = 1;
			}
		}
		for (int i = n - 3; i >= 0; i--) {
			if (dp[i] != 1) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= nums[i] && i + j < n; j++) {
					min = Math.min(min, 1 + dp[i + j]);
				}
				dp[i] = min;
			}
		}
		System.out.println(dp[0]);
	}
}
