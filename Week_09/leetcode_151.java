public class leetcode_151 {

	
	public String reverseWords1(String s) {
		String[] tmp = new String[(s.length() >> 1) + 1];
		StringBuffer sb = new StringBuffer();
		int k = 0;
		for (char schar : s.toCharArray()) {
			if (schar == ' ') {
				if (sb.length() > 0) {
					tmp[k++] = sb.toString();
					sb = new StringBuffer();
				}
			}else {
				sb.append(schar);
			}
		}
		if(sb.capacity() > 0) {
			tmp[k++] = sb.toString();
			sb = new StringBuffer();
		}
		for (int i = tmp.length-1; i >= 0; i--) {
			if (tmp[i] != null) {
				sb.append(tmp[i]);
				sb.append(" ");
			}
		}
		return sb.substring(0, sb.length()-1);
    }
	
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		getReverse(s,sb, 0, true);
		return sb.toString();
	}
	
	private void getReverse(String s,StringBuilder sb,int start,boolean isEnd) {
		while (start < s.length() && s.charAt(start) == ' ') {
			start++;
		}
		if (start == s.length()) {
			return;
		}
		int end = start;
		while (end < s.length() && s.charAt(end) != ' ') {
			end++;
		}
		getReverse(s, sb, end, false);
		sb.append(s.substring(start, end));
		if (!isEnd) {
			sb.append(' ');
		}
	}
	
	public static void main(String[] args) {
		new leetcode_151().reverseWords("  hello world  ");
	}
}
