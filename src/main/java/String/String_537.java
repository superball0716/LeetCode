package String;

/**
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * @author superball
 * @time 2018年1月18日上午1:10:05
 */
public class String_537 {

	public static void main(String[] args) {
		String_537 main = new String_537();
		System.out.println(main.complexNumberMultiply("1+-1i", "1+-1i"));
	}

	public String complexNumberMultiply(String a, String b) {
		int[] c1 = helper(a);
		int[] c2 = helper(b);
		int ca = c1[0] * c2[0] - c1[1] * c2[1];
		int cb = c1[0] * c2[1] + c1[1] * c2[0];
		return ca + "+" + cb + "i";
	}

	private int[] helper(String x) {
		String[] temp = x.split("\\+");// 转义处理
		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1].replace("i", ""));
		return new int[] { a, b };
	}
}
