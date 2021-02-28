import java.util.Arrays;

public class leetcode_455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int j = 0;
		for (int i = 0; i < g.length && j < s.length; i++,j++) {
			while (j < s.length && s[j] < g[i]) {
				j ++;
			}
			if (j < s.length) {
				count ++;
			}
		}
		return count;
    }
	
	public int findContentChildren1(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0,j = 0;
		while (i < g.length && j < s.length) {
			if (s[j] >= g[i]) {
				i++;
			}
			j++;
		}
		return i;
    }
}
