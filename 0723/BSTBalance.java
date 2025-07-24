public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BalanceInfo {
        int maxImbalance = -1;
        TreeNode mostUnbalancedNode = null;
    }

    public static void main(String[] args) {
        /*
            測試用 BST（不平衡）：
                    10
                   / 
                  5
                 / 
                3
               /
              1
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);

        // 1️⃣ 是否為平衡樹
        System.out.println("是否為平衡樹: " + isBalanced(root));

        // 2️⃣ 印出所有節點平衡因子
        System.out.println("\n各節點平衡因子:");
        printBalanceFactors(root);

        // 3️⃣ 找出最不平衡的節點
        TreeNode mostUnbalanced = findMostUnbalancedNode(root);
        System.out.println("\n最不平衡的節點: " +
            (mostUnbalanced != null ? mostUnbalanced.val : "無"));
    }

    // 1️⃣ 檢查是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    // 2️⃣ 計算並印出每個節點的平衡因子
    public static int printBalanceFactors(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = printBalanceFactors(node.left);
        int rightHeight = printBalanceFactors(node.right);

        int balance = leftHeight - rightHeight;
        System.out.println("節點 " + node.val + " 平衡因子: " + balance);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 3️⃣ 找出平衡因子絕對值最大的節點（最不平衡節點）
    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        BalanceInfo info = new BalanceInfo();
        computeBalance(root, info);
        return info.mostUnbalancedNode;
    }

    private static int computeBalance(TreeNode node, BalanceInfo info) {
        if (node == null) return 0;

        int left = computeBalance(node.left, info);
        int right = computeBalance(node.right, info);

        int balance = left - right;
        int absBalance = Math.abs(balance);

        if (absBalance > info.maxImbalance) {
            info.maxImbalance = absBalance;
            info.mostUnbalancedNode = node;
        }

        return Math.max(left, right) + 1;
    }
}