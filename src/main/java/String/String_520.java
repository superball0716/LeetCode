package String;

/**
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
 * @author superball
 * @time 2018年1月18日下午3:37:12
 */
public class String_520 {
	public static void main(String[] args) {
		String_520 main = new String_520();
		System.out.println(main.detectCapitalUse("USA"));
	}

	public boolean detectCapitalUse(String word) {
		if (word.length() == 0) {
			return true;
		}
		if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
			return isAllLower(word);
		}
		if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
			return isAllLower(word.substring(1)) || isAllUpper(word.substring(1));
		}
		return false;
	}

	private boolean isAllLower(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
				return false;
			}
		}
		return true;
	}

	private boolean isAllUpper(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 'A' || word.charAt(i) > 'Z') {
				return false;
			}
		}
		return true;
	}
}
