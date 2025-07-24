import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 測試資料
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // 1️⃣ 根據前序 + 中序建立
        TreeNode rootFromPreIn = buildTreeFromPreIn(preorder, inorder);
        System.out.println("前序 + 中序重建：");
        System.out.print("中序遍歷: ");
        printInorder(rootFromPreIn);
        System.out.print("\n前序遍歷: ");
        printPreorder(rootFromPreIn);
        System.out.print("\n後序遍歷: ");
        printPostorder(rootFromPreIn);
        System.out.println("\n");

        // 2️⃣ 根據後序 + 中序建立
        TreeNode rootFromPostIn = buildTreeFromPostIn(postorder, inorder);
        System.out.println("後序 + 中序重建：");
        System.out.print("中序遍歷: ");
        printInorder(rootFromPostIn);
        System.out.print("\n前序遍歷: ");
        printPreorder(rootFromPostIn);
        System.out.print("\n後序遍歷: ");
        printPostorder(rootFromPostIn);
    }

    // 1️⃣ 根據前序 + 中序建立
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize, in, inStart, rootIndex - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd, in, rootIndex + 1, inEnd, inMap);

        return root;
    }

    // 2️⃣ 根據後序 + 中序建立
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inMap.get(rootVal);
        int leftSize = rootIndex - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1, in, inStart, rootIndex - 1, inMap);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1, in, rootIndex + 1, inEnd, inMap);

        return root;
    }

    // 建立中序值 → 索引的映射，加速查找
    private static Map<Integer, Integer> buildIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    // 驗證用：前中後序印法
    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void printPostorder(TreeNode node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }
}