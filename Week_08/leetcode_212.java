import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class leetcode_212 {

	public List<String> findWords(char[][] board, String[] words) {
		// 将单词保存前缀树 
		TrieNode root = new TrieNode();
	    for (String word : words) {
	      TrieNode node = root;

	      for (Character letter : word.toCharArray()) {
	        if (node.children.containsKey(letter)) {
	          node = node.children.get(letter);
	        } else {
	          TrieNode newNode = new TrieNode();
	          node.children.put(letter, newNode);
	          node = newNode;
	        }
	      }
	      node.word = word;  // store words in Trie
	    }
		// 用于保存结果
		Set<String> result = new HashSet<String>();
		// 遍历board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// 在trie树里面，以该点进行搜索
				if (root.children.containsKey(board[i][j])) {
					dfs(result, board, i, j , root);
				}
			}
		}
		return new ArrayList<String>(result);
	}

	public void dfs(Set<String> result, char[][] board, int i, int j, TrieNode trieNode) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*') {
			return;
		}
		// 如果trie树找到
		TrieNode next = trieNode.children.get(board[i][j]);
		if (next == null) {
			return;
		}
		if (next.word != null) {
			result.add(next.word);
		}
		// 遍历一次后，变更board[i][j]
		char tmp = board[i][j];
		board[i][j] = '*';
		dfs(result, board, i + 1, j, next);
		dfs(result, board, i - 1, j, next);
		dfs(result, board, i, j + 1, next);
		dfs(result, board, i, j - 1, next);
		// 遍历完成后恢复
		board[i][j] = tmp;
		if (next.children.isEmpty()) {
			trieNode.children.remove(tmp);
		}
	}

	class TrieNode {
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		String word = null;

		public TrieNode() {
		}
	}

	public static void main(String[] args) {
		System.out
				.println(
						new leetcode_212()
								.findWords(
										new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
												{ 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } },
										new String[] { "oath", "pea", "eat", "rain" }));
	}

}
