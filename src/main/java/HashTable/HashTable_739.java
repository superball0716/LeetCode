package HashTable;

import java.util.Stack;

/**
 Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * @author superball
 * @time 2018年1月11日下午5:32:50
 */
public class HashTable_739 {
	public static void main(String[] args) {
		int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
		HashTable_739 main = new HashTable_739();
		int[] res = main.dailyTemperatures(temperatures);
		for (int i : res) {
			System.out.println(i + " ");
		}
	}

	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
				stack.pop();
			}
			res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return res;
	}
}
