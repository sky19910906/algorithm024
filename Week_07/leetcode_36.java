
public class leetcode_36 {

	public boolean isValidSudoku(char[][] board) {
		//9 * 9的棋盘
		//每个小棋盘的表示方式为 (row / 3) * 3 + col / 3
		//定义每个数字在row col box 出现的次数
		int[][] rowstate = new int[9][9];
		int[][] colstate = new int[9][9];
		int[][] boxstate = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char numChar = board[i][j];
				if (numChar == '.') continue;
				int num = numChar - '1';
				int box = (i / 3) * 3 + j / 3;
				if (rowstate[i][num] == 1 || colstate[j][num] == 1 
						|| boxstate[box][num] == 1) {
					return false;
				}
				rowstate[i][num] = 1;
				colstate[j][num] = 1;
				boxstate[box][num] = 1;
			}
		}
		return true;
    }
}
