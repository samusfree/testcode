public class TestLeetCode {
    public ListNode sortList(ListNode head) {
        ListNode node = head;

        while(node.next!= null) {
            ListNode temp = node;
            if(node.val < node.next.val) {
                node.next.next = node;
            }
        }


        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(0);

        while (node!=null) {
            System.out.println(node.val);
            node = node.next;
        }


    }
}
