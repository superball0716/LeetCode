package Array;

/**
 A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 

Example 1:

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
Example 2:

Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
 * @author superball
 * @time 2018年2月1日下午10:47:14
 */
public class Array_766 {
	public static void main(String[] args) {
		Array_766 main = new Array_766();
		System.out.println(main.isToeplitzMatrix(new int[][] { { 1, 2 }, { 2, 2 } }));
	}

	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; ++r) {
			for (int c = 0; c < matrix[0].length; ++c) {
				if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}
