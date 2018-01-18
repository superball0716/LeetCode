package String;

/**
Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

Example:
Input: [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation:
1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 

Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2
 * @author superball
 * @time 2018年1月18日下午3:22:44
 */
public class String_553 {
	public static void main(String[] args) {
		String_553 main = new String_553();
		System.out.println(main.optimalDivision(new int[] { 1000, 100, 10, 2 }));
	}

	public String optimalDivision(int[] nums) {
		if (nums.length == 1) {
			return String.valueOf(nums[0]);
		}
		if (nums.length == 2) {
			return nums[0] + "/" + nums[1];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(nums[0] + "/(");
		for (int i = 1; i < nums.length - 1; i++) {
			sb.append(nums[i] + "/");
		}
		sb.append(nums[nums.length - 1] + ")");
		return sb.toString();
	}
}
