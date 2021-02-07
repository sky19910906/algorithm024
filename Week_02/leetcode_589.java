import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_589 {

	
	public List<Integer> preorder(Node root) {
        List<Integer> preorderList = new ArrayList<Integer>();
        preorder(root,preorderList);
        return preorderList;
    }
	
	public void preorder(Node node,List<Integer> preorderList) {
		if (node == null) {
			return;
		}
		//根左右
		preorderList.add(node.val);
		for(Node chNode : node.children) {
			preorder(chNode,preorderList);
		}
	}
	
	public List<Integer> preorderIter(Node root) {
        List<Integer> preorderList = new ArrayList<Integer>();
        if (root == null) {
			return preorderList;
		}
        LinkedList<Node> stack = new LinkedList<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	Node next = stack.pop();
        	preorderList.add(next.val);
        	List<Node> childs = next.children;
        	if (childs != null) {
				for (int i = childs.size()-1; i >=0; i--) {
					stack.push(childs.get(i));
				}
			}
        }
        return preorderList;
    }
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
}
