package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1], and P[1] = 4 because the 1st element of A appears at B[4], and so on.
 * @author superball
 * @time 2018年1月11日下午2:57:57
 */
public class HashTable_760 {
	public static void main(String[] args) {
		int[] A = new int[] { 12, 28, 46, 32, 50 };
		int[] B = new int[] { 50, 12, 32, 46, 28 };
		HashTable_760 main = new HashTable_760();
		int[] res = main.anagramMappings(A, B);
		for (int i : res) {
			System.out.println(i + " ");
		}

	}

	public int[] anagramMappings(int[] A, int[] B) {
		int[] res = new int[A.length];
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < B.length; i++) {
//			if (map.containsKey(B[i])) {
//				List<Integer> temp = map.get(B[i]);
//				temp.add(i);
//				map.put(B[i], temp);
//			} else {
//				List<Integer> temp = new ArrayList<Integer>();
//				temp.add(i);
//				map.put(B[i], temp);
//			}
			List<Integer> temp = map.getOrDefault(B[i], new ArrayList<Integer>());
			temp.add(i);
			map.put(B[i], temp);	
		}
		for (int i = 0; i < A.length; i++) {
			res[i] = map.get(A[i]).get(0);
			if (map.get(A[i]).size() > 1) {
				List<Integer> temp = map.get(A[i]);
				temp.remove(0);
				map.put(A[i], temp);
			} else {
				map.remove(A[i]);
			}
		}
		return res;
	}
}
