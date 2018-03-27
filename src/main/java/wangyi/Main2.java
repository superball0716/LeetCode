package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author superball
 * @time 2018年3月27日下午8:50:36
 */
public class Main2 {
	public static void main(String[] args) {
		//Main2 main = new Main2();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int D = scanner.nextInt();
			int P = scanner.nextInt();
			map.put(D, P);
		}
		//List<Integer> list = new ArrayList<Integer>(map.keySet());
		for (int i = 0; i < M; i++) {
			int A = scanner.nextInt();
			int p = 0;
			for (int d : map.keySet()) {
				if (A >= d) {
					p = d;
				} else {
					break;
				}
			}
			System.out.println(map.get(p));
			// int index = main.getIndex(A, list, 0, list.size() - 1);
			// System.out.println(map.get(list.get(index)));
		}
	}

	private int getIndex(int i, List<Integer> list, int start, int end) {
		if (i > list.get(end)) {
			return end;
		}
		if (i < list.get(start)) {
			return start;
		}
		if (start >= end) {
			return start;
		}
		int middle = (start + end) / 2;
		if (list.get(middle) > i) {
			return getIndex(i, list, start, middle - 1);
		} else {
			return getIndex(i, list, middle + 1, end);
		}
	}
}
