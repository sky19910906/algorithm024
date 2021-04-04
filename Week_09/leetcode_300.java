
public class leetcode_300 {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		int res = 1;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			res = Math.max(res, dp[i]);
		}
		return res;

    }
	
	public static void main(String[] args) {
		new leetcode_300().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
	}
}
