class leetcode_641 {

	int[] circle;
	int first;
	int last;
	int size;
	
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public leetcode_641(int k) {
    	//保持一个空位置
    	size = k + 1;
    	first = 0;
    	last = 0;
    	circle = new int[size];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	if (isFull()) {
			return false;
		}
    	first = (first - 1 + size) % size;
    	circle[first] = value;
    	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if (isFull()) {
			return false;
		}
    	circle[last] = value;
    	last = (last + 1) % size;
    	return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	if (isEmpty()) {
			return false;
		}
    	first = (first+1) % size;
    	return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if (isEmpty()) {
			return false;
		}
    	last = (last - 1 + size) % size;
    	return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if (isEmpty()) {
			return -1;
		}
    	return circle[first];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if (isEmpty()) {
			return -1;
		}
    	return circle[(last -1 + size) % size];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    	return first == last;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
    	return (last + 1) % size == first;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */