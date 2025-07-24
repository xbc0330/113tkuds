public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 主樹 A
        TreeNode treeA = new TreeNode(3);
        treeA.left = new TreeNode(4);
        treeA.right = new TreeNode(5);
        treeA.left.left = new TreeNode(1);
        treeA.left.right = new TreeNode(2);

        // 樹 B（與 A 相同）
        TreeNode treeB = new TreeNode(3);
        treeB.left = new TreeNode(4);
        treeB.right = new TreeNode(5);
        treeB.left.left = new TreeNode(1);
        treeB.left.right = new TreeNode(2);

        // 樹 C（是 A 的子樹）
        TreeNode treeC = new TreeNode(4);
        treeC.left = new TreeNode(1);
        treeC.right = new TreeNode(2);

        // 樹 D（部分重疊但不完全相同）
        TreeNode treeD = new TreeNode(4);
        treeD.left = new TreeNode(1);

        // 1️⃣ 是否完全相同
        System.out.println("A 和 B 是否完全相同: " + isSameTree(treeA, treeB)); // true
        System.out.println("A 和 C 是否完全相同: " + isSameTree(treeA, treeC)); // false

        // 2️⃣ 是否為子樹
        System.out.println("C 是否為 A 的子樹: " + isSubtree(treeA, treeC)); // true
        System.out.println("D 是否為 A 的子樹: " + isSubtree(treeA, treeD)); // true

        // 3️⃣ 最大公共子樹
        TreeNode common = largestCommonSubtree(treeA, treeC);
        System.out.print("A 和 C 的最大公共子樹中序遍歷: ");
        printInorder(common);
    }

    // 1️⃣ 判斷兩棵樹是否完全相同
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 2️⃣ 判斷是否為子樹
    public static boolean isSubtree(TreeNode main, TreeNode sub) {
        if (main == null) return false;
        if (isSameTree(main, sub)) return true;
        return isSubtree(main.left, sub) || isSubtree(main.right, sub);
    }

    // 3️⃣ 找出最大公共子樹
    static TreeNode largestCommonSubtree(TreeNode a, TreeNode b) {
        Result res = new Result();
        helper(a, b, res);
        return res.node;
    }

    static class Result {
        int size = 0;
        TreeNode node = null;
    }

    static int helper(TreeNode a, TreeNode b, Result res) {
        if (a == null || b == null) return 0;

        if (a.val == b.val) {
            int left = helper(a.left, b.left, res);
            int right = helper(a.right, b.right, res);
            int total = 1 + left + right;
            if (total > res.size) {
                res.size = total;
                res.node = a;
            }
            return total;
        } else {
            helper(a.left, b, res);
            helper(a.right, b, res);
            helper(a, b.left, res);
            helper(a, b.right, res);
            return 0;
        }
    }

    // 工具：中序列印
    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}