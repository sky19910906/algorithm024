import java.util.HashMap;

/**
 * leetcode_146
 * @author sky
 *
 */
public class leetcode_146_LRUCache {
	
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode next;
	}
	
	private DLinkedNode head,tail;
	private int count,capacity;
	private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	
	private void addNode(DLinkedNode node) {
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}
	
	private void removeNode(DLinkedNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
		node.pre = null;
		node.next = null;
	}
	
	private void moveTohead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}
	
	private DLinkedNode popTail() {
		DLinkedNode currtail = tail.pre;
		this.removeNode(currtail);
		return currtail;
	}
	
	public leetcode_146_LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.head = new DLinkedNode();
		this.tail = new DLinkedNode();
		head.next = tail;
		tail.pre = head;
    }
    
    public int get(int key) {
    	DLinkedNode node = cache.get(key);
    	if (node == null) {
			return -1;
		}
    	this.moveTohead(node);
    	return node.value;
    }
    
    public void put(int key, int value) {
    	DLinkedNode node = cache.get(key);
    	if (node == null) {
    		DLinkedNode newNode = new DLinkedNode();
    		newNode.key = key;
    		newNode.value = value;
			this.addNode(newNode);
			cache.put(key, newNode);
			count++;
			//容量超出
			if (count > capacity) {
				DLinkedNode poptail = this.popTail();
				cache.remove(poptail.key);
				count--;
			}
		}else {
			node.value = value;
			this.moveTohead(node);
		}
    }
}
