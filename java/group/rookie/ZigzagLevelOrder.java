package group.rookie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import group.rookie.common.TreeNode;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层序遍历
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 思路：首先需要有个标志位表示从左往右还是从右往左，用双端队列存储每层的节点
 * 从左往右-从队头弹出元素，先遍历左子树，再遍历右子树放入队头
 * 从右往左-从队头弹出元素，先遍历右子树，再遍历左子树放入队头
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> qDeque = new LinkedList<>();
        qDeque.add(root);
        ans.add(Arrays.asList(root.val));

        boolean isLeftToRight = false;
        while (qDeque.size() > 0) {
            int size = qDeque.size();
            List<Integer> levelAns = new LinkedList<>();
            while (size > 0) {
                TreeNode node = qDeque.pop();
                levelAns.add(node.val);
                if (isLeftToRight) {
                    if (node.left != null) qDeque.addFirst(node.left);
                    if (node.right != null) qDeque.addFirst(node.right);
                } else {
                    if (node.right != null) qDeque.addFirst(node.right);
                    if (node.left != null) qDeque.addFirst(node.left);
                }
                size--;
            }
            ans.add(levelAns);
        }
        return ans;
    }
}
