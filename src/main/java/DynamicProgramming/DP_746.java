package DynamicProgramming;

/**
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * @author superball
 * @time 2018年1月16日上午12:48:25
 */
public class DP_746 {

	public static void main(String[] args) {
		DP_746 main = new DP_746();
		System.out.println(main.minCostClimbingStairs(new int[] { 10, 15, 20 }));
	}

	/*
	 * F(n)=min(cost[n]+F(n-1),cost[n-1]+F(n-2))
	 */
	public int minCostClimbingStairs(int[] cost) {
		int a = 0;
		int b = 0;
		int temp;
		for (int i = 1; i < cost.length; i++) {
			temp = b;
			b = Math.min(b + cost[i], a + cost[i - 1]);
			a = temp;
		}
		return b;
	}
}
