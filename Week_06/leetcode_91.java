
public class leetcode_91 {
	public int numDecodings(String s) {
		//schar[0] == '0' return 0
		//s[i] == 0,s[i-1]必须为1或者2,dp[i]=dp[i-2],否则无法解码 return 0
		//s[i-1] == 1,dp[i] = dp[i-1] + dp[i-2]
		//s[i-1] == 2,s[i]->{1,6} ,dp[i] = dp[i-1] + dp[i-2]
		//s[i-1]->{3,9} | {0},dp[i]=dp[i-1]
		//11113 333
		char[] schar = s.toCharArray();
		if(schar[0] == '0') return 0;
		int pre = 1,curr = 1;
		for (int i = 1; i < schar.length; i++) {
			int tmp = curr;
			if(schar[i] == '0') {
				if(schar[i-1] != '1' && schar[i-1] != '2') {
					return 0;
				}
				curr = pre;
			}else if(schar[i-1] == '1' || 
					(schar[i-1] == '2' && schar[i] >= '1' && schar[i] <= '6')) {
				curr += pre;
			}
			pre = tmp;
		}
		return curr;
    }
	public static void main(String[] args) {
		new leetcode_91().numDecodings("123123");
	}
}
