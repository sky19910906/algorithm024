
public class leetcode_33 {
	
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			//左边单调递增
			if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
				left = mid + 1;
			}else if(target > nums[mid] && target < nums[0]) {
				left = mid + 1;
			}else {
				right = right - 1;
			}
		}
		return nums[left] == target ? left : -1;
    }
	
	
}
