package Trie;

import java.util.List;

/**
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
 * @author superball
 * @time 2018年3月24日下午2:42:13
 */
public class $648_ReplaceWords {
	public String replaceWords(List<String> dict, String sentence) {
		Trie root = new Trie();
		for (String string : dict) {
			Trie cur = root;
			for (char c : string.toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new Trie();
				}
				cur = cur.children[c - 'a'];
			}
			cur.word = string;
		}

		StringBuilder sb = new StringBuilder();
		for (String string : sentence.split(" ")) {
			if (sb.length() > 0) {
				sb.append(" ");
			}
			Trie cur = root;
			for (char c : string.toCharArray()) {
				if (cur.children[c - 'a'] == null || cur.word != null) {
					break;// 没有下一个children或者当前节点是叶子节点
				}
				cur = cur.children[c - 'a'];
			}
			sb.append(cur.word != null ? cur.word : string);
		}
		return sb.toString();
	}
}

class Trie {
	Trie[] children;
	String word;

	public Trie() {
		children = new Trie[26];
	}
}