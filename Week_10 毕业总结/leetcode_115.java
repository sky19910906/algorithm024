
public class leetcode_115 {
	public int numDistinct(String s, String t) {
		int m = t.length();//T
		int n = s.length();//S
		int[][] dp = new int[m+1][n+1];
		//dp[0][j] = 1
		for (int i = 0; i <= n; i++) dp[0][i] = 1;
		for (int i = 1; i <= m; i++) {
			//j<i dp[i][j] = 0
			//dp[i][j] = t[i] == s[j] ? dp[i-1][j-1] + dp[i][j-1] : dp[i][j-1]
			for (int j = i; j <= n; j++) {
				dp[i][j] = t.charAt(i-1) == s.charAt(j-1) ? dp[i-1][j-1] + dp[i][j-1] : dp[i][j-1];
			}
		}
		return dp[m][n];
	}
}
