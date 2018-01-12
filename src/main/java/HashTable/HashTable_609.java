package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least two files that have exactly the same content.

A single directory info string in the input list has the following format:

"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

"directory_path/file_name.txt"

Example 1:
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 * @author superball
 * @time 2018年1月12日上午12:28:27
 */
public class HashTable_609 {
	public static void main(String[] args) {
		String[] paths = new String[] { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)" };
		HashTable_609 main = new HashTable_609();
		List<List<String>> res = main.findDuplicate(paths);
		for (List<String> list : res) {
			System.out.println();
			for (String path : list) {
				System.out.print(path + " ");
			}
		}
	}

	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] temp = path.split(" ");
			for (int i = 1; i < temp.length; i++) {
				String[] nameTemp = temp[i].split("\\(");
				String cPath = temp[0] + "/" + nameTemp[0];
				String content = nameTemp[1].replace("\\)", "");
				List<String> pathList = map.getOrDefault(content, new ArrayList<String>());
				pathList.add(cPath);
				map.put(content, pathList);
			}
		}
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			List<String> list = (List<String>) entry.getValue();
			if (list.size() > 1) {
				res.add(list);
			}
		}
		return res;
	}
}
