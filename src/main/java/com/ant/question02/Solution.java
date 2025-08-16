package com.ant.question02;

/**
 * <p>
 * 第二题
 *
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * </p>
 *
 * @author Ant
 * @since 2022/4/28 12:02 上午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(2, node11);
        ListNode node13 = new ListNode(1, node12);

        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(2, node21);
        ListNode node23 = new ListNode(1, node22);

        System.out.println(solution.addTwoNumbers(node13, node23));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0; // 进位

        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        // 如果还有余数，则新增一个节点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

}

class ListNode {
    int val;
    transient ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
               "val=" + val +
               ", next=" + next +
               '}';
    }
}
