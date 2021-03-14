
public class leetcode_64 {

	public int minPathSum(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				if (i == 0) {
					grid[i][j] = grid[i][j - 1] + grid[i][j];
					continue;
				}
				if (j == 0) {
					grid[i][j] = grid[i - 1][j] + grid[i][j];
					continue;
				}
				grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
			}
		}
		return grid[grid.length - 1][grid[0].length - 1];
	}
}
