
import java.util.*;

class ListNode {

    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next1;
    }
}

class Solution {

    public ListNode flattenLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode temp2 = head.child;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp2 = temp.child;
            while (temp2 != null) {
                arr.add(temp2.val);

                temp2 = temp2.child;
            }

            temp = temp.next;

        }
        Collections.sort(arr);
        ListNode temp1 = new ListNode();
        head = temp1;
        for (int i = 0; i < arr.size(); i++) {
            ListNode node = new ListNode(arr.get(i));
            temp1.child = node;
            temp1 = temp1.child;
        }
        return head.child;
    }
}

// Function to print the linked list
class Main {

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;
        }
        System.out.println();
    }

    // Function to print the linked list in a grid-like structure
    public static void printOriginalLinkedList(ListNode head, int depth) {
        while (head != null) {
            System.out.print(head.val);

            /* If child exists, recursively
             print it with indentation */
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // Create a linked list with child pointers
        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        // Print the original linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Creating an instance of Solution class
        Solution sol = new Solution();

        // Function call to flatten the linked list
        ListNode flattened = sol.flattenLinkedList(head);

        // Printing the flattened linked list
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
