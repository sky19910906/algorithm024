
public class leetcode_55 {
	
	public boolean canJump(int[] nums) {
		int target = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] + i >= target) {
				target = i;
			}
		}
		return target == 0;
    }
}
