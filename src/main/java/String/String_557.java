package String;

/**
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 * @author superball
 * @time 2018年1月18日上午1:24:58
 */
public class String_557 {
	public static void main(String[] args) {
		String_557 main = new String_557();
		System.out.println(main.reverseWords("Let's take LeetCode contest"));
	}

	public String reverseWords(String s) {
		String[] ss = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (String string : ss) {
			StringBuilder temp = new StringBuilder(string).reverse();
			// for (int i = string.length() - 1; i >= 0; i--) {
			// temp.append(string.charAt(i));
			// }
			res.append(temp + " ");
		}
		return res.substring(0, res.length() - 1);
	}
}
