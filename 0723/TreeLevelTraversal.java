import java.util.*;

public class TreeLevelTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 建立一棵範例二元樹：
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 印出樹狀圖（右在上，左在下）
        System.out.println("樹狀圖：");
        printTree(root, 0);

        // 執行 zigzag 層序遍歷
        List<List<Integer>> result = zigzagLevelOrder(root);

        // 只印每層的最後一個節點
        System.out.println("\n每層的最後一個節點：");
        for (List<Integer> level : result) {
            System.out.println(level.get(level.size() - 1));
        }
    }

    // Zigzag 層序遍歷：回傳每層 List
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (leftToRight) {
                    levelList.addLast(curr.val);
                } else {
                    levelList.addFirst(curr.val);
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            levels.add(levelList);
            leftToRight = !leftToRight;
        }

        return levels;
    }

    // 顯示樹的視覺結構（右 → 中 → 左）
    public static void printTree(TreeNode node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);

        printTree(node.left, level + 1);
    }
}