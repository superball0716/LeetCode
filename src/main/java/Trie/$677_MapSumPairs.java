package Trie;

import java.util.HashMap;

/**
Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
*@author superball
*@time 2018年3月23日下午4:47:44
*/
public class $677_MapSumPairs {
    HashMap<String, Integer> map;
    TrieNode root;
    /** Initialize your data structure here. */
    public $677_MapSumPairs() {
    	map = new HashMap<>();
    	root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        int delta = val-map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        for(char c:key.toCharArray()){
        	cur.children.putIfAbsent(c, new TrieNode());
        	cur = cur.children.get(c);
        	cur.value+=delta;
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for(char c:prefix.toCharArray()){
        	cur = cur.children.get(c);
        	if(cur==null){
        		return 0;
        	}
        }
        return cur.value;
    }
}

class TrieNode{
	HashMap<Character, TrieNode> children = new HashMap<>();
	int value;
}