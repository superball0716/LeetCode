package Array;

/**
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 * @author superball
 * @time 2018年1月19日下午8:30:10
 */
public class Array_485 {

	public static void main(String[] args) {
		Array_485 main = new Array_485();
		System.out.println(main.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
			} else {
				maxCount = Math.max(maxCount, count);
				count = 0;
			}
		}
		return Math.max(maxCount, count);
	}
}
