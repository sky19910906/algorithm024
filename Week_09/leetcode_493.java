
public class leetcode_493 {
	
	
	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length-1);
    }
	
	
	//归并排序
	public int mergeSort(int[] nums,int left,int right) {
		if (left >= right) return 0;
		int mid = (left + right) >> 1;
		int count = mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right);
		int[] temp = new int[right - left + 1];
		int i = left,k = 0,c = left;
		for (int j = mid + 1; j <= right; j++) {
			while(c <= mid && nums[c] <= 2 * (long)nums[j]) c++;
			while(i <= mid && nums[i] < nums[j]) temp[k++] = nums[i++];
			temp[k++] = nums[j];
			count += mid + 1 - c;
			// 1,8,9   2,4
			// 1,9,1,2
		}
		while(i <= mid) temp[k++] = nums[i++];
		for (int t = 0; t < temp.length; t++) {
			nums[left+t] = temp[t];
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new leetcode_493().reversePairs(new int[] {9,1,2,1}));;
	}
	
}
