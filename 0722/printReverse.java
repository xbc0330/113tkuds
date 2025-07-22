class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class  printReverse {

    public static void printReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Reverse print: ");
        printReverse(head); // Expected output: 5 4 3 2 1
    }
}