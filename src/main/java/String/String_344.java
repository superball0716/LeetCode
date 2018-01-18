package String;

/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
 * @author superball
 * @time 2018年1月18日下午2:10:02
 */
public class String_344 {
	public static void main(String[] args) {
		String_344 main = new String_344();
		System.out.println(main.reverseString("hello"));
	}

	public String reverseString(String s) {
		char[] sc = s.toCharArray();
		for (int i = 0; i < sc.length / 2; i++) {
			char temp = sc[i];
			sc[i] = sc[sc.length - 1 - i];
			sc[sc.length - 1 - i] = temp;
		}
		return new String(sc);
	}
}
