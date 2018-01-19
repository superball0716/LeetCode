package Array;

/**
In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * @author superball
 * @time 2018年1月19日下午8:06:47
 */
public class Array_566 {
	public static void main(String[] args) {
		Array_566 main = new Array_566();
		int[][] res = main.matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4);
		for (int i = 0; i < res.length; i++) {
			System.out.println();
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
		}
	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int or = nums.length;
		int oc = nums[0].length;
		if (or * oc != r * c) {
			return nums;
		}
		int[][] matrix = new int[r][c];
		int cr = 0;
		int cc = 0;
		for (int i = 0; i < or; i++) {
			for (int j = 0; j < oc; j++) {
				matrix[cr][cc] = nums[i][j];
				if (cc != c - 1) {
					cc++;
				} else {
					cc = 0;
					cr++;
				}
			}
		}
		return matrix;
	}
}
