package com.algo.por.recurrence;

import com.algo.common.entity.ListNode;

public class ReverseLinkedList {
    /**
     * # 마지막부터 처음으로 잡으면 되는데
     * # 이전 노드의 값 = 다음 노드의 값(변환)
     * 1node
     * 2node = 1node.next
     * 3node = 2node.next = 1node.next.next
     * 4node = 3node.next = 2node.next.next = 1node.next.next.next
     *
     * 4node
     * 4node.next = 3node
     * 4node.next.next = 3node.next = 2node
     * 4node.next.next.next = 3node.next.next = 2node.next = 1node
     *
     * # 최초 상태
     * ListNode{val=1, next=ListNode{val=2, next=ListNode{val=3, next=ListNode{val=4, next=null}}}}
     * # 최종 결과
     * ListNode{val=4, next=ListNode{val=3, next=ListNode{val=2, next=ListNode{val=1, next=null}}}}
     */
    private int counter = 0;
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        /**
         * 굳이 이렇게 할 필요 없이, 시작을 null부터 하면 isFirst 체크할 필요 없다
         * return reverseListHelper(head, head.next, true);
         */
        return reverseListHelper(null, head);
    }

    /**
     * 초기값을 주어진 값이 아닌 null이나 0부터 시작하는 것도 고려하자
     * (1, 2, 0)
     * 2 -> 1 -> null
     * (2, 3, 1)
     * 3 -> 2 -> 1 -> null
     * (3, 4, 2)
     * 4 -> 3 -> 2 -> 1 -> null
     * (4, null, 3)
     *
     */
    public ListNode reverseListHelper(ListNode initial, ListNode next) {
        if (next == null) {
            return initial;
        }
        /**
         * ListNode tmp = next;
         * next.next = initial; 이렇게 하면 위의 tmp도 값이 변경된다. 참조로 엮여 있다
         */
        /**
         * # 1->null, 2->(1->null), 3->(2->(1->null)) ... 이렇게 밖으로 계속 감싸게 만들어준다
         * # initial 노드가 안으로 파고들 수 있도록 만들어야 한다
         * 1. 다음 값으로 새로운 노드 생성
         * 2. 새로운 노드의 다음 값을 초기 값으로 설정
         * 3. 새로운 노드를 초기값으로, 다다음 값을 다음 값으로 재귀
         */
        ListNode newNode = new ListNode(next.val);
        newNode.next = initial;

        return reverseListHelper(newNode, next.next);
    }


    public static void test() {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        System.out.println("1. " + first);
        first = rll.reverseList(first);
        System.out.println("2. " + first);
    }
}
