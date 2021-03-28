
public class leetcode_200 {
	public int numIslands(char[][] grid) {
		int count = 0;
		//遍历二维数组
		//遇到1，岛屿数量+1
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					dfsMark(i, j, grid);
				}
			}
		}
		return count;
	}
	// 111
	// 010
	// 111
	public void dfsMark(int i,int j,char[][] grid) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';
		dfsMark(i+1, j, grid);
		dfsMark(i-1, j, grid);
		dfsMark(i, j+1, grid);
		dfsMark(i, j-1, grid);
	}
}
