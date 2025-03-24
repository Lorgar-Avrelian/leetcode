package lorgar.avrelian;

public class Task0002 {
    static boolean overflow = false;

    public static void main(String[] args) {
        ListNode l1 = new ListNode(
                2,
                new ListNode(4,
                        new ListNode(9))
        );
        ListNode l2 = new ListNode(
                5,
                new ListNode(6,
                        new ListNode(4,
                                new ListNode(9))));
        ListNode result = addTwoNumbers(l1, l2);
        printResult(result);
    }

    private static void printResult(ListNode result) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(result.val);
        ListNode node = result.next;
        while (node != null) {
            sb.append(", ");
            sb.append(node.val);
            node = node.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            int l1Val = l1.val;
            int l2Val = l2.val;
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            int sum = 0;
            if (overflow) {
                sum = l1Val + l2Val + 1;
                overflow = false;
            } else {
                sum = l1Val + l2Val;
            }
            if (sum > 9) {
                overflow = true;
                sum = sum % 10;
            }
            if (l1Next != null || l2Next != null) {
                return new ListNode(sum, addTwoNumbers(l1Next, l2Next));
            } else {
                if (overflow) {
                    overflow = false;
                    return new ListNode(sum, new ListNode(1));
                } else {
                    return new ListNode(sum);
                }
            }
        } else if (l2 == null && l1 != null) {
            int l1Val = l1.val;
            ListNode l1Next = l1.next;
            int sum = 0;
            if (overflow) {
                sum = l1Val + 1;
                overflow = false;
            } else {
                sum = l1Val;
            }
            if (sum > 9) {
                overflow = true;
                sum = sum % 10;
            }
            if (l1Next != null) {
                return new ListNode(sum, addTwoNumbers(l1Next, null));
            } else {
                if (overflow) {
                    overflow = false;
                    return new ListNode(sum, new ListNode(1));
                } else {
                    return new ListNode(sum);
                }
            }
        } else if (l1 == null && l2 != null) {
            int l2Val = l2.val;
            ListNode l2Next = l2.next;
            int sum = 0;
            if (overflow) {
                sum = l2Val + 1;
                overflow = false;
            } else {
                sum = l2Val;
            }
            if (sum > 9) {
                overflow = true;
                sum = sum % 10;
            }
            if (l2Next != null) {
                return new ListNode(sum, addTwoNumbers(null, l2Next));
            } else {
                if (overflow) {
                    overflow = false;
                    return new ListNode(sum, new ListNode(1));
                } else {
                    return new ListNode(sum);
                }
            }
        } else {
            if (overflow) {
                overflow = false;
                return new ListNode(1);
            }
            return null;
        }
    }
}