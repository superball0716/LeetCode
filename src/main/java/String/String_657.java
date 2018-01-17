package String;

/**
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
 * @author superball
 * @time 2018年1月18日上午1:03:03
 */
public class String_657 {
	public static void main(String[] args) {
		String_657 main = new String_657();
		System.out.println(main.judgeCircle("UD"));
	}

	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (char move : moves.toCharArray()) {
			if (move == 'U')
				y++;
			else if (move == 'D')
				y--;
			else if (move == 'L')
				x--;
			else if (move == 'R')
				x++;
		}
		return x == 0 && y == 0;
	}
}
