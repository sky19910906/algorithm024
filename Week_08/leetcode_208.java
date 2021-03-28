
public class leetcode_208 {
	
	class TreeNode {
		
		TreeNode[] next;
		boolean isEnd;
		
		public TreeNode() {
			isEnd = false;
			next = new TreeNode[26];
		}
		
	}
	
	private TreeNode root;
	
	/** Initialize your data structure here. */
    public leetcode_208() {
    	root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TreeNode node = root;
    	for(char wordchar : word.toCharArray()) {
    		if (node.next[wordchar-'a'] == null) {
    			node.next[wordchar-'a'] = new TreeNode();
			}
    		node = node.next[wordchar-'a'];
    	}
    	node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TreeNode node = root;
    	for(char wordchar : word.toCharArray()) {
    		node = node.next[wordchar-'a'];
    		if (node == null) {
    			return false;
    		}
    	}
    	return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TreeNode node = root;
    	for(char wordchar : prefix.toCharArray()) {
    		node = node.next[wordchar-'a'];
    		if (node == null) {
    			return false;
    		}
    	}
    	return true;
    }
    
}
