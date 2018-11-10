package Nowcoder;

import java.util.Scanner;

/**
数字颠倒

描述：

输入一个整数，将这个整数以字符串的形式逆序输出

程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001

 

输入描述:
输入一个int整数

输出描述:
将这个整数以字符串的形式逆序输出

示例1
输入
1516000
输出
0006151
 * @author superball
 * @time 2018年3月15日下午6:57:53
 */
public class ReverseInt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		String iString = String.valueOf(i);
		StringBuilder sb = new StringBuilder();
		for (int j = iString.length() - 1; j >= 0; j--) {
			sb.append(iString.charAt(j));
		}
		System.out.println(sb.toString());
	}
}
