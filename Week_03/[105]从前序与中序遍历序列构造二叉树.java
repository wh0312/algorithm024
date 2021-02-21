//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 878 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    int findIndex(int[] inorder, int start, int end, int value) {
        for(int i = start ; i < end; i++)
        {
            if(inorder[i] == value)return i;
        }
        return -1;
    }
    public TreeNode buildTeree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preEnd == preStart)return null;
        if(inStart == inEnd)return null;
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexIninorder = findIndex(inorder, inStart, inEnd, rootValue);
        int subPreStart = preStart + 1;
        int subPreEnd = subPreStart + rootIndexIninorder - inStart;
        int subinEnd = rootIndexIninorder;
        int subinStart = inStart;
        root.left = buildTeree(preorder, inorder, subPreStart, subPreEnd, subinStart, subinEnd);

        subPreStart = subPreEnd;
        subPreEnd = preEnd;
        subinStart = rootIndexIninorder + 1;
        subinEnd = inEnd;
        root.right = buildTeree(preorder, inorder, subPreStart, subPreEnd, subinStart, subinEnd);
        return root;


    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTeree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
