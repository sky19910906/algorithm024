
public class leetcode_300_贪心 {

	public int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int res = 0;
		for (int num : nums) {
			int i = 0,j = res;
			while (i < j) {
				int mid = (i + j) >> 1;
				if (tails[mid] < num) {
					i = mid + 1;
				}else {
					j = mid;
				}
			}
			tails[i] = num;
			if (res == j) {
				res ++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		new leetcode_300_贪心().lengthOfLIS(new int[] {4,10,4,3,8,9});
	}
}
