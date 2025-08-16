package com.ant.question141;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * </P>
 *
 * @author Ant
 * @since 2025/8/15 15:46
 **/
public class Solution {



    public void main(String[] args) {
        Solution solution = new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        // node3.next = null (默认)

        System.out.println(hasCycle(node1));
    }

    /**
     * 哈希表法</br>
     *
     * 每次我们到达一个节点，如果该节点已经存在于哈希表中，则说明该链表是环形链表，
     * 否则就将该节点加入哈希表中。重复这一过程，直到我们遍历完整个链表即可。
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (!nodeSet.add(head.next)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针法</br>
     * 快慢指针法，通过两个指针，一个指针每次移动一步，一个指针每次移动两步。
     * 慢指针每次移动一步，快指针每次移动两步。如果快指针和慢指针相遇，则说明该链表是环形链表。
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    /**
     * 测试用例1：空链表
     * 输入：head = null
     * 期望输出：false
     */
    public void testHasCycleWithNullHead() {
        hasCycle(null);
    }

    /**
     * 测试用例2：单节点无环链表
     * 输入：head = [1], next = null
     * 期望输出：false
     */
    public void testHasCycleWithSingleListNodeNoCycle() {
        ListNode head = new ListNode(1);
        hasCycle(head);
    }
}


class ListNode {
    int val;
    transient ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
   
