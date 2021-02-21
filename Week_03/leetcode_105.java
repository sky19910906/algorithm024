public class leetcode_105 {

	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, inorder, (long)Integer.MAX_VALUE+1);
    }
	
	private int pre = 0;
	private int in = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder,long stop) {
		if (pre == preorder.length) {
			return null;
		}
		if (inorder[in] == stop) {
			in++;
			return null;
		}
		TreeNode root = new TreeNode(preorder[pre++]);
		root.left = buildTree(preorder, inorder, root.val);
		root.right = buildTree(preorder, inorder, stop);
		return root;
    }
	
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
