package DataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author superball
 * @time 2018年3月24日下午9:56:36
 */
public class Itera {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		for (String key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) entries.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
