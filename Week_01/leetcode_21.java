class leetcode_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode prehead = new ListNode(-1);
		ListNode tmp = prehead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;

				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		tmp.next = l1 == null ? l2 : l1;
		return prehead.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}