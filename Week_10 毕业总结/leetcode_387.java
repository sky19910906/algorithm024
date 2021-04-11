
public class leetcode_387 {

	
	public int firstUniqChar(String s) {
		int result = s.length();
		for (char i = 'a'; i <= 'z'; i++) {
			int search = i;
			int firstInd = s.indexOf(search);
			if (firstInd != -1 && s.lastIndexOf(search) == firstInd && result > firstInd) {
				result = firstInd;
			}
		}
		return result == s.length() ? -1 : result;
	}
	
	public static void main(String[] args) {
		System.out.println("aaaa".indexOf('a'));
	}
}
