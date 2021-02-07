import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_94 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(result, root);
		return result;
    }
	
	public void inorderTraversal(List<Integer> result,TreeNode node) {
		if (node == null) {
			return;
		}
		//左根右
		inorderTraversal(result,node.left);
		result.add(node.val);
		inorderTraversal(result,node.right);
    }
	
	public List<Integer> inorderTraversalIter(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}
		return result;
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
