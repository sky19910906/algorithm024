import java.util.ArrayList;
import java.util.List;

public class leetcode_37 {
	
	//定义每个数字在row col box 出现的次数
	int[][] rowstate = new int[9][9];
	int[][] colstate = new int[9][9];
	int[][] boxstate = new int[9][9];
	//需要填写的数字
	List<int[]> spaces = new ArrayList<int[]>();
	//是否成功
	boolean success = false;
	
	public void solveSudoku(char[][] board) {
		//初始化
		this.init(board);
		//dfs
		this.dfs(board, 0);
    }
	
	private void dfs(char[][] board,int level) {
		if(level == spaces.size()) {
			success = true;
			return;
		} 
		int[] curr = spaces.get(level);
		int i = curr[0], j = curr[1];
		for (int num = 0; num < 9 && !success; num++) {
			int box = (i / 3) * 3 + j / 3;
			//若数字已存在
			if (rowstate[i][num] == 1 || colstate[j][num] == 1 
					|| boxstate[box][num] == 1) {
				continue;
			}
			rowstate[i][num] = 1;
			colstate[j][num] = 1;
			boxstate[box][num] = 1;
			board[i][j] = (char) (num + '0' + 1);
			dfs(board, level+1);
			//回溯
			rowstate[i][num] = 0;
			colstate[j][num] = 0;
			boxstate[box][num] = 0;
		}
	}
	
	private void init(char[][] board) {
		//遍历Board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char numChar = board[i][j];
				if (numChar == '.') {
					spaces.add(new int[]{i,j});
					continue;
				}
				int num = numChar - '1';
				int box = (i / 3) * 3 + j / 3;
				rowstate[i][num] = 1;
				colstate[j][num] = 1;
				boxstate[box][num] = 1;
			}
		}
	}
}
