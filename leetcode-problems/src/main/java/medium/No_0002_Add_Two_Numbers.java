package medium;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 * <p>
 * 循环遍历l1和l2两个链表的每一位, 用一个boolean carry表示当前位计算结果是否大于9需要进位,
 * 则结果链表中的第n位的值为: l1[n].val + l2[n].val + (carry ? 1 : 0)
 * 循环在l1与l2都遍历完并且carry == false时结束.
 */
public class No_0002_Add_Two_Numbers {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        // 好输出一些
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);

            ListNode next = this.next;
            while (next != null) {
                sb.append(" -> ").append(next.val);
                next = next.next;
            }

            return sb.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null; // the head of result linked list

        // If one is null, return the other one
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        boolean carry = false;  // carry flag
        ListNode resultTail = null; // the tail of result linked list

        while (l1 != null || l2 != null || carry) {
            int currentPosSum = 0;  // the sum value of current position
            if (l1 != null) {
                currentPosSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentPosSum += l2.val;
                l2 = l2.next;
            }

            if (carry) {
                currentPosSum++;
            }

            carry = currentPosSum > 9;  // set the carry flag for next position.

            if (resultHead == null) {   // It is the 1st position now.
                resultHead = new ListNode(currentPosSum % 10);
                resultTail = resultHead;
            } else {
                resultTail.next = new ListNode(currentPosSum % 10);
                resultTail = resultTail.next;
            }

        }

        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);

        ListNode result = new No_0002_Add_Two_Numbers().addTwoNumbers(l1, l2);

        System.out.println(result);

    }
}
