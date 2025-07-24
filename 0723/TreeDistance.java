import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        /*
             測試用樹：
                     1
                    / \
                   2   3
                  / \   \
                 4   5   6
                      \
                       7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        // 1️⃣ 任意兩節點距離（例：4 與 7）
        int dist = getDistance(root, 4, 7);
        System.out.println("節點 4 與 7 的距離為: " + dist);

        // 2️⃣ 樹的直徑
        int diameter = getDiameter(root);
        System.out.println("樹的直徑為: " + diameter);

        // 3️⃣ 找出距離根節點距離為 K 的所有節點（例：距離為 2）
        int K = 2;
        List<Integer> nodesAtK = nodesAtDistanceK(root, K);
        System.out.println("距離根節點為 " + K + " 的節點: " + nodesAtK);
    }

    // -----------------------------
    // 1️⃣ 任意兩節點間的距離
    // -----------------------------
    public static int getDistance(TreeNode root, int val1, int val2) {
        TreeNode lca = findLCA(root, val1, val2);
        int d1 = getDepth(lca, val1, 0);
        int d2 = getDepth(lca, val2, 0);
        return d1 + d2;
    }

    private static TreeNode findLCA(TreeNode node, int a, int b) {
        if (node == null) return null;
        if (node.val == a || node.val == b) return node;

        TreeNode left = findLCA(node.left, a, b);
        TreeNode right = findLCA(node.right, a, b);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    private static int getDepth(TreeNode node, int target, int depth) {
        if (node == null) return -1;
        if (node.val == target) return depth;

        int left = getDepth(node.left, target, depth + 1);
        if (left != -1) return left;

        return getDepth(node.right, target, depth + 1);
    }

    // -----------------------------
    // 2️⃣ 樹的直徑（最大距離）
    // -----------------------------
    static int maxDiameter = 0;

    public static int getDiameter(TreeNode root) {
        maxDiameter = 0;
        depthForDiameter(root);
        return maxDiameter;
    }

    private static int depthForDiameter(TreeNode node) {
        if (node == null) return 0;
        int left = depthForDiameter(node.left);
        int right = depthForDiameter(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    // -----------------------------
    // 3️⃣ 找出距離根節點為 K 的所有節點
    // -----------------------------
    public static List<Integer> nodesAtDistanceK(TreeNode root, int K) {
        List<Integer> result = new ArrayList<>();
        findNodesAtDistance(root, K, 0, result);
        return result;
    }

    private static void findNodesAtDistance(TreeNode node, int K, int depth, List<Integer> result) {
        if (node == null) return;
        if (depth == K) {
            result.add(node.val);
        } else {
            findNodesAtDistance(node.left, K, depth + 1, result);
            findNodesAtDistance(node.right, K, depth + 1, result);
        }
    }
}