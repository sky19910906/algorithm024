import java.util.HashMap;
import java.util.Map;

class leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (map.get(target - nums[i]) != null) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
			}
    		map.put(nums[i], i);
		}
        return result;
    }
}