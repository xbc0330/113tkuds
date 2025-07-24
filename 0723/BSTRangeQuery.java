import java.util.ArrayList;

public class BSTRangeQuery {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // BST範圍查詢方法
    public static ArrayList<Integer> rangeQuery(TreeNode root, int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        rangeQueryHelper(root, min, max, result);
        return result;
    }
    
    // 輔助方法：遞迴進行範圍查詢
    private static void rangeQueryHelper(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        
        // 如果當前節點值大於min，則左子樹可能有符合條件的節點
        if (node.data > min) {
            rangeQueryHelper(node.left, min, max, result);
        }
        
        // 如果當前節點在範圍內，加入結果
        if (node.data >= min && node.data <= max) {
            result.add(node.data);
        }
        
        // 如果當前節點值小於max，則右子樹可能有符合條件的節點
        if (node.data < max) {
            rangeQueryHelper(node.right, min, max, result);
        }
    }
    
    // 插入節點到BST
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }
    
    // 中序遍歷（用於驗證BST結構）
    public static void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left, result);
        result.add(root.data);
        inorderTraversal(root.right, result);
    }
    
    // 顯示樹狀結構
    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        printTree(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        
        printTree(node.left, level + 1);
    }
    
    public static void main(String[] args) {
        // 建立測試用的BST：[20, 10, 30, 5, 15, 25, 35]
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        
        System.out.println("建立BST，插入節點順序: ");
        for (int value : values) {
            System.out.print(value + " ");
            root = insert(root, value);
        }
        System.out.println("\n");
        
        // 顯示BST結構
        System.out.println("BST結構:");
        printTree(root, 0);
        System.out.println();
        
        // 驗證BST：中序遍歷應該得到排序結果
        ArrayList<Integer> inorderResult = new ArrayList<>();
        inorderTraversal(root, inorderResult);
        System.out.println("中序遍歷結果（驗證BST）: " + inorderResult);
        System.out.println();
        
        // 測試範圍查詢
        System.out.println("=== BST範圍查詢測試 ===");
        
        // 測試案例1：範圍[12, 27]
        ArrayList<Integer> result1 = rangeQuery(root, 12, 27);
        System.out.println("查詢範圍[12, 27]: " + result1);
        
        // 測試案例2：範圍[5, 15]
        ArrayList<Integer> result2 = rangeQuery(root, 5, 15);
        System.out.println("查詢範圍[5, 15]: " + result2);
        
        // 測試案例3：範圍[25, 40]
        ArrayList<Integer> result3 = rangeQuery(root, 25, 40);
        System.out.println("查詢範圍[25, 40]: " + result3);
        
        // 測試案例4：範圍[1, 50]（包含所有節點）
        ArrayList<Integer> result4 = rangeQuery(root, 1, 50);
        System.out.println("查詢範圍[1, 50]: " + result4);
        
        // 測試案例5：範圍[100, 200]（沒有符合的節點）
        ArrayList<Integer> result5 = rangeQuery(root, 100, 200);
        System.out.println("查詢範圍[100, 200]: " + result5);
        
        // 測試案例6：單一值範圍[20, 20]
        ArrayList<Integer> result6 = rangeQuery(root, 20, 20);
        System.out.println("查詢範圍[20, 20]: " + result6);
        
        System.out.println();
        
        // 額外測試：建立另一個BST
        System.out.println("=== 額外測試：另一個BST ===");
        TreeNode root2 = null;
        int[] values2 = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        
        for (int value : values2) {
            root2 = insert(root2, value);
        }
        
        System.out.println("第二個BST結構:");
        printTree(root2, 0);
        System.out.println();
        
        ArrayList<Integer> result7 = rangeQuery(root2, 25, 60);
        System.out.println("查詢範圍[25, 60]: " + result7);
        
        ArrayList<Integer> result8 = rangeQuery(root2, 15, 35);
        System.out.println("查詢範圍[15, 35]: " + result8);
    }
}