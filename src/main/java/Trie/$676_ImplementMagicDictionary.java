package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * @author superball
 * @time 2018年3月24日上午1:19:25
 */
public class $676_ImplementMagicDictionary {

	Set<String> set;
	HashMap<String, Integer> map;

	/** Initialize your data structure here. */
	public $676_ImplementMagicDictionary() {
		set = new HashSet<>();
		map = new HashMap<>();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String string : dict) {
			set.add(string);
			for (String word : generalizeNeighbors(string)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
	}

	private ArrayList<String> generalizeNeighbors(String string) {
		ArrayList<String> list = new ArrayList<>();
		char[] strc = string.toCharArray();
		for(int i=0;i<strc.length;i++){
			char temp = strc[i];
			strc[i] = '*';
			list.add(new String(strc));
			strc[i] = temp;
		}
		return list;
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
	public boolean search(String word) {
		for(String neighbor:generalizeNeighbors(word)){
			int count = map.getOrDefault(neighbor, 0);
			if(count>1||count==1&&!set.contains(word)){
				return true;
			}
		}
		return false;
	}
}
