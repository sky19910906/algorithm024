
public class leetcode_190 {
	public int reverseBits(int n) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			//ret左移一位
			ret <<= 1;
			ret |= n & 1;
			//n右移动一位
			n >>= 1;
		}
		return ret;
	}
}
