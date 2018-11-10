package String;

/**
 *
 * @author superball
 * @time 2018年4月10日下午12:27:02
 */
public class Manacher {

	public static void main(String[] args) {
		String s1 = "12212";
		String s2 = "122122";
		String s = "waabwswfd";
		System.out.println(Manacher(s1));
		System.out.println(Manacher(s2));
		System.out.println(Manacher(s));
	}

	public static String Manacher(String s) {
		String t = "$#";
		for (int i = 0; i < s.length(); ++i) {
			t += s.charAt(i);
			t += "#";
		}
		// Process t
		int[] p = new int[t.length()];
		int mx = 0, id = 0, resLen = 0, resCenter = 0;
		for (int i = 1; i < t.length(); ++i) {
			p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
			while (i + p[i] < t.length() && i - p[i] >= 0 && t.charAt(i + p[i]) == t.charAt(i - p[i]))
				++p[i];
			if (mx < i + p[i]) {
				mx = i + p[i];
				id = i;
			}
			if (resLen < p[i]) {
				resLen = p[i];
				resCenter = i;
			}
		}
		return s.substring((resCenter - resLen) / 2, (resCenter + resLen) / 2 - 1);
	}
}
