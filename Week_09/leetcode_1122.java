
public class leetcode_1122 {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		//先计数
		int[] count = new int[1001];
		for (int i = 0; i < arr1.length; i++) {
			count[arr1[i]]++;
		}
		int k = 0;
		for (int i = 0; i < arr2.length; i++) {
			while(count[arr2[i]] > 0) {
				arr1[k++] = arr2[i];
				count[arr2[i]]--;
			}
		}
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				arr1[k++] = i;
				count[i]--;
			}
		}
		return arr1;
    }
	
}
