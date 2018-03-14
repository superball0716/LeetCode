package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author superball
 * @time 2018年3月14日下午2:05:25
 */
public class $77_Combinations {

	public static void main(String[] args) {
		$77_Combinations main = new $77_Combinations();
		List<List<Integer>> ress = main.combine(4, 2);
		for (List<Integer> list : ress) {
			System.out.println();
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		helper(n, k, list, 1, res);
		return res;
	}

	private void helper(int n, int k, List<Integer> list, int start, List<List<Integer>> res) {
		if (k == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			helper(n, k - 1, list, i + 1, res);
			list.remove(list.size() - 1);
		}
	}
}
