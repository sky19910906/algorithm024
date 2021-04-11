
public class leetcode_541 {
	
	public String reverseStr(String s, int k) {
		
		char[] sarr = s.toCharArray();
		for (int start = 0; start < sarr.length-1; start+=2*k) {
			int i = start,j = Math.min(start+k-1, sarr.length-1);
			while (i < j) {
				char tmp = sarr[i];
				sarr[i++] = sarr[j];
				sarr[j--] = tmp;
			}
		}
		return new String(sarr);
    }
	
	public static void main(String[] args) {
		new leetcode_541().reverseStr("abcdef", 3);
	}
}
