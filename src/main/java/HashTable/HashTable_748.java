package HashTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
 * @author superball
 * @time 2018年1月11日下午3:53:26
 */
public class HashTable_748 {
	public static void main(String[] args) {
		String licensePlate = "Ah71752";
		String[] words = new String[] { "suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent",
				"writer", "old" };
		HashTable_748 main = new HashTable_748();
		System.out.println(main.shortestCompletingWord(licensePlate, words));
	}

	public String shortestCompletingWord(String licensePlate, String[] words) {
		String res = "";
		licensePlate = licensePlate.toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : licensePlate.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				int temp = map.getOrDefault(c, 0);
				map.put(c, ++temp);
			}
		}
		for (String word : words) {
			if (res.equals("")) {
				if (isCompleted(word, map)) {
					res = word;
				}
			} else {
				if (res.length() > word.length()) {
					if (isCompleted(word, map)) {
						res = word;
					}
				}
			}

		}
		return res;
	}

	private boolean isCompleted(String word, Map<Character, Integer> map) {
		Map<Character, Integer> newMap = new HashMap<>();
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			newMap.put((char) entry.getKey(), (int) entry.getValue());
		}
		// map为引用传递，newMap是为了不改变map的值
		for (char c : word.toCharArray()) {
			if (newMap.containsKey(c)) {
				int i = (int) newMap.get(c);
				if (i == 1) {
					newMap.remove(c);
				} else {
					newMap.put(c, --i);
				}
			}
		}
		boolean isEampty = newMap.isEmpty();
		return isEampty;
	}

	// ————————————————————————————————————————————————————————————————————
	public String shortestCompletingWord_(String licensePlate, String[] words) {
		int[] target = count(licensePlate);
		String ans = "";
		for (String word : words)
			if ((word.length() < ans.length() || ans.length() == 0) && dominates(count(word.toLowerCase()), target))
				ans = word;
		return ans;
	}

	public boolean dominates(int[] count1, int[] count2) {
		for (int i = 0; i < 26; ++i)
			if (count1[i] < count2[i])
				return false;
		return true;
	}

	public int[] count(String word) {
		int[] ans = new int[26];
		for (char letter : word.toCharArray()) {
			int index = Character.toLowerCase(letter) - 'a';
			if (0 <= index && index < 26)
				ans[index]++;
		}
		return ans;
	}
	/*
	 * Time Complexity: O(N) where N N is the length of words, and assuming the
	 * lengths of licensePlate and words[i] are bounded by O(1).
	 * 
	 * Space Complexity: O(1) in additional space.
	 */
	// ————————————————————————————————————————————————————————————————————
}
