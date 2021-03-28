
public class leetcode_200_unionfind {
	
	class UnionFind{
		
		private int count = 0;
		private int[] parent;
		private int[] rank;
		
		public UnionFind(char[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			parent = new int[m*n];
			rank = new int[m*n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '1') {
						parent[i*n+j] = i*n+j;
						count++;
					}
				}
			}
		
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
		}
		
		public int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}
		
		public int getCount() {
			return this.count;
		}
		
		
		public void union(int p ,int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if(rootP == rootQ) return;
			if (rank[rootP] < rank[rootQ]) {
				parent[rootP] = rootQ;
			}else {
				parent[rootQ] = rootP;
				if (rank[rootP] == rank[rootQ]) {
					rank[rootP]++;
				}
			}
			count --;
		}
	}
	
	public int numIslands(char[][] grid) {
		UnionFind unionFind = new UnionFind(grid);
		int[] rowOffset = {-1, 0, 1, 0};
	    int[] colOffset = {0, 1, 0, -1};
	    int rows = grid.length;
	    int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(grid[i][j] == '1') {
					grid[i][j] = '0';
					for (int k = 0; k < 4; k++) {
						int newRow = i + rowOffset[k];
					    int newCol = j + colOffset[k];
					    if (newRow >= 0 && newRow < rows && newCol >= 0 
					    		&& newCol < cols && grid[newRow][newCol] == '1') {
					    	unionFind.union(i*cols + j, newRow*cols + newCol);
						}
					}
				}
			}
		}
		return unionFind.getCount();
	}
}
