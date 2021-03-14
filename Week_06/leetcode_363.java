
public class leetcode_363 {
	
	public static void main(String[] args) {
//		System.out.println(new leetcode_363().maxSumSubmatrix(new int[][] {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8));;
		System.out.println(new leetcode_363().maxSumSubmatrix(new int[][] {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}}, 8));;
	}
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
		//固定左右边界 
		//求每行的和
		//任意矩形区域都是每行和数组中连续元素相加
		int row = matrix.length;
		int col = matrix[0].length;
		int result = Integer.MIN_VALUE;
		for (int left = 0; left < col; left++) {
			//左边界发生改变时重置数组
			int[] rowsum = new int[row];
			for (int right = left; right < col; right++) {
				for (int i = 0; i < row; i++) {
					rowsum[i] += matrix[i][right];
				}
				result = Math.max(result, dpmax(rowsum, k));
		        if (result == k) return k; // 尽量提前
			}
		}
		return result;
    }
	// 在数组 arr 中，求不超过 k 的最大值
	private int dpmax(int[] arr, int k) {
		int result = Integer.MIN_VALUE;
		int sumMax = 0;
		for (int i = 0; i < arr.length; i++) {
			sumMax += arr[i];
			result = Math.max(result, sumMax);
			if (sumMax < 0) {
				sumMax = 0;
			}
		}
	    if (result <= k) return result;
	    // O(rows ^ 2)
	    int max = Integer.MIN_VALUE;
	    for (int l = 0; l < arr.length; l++) {
	        int sum = 0;
	        for (int r = l; r < arr.length; r++) {
	            sum += arr[r];
	            if (sum > max && sum <= k) max = sum;
	            if (max == k) return k; // 尽量提前
	        }
	    }
	    return max;
	}
}
