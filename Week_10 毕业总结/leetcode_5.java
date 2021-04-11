
public class leetcode_5 {
	
	public String longestPalindrome(String s) {
		//dp[i][j] 表示 s[i:j]是否为回文串
		//dp[i][j] = dp[i-1][j+1] && s[i] == s[j];
		int n = s.length();
		String ret = "";
		boolean[][] dp = new boolean[n][n];
		for (int i = n-1; i >= 0; i++) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 2|| dp[i-1][j+1]);
				if (dp[i][j] && j-i+1 > ret.length()) {
					ret = s.substring(i, j+1);
				}
			}
		}
		return ret;
    }
}
