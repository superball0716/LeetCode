package huawei;

import java.util.Scanner;

/**
 *
 * @author superball
 * @time 2018年3月28日下午8:11:58
 */
public class Main {
	public static void main(String[] args) {
		char[] cs = new char[] { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J',
				'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		for (char c : string.toCharArray()) {
			if (c >= 'A' && c <= 'Z') {
				sb.append(cs[c - 'A']);
			} else if (c >= 'a' && c <= 'z') {
				sb.append((char)(cs[c - 'a']-'A'+'a'));
			} else {
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}
}
