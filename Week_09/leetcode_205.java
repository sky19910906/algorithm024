public class leetcode_205 {

	
	public boolean isIsomorphic(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		
		int[] indexOfs = new int[256];
		int[] indexOft = new int[256];
		
		for (int i = 0; i < chars.length; i++) {
			if (indexOfs[chars[i]] != indexOft[chart[i]]) {
				return false;
			}
			indexOfs[chars[i]] = i+1;
			indexOft[chart[i]] = i+1;
		}
		return true;
    }
}
