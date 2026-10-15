
import java.util.*;

// Definition of singly linked list
class ListNode {

    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        ListNode temp12 = head;
        for (int i = 0; i < arr.size(); i++) {
            ListNode node = new ListNode(arr.get(i));
            temp12.next = node;
            temp12 = temp12.next;
        }
        return head.next;

    }
}
// Function to print the linked list

public class Main {

    public static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.val + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Linked List: 3 2 5 4 1
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        System.out.print("Original Linked List: ");
        printLinkedList(head);

        Solution solution = new Solution();
        // Sort the linked list
        head = solution.sortList(head);

        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
