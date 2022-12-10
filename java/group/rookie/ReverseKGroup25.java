package group.rookie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import group.rookie.common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 25. K个一组翻转链表
 * 节点数目为n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 思路：双指针判断K个节点->翻转链表
 * 小于K不进行翻转
 * 
 * 1. 遍历计数 以K分组；不足K时直接返回
 * 2. 翻转
 * 3. 拼接到原链表
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //遍历
        while (head != null) {
            //以K分组，不足K个是直接返回
            ListNode tail = pre;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            //翻转
            List<ListNode> reverseNodes = reverse(head, tail);
            head = reverseNodes.get(0);
            tail = reverseNodes.get(1);
            //pre指向翻转后的head；翻转后的tail指向原tail.next
            //随后pre指向tail（即head的pre，与33行保持一致），head指向下一组的起点
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    /**
     * head -> A -> B -> C -> tail
     * tail -> c -> B -> A -> head
     * 相当于以tail.next为起点开始，从head遍历进行前插即可
     * @param head
     * @param tail
     * @return
     */
    private List<ListNode> reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return Arrays.asList(tail, head);
    }
}