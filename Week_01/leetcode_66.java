class leetcode_66 {
    public int[] plusOne(int[] digits) {
        //加1为0进位，最后一位也是0，扩充数组
		for (int i = digits.length-1; i >= 0; i--) {
			digits[i] ++;
			digits[i] %= 10;
			if (digits[i] > 0) {
				return digits;
			}
		}
		digits = new int[digits.length+1];
		digits[0] = 1;
		return digits;
    }
}