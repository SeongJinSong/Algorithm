package leetcode.lv2;

import java.util.ArrayList;

public class AddTwoNumbers {
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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ArrayList<ListNode> arr = new ArrayList<>();
		int idx = 0;
		while (cur1 != null || cur2 != null) {
			int sum = 0;
			if (cur1 != null) {
				sum += cur1.val;
				cur1 = cur1.next;
			}
			if (cur2 != null) {
				sum += cur2.val;
				cur2 = cur2.next;
			}
			if (arr.size() == idx + 1) {
				sum += arr.get(idx).val;
				arr.get(idx).val = sum % 10;
			} else {
				arr.add(new ListNode(sum % 10));
			}
			if (sum >= 10) {
				arr.add(new ListNode(1));
			}
			idx++;
		}

		for (int i = 0; i < arr.size() - 1; i++) {
			arr.get(i).next = arr.get(i + 1);
		}
		return arr.get(0);
	}
}
