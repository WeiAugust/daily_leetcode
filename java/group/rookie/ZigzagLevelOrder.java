package group.rookie;

import java.util.ArrayDeque;
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
 * 从左往右-从队头弹出元素，放入level队列尾部
 * 从右往左-从队头弹出元素，放入level队列首部
 * 将节点左子节点放入global队列尾部，将节点右子节点放入global队列尾部
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> qDeque = new ArrayDeque<>();
        qDeque.offer(root);

        boolean isLeftToRight = true;
        while (!qDeque.isEmpty()) {
            int size = qDeque.size();
            Deque<Integer> levelAns = new LinkedList<>();
            while (size > 0) {
                TreeNode node = qDeque.poll();
                if (isLeftToRight) {
                    levelAns.offerLast(node.val);
                } else {
                    levelAns.offerFirst(node.val);
                }
                if (node.left != null) qDeque.addLast(node.left);
                if (node.right != null) qDeque.addLast(node.right);
                size--;
            }
            isLeftToRight = !isLeftToRight;
            ans.add(new LinkedList<>(levelAns));
        }
        return ans;
    }
}
