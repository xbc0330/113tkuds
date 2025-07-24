
public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 原始 BST 範例：
        //         5
        //       /   \
        //      3     7
        //     / \   / \
        //    2  4  6   8

        TreeNode originalBST = new TreeNode(5);
        originalBST.left = new TreeNode(3);
        originalBST.right = new TreeNode(7);
        originalBST.left.left = new TreeNode(2);
        originalBST.left.right = new TreeNode(4);
        originalBST.right.left = new TreeNode(6);
        originalBST.right.right = new TreeNode(8);

        // ✅ 1. BST → 雙向鏈表
        TreeNode bstForDLL = cloneTree(originalBST);
        TreeNode dllHead = convertBSTToDoublyLinkedList(bstForDLL);
        System.out.println("BST 轉為排序的雙向鏈表:");
        printDoublyLinkedList(dllHead);

        // ✅ 2. 排序陣列 → 平衡 BST
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode balancedBST = sortedArrayToBST(sortedArray);
        System.out.println("\n由排序陣列建構平衡 BST 的中序遍歷:");
        printInorder(balancedBST);

        // ✅ 3. BST 轉為 Greater Tree
        TreeNode bstForGreater = cloneTree(originalBST);
        convertToGreaterTree(bstForGreater);
        System.out.println("\n\n轉換後的 Greater Tree 中序遍歷:");
        printInorder(bstForGreater);
    }

    // 🔁 複製整棵樹，避免重複使用
    public static TreeNode cloneTree(TreeNode node) {
        if (node == null) return null;
        TreeNode newNode = new TreeNode(node.val);
        newNode.left = cloneTree(node.left);
        newNode.right = cloneTree(node.right);
        return newNode;
    }

    // -------------------------------
    // ✅ 1. BST → 雙向鏈表（中序遞增）
    // -------------------------------
    static TreeNode prev = null;
    static TreeNode head = null;

    public static TreeNode convertBSTToDoublyLinkedList(TreeNode root) {
        prev = null;
        head = null;
        convertToDLL(root);
        return head;
    }

    private static void convertToDLL(TreeNode node) {
        if (node == null) return;

        convertToDLL(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        convertToDLL(node.right);
    }

    public static void printDoublyLinkedList(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.right != null) System.out.print(" <-> ");
            curr = curr.right;
        }
        System.out.println();
    }

    // ----------------------------------------
    // ✅ 2. 排序陣列 → 平衡 BST
    // ----------------------------------------
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] arr, int left, int right) {
        if (left > right) return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBalancedBST(arr, left, mid - 1);
        root.right = buildBalancedBST(arr, mid + 1, right);
        return root;
    }

    // ----------------------------------------
    // ✅ 3. BST 轉為 Greater Tree（累加大值）
    // ----------------------------------------
    static int sum = 0;

    public static void convertToGreaterTree(TreeNode root) {
        sum = 0;
        reverseInorder(root);
    }

    private static void reverseInorder(TreeNode node) {
        if (node == null) return;

        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }

    // ----------------------------------------
    // 工具：中序列印
    // ----------------------------------------
    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}