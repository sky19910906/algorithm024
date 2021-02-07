import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_49 {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			int[] table = new int[26];
			for(char single : str.toCharArray()) {
				table[single - 'a'] ++;
			}
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < table.length; i++) {
				if (table[i] > 0) {
					//字母和出现次数加起来作为key
					sb.append((char)(i + 'a'));
					sb.append(table[i]);
				}
			}
			String key = sb.toString();
			List<String> list = map.getOrDefault(key, new ArrayList<String>());
			list.add(str);
			map.put(key, list);
		}
        return new ArrayList<List<String>>(map.values());
    }
}
