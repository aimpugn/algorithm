package com.leetcode.por.swapnodes;

import com.leetcode.common.entity.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        /**
         * 1. 새로운 노드를 가장 앞에 추가한다
         * 2. 새로운 노드 = 현재 노드의 다음 노드
         * 3. 현재 노드의 다음 노드 = 새로운 노드 기준으로 다다음 노드
         * 4. 새로운 노드 다음 노드 = 현재 노드
         */
        ListNode swapHead = head.next;
        head.next = swapPairs(head.next.next);
        swapHead.next = head;

        return swapHead;
    }

    public static void test(String[] args) {
        Solution s = new Solution();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first = s.swapPairs(first);
        System.out.println(first);
    }
}
