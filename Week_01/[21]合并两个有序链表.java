//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1506 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)return null;
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        
        ListNode head = new ListNode();
        ListNode pCur = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null)
        {
            if(p1.val <= p2.val)
            {
                pCur.next = p1;
                pCur = p1;
                p1 = p1.next;
            } else
            {
                pCur.next = p2;
                pCur = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null)
        {
            pCur.next = p1;
        }

        if(p2 != null)
        {
            pCur.next = p2;
        }
        return head.next;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)
