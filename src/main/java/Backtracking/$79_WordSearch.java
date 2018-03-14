package Backtracking;

import java.util.List;

/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * @author superball
 * @time 2018年3月14日下午4:43:01
 */
public class $79_WordSearch {

	public static void main(String[] args) {
		$79_WordSearch main = new $79_WordSearch();
		System.out.println(main.exist(
				new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "ABCCED"));
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (helper(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean helper(char[][] board, String word, int x, int y, int index) {
		if (index == word.length()) {
			return true;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
			return false;
		}
		if (word.charAt(index) != board[x][y]) {
			return false;
		} else {
			board[x][y] -= 'A' * 2;
			boolean existed = helper(board, word, x + 1, y, index + 1) || helper(board, word, x - 1, y, index + 1)
					|| helper(board, word, x, y + 1, index + 1) || helper(board, word, x, y - 1, index + 1);
			board[x][y] += 'A' * 2;
			return existed;
		}
	}
}
