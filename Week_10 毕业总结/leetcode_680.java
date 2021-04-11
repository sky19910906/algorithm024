
public class leetcode_680 {
	public boolean validPalindrome(String s) {
		
		int len = s.length();
		int i = 0,j = len-1;
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}else {
				//去掉左边 或者 去掉右边字符，有一个是回文 return true
				return validPalindrome(s, i+1, j) || validPalindrome(s, i, j-1);
			}
		}
		return true;
    }
	
	public boolean validPalindrome(String s,int start,int end) {
		while(start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		new leetcode_680().validPalindrome("deeee");
	}
}
