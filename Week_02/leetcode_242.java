import java.util.HashMap;
import java.util.Map;

public class leetcode_242 {
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for(char before : s.toCharArray()) {
			table[before - 'a'] ++;
		}
		for(char after : t.toCharArray()) {
			table[after - 'a'] --;
			if (table[after - 'a'] < 0) {
				return false;
			}
		}
		return true;
    }
	
	public boolean isAnagramMap(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char before : s.toCharArray()) {
			map.put(before, map.getOrDefault(before, 0)+1);
		}
		for(char after : t.toCharArray()) {
			map.put(after, map.getOrDefault(after, 0)-1);
			if (map.get(after) < 0) {
				return false;
			}
		}
		return true;
    }
}
