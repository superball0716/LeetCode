package huawei410;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *题目描述
给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
举例！假设原始字符串为：
eeefgghhh
则每种字符出现的次数分别是：
(1).eee        3次
(2).f          1次
(3).gg         2次
(4).hhh        3次
重排输出后的字符串如下：
efghegheh
编写程序，实现上述功能。
【温馨提示】
(1).原始字符串中仅可能出现“数字”和“字母”；
(2).请注意区分字母大小写。

输入描述:
eeefgghhh
输出描述:
efghegheh
示例1
输入
eeefgghhh
输出
efghegheh
 * @author superball
 * @time 2018年4月10日下午7:03:36
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (char c : string.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean ischanged = true;
		while (ischanged) {
			 ischanged = false;
			for (char c : map.keySet()) {
				if (map.get(c) != 0) {
					sb.append(c);
					map.put(c, map.get(c) - 1);
					ischanged = true;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
