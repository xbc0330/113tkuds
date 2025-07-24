public class SimpleBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 搜尋值
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;
        
        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }
    
    // 印出樹狀結構（橫向顯示）
    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        // 先遞迴印右子樹
        printTree(node.right, level + 1);
        
        // 印出當前節點，前面加上適當的縮排
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        
        // 再遞迴印左子樹
        printTree(node.left, level + 1);
    }
    
    public static void main(String[] args) {
        // 手動建立一個BST（8個節點）
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(10);
        
        // 顯示BST結構
        System.out.println("二元搜尋樹結構:");
        printTree(root, 0);
        System.out.println();
        
        // 第一次搜尋測試
        System.out.println("=== 第一次搜尋測試 ===");
        System.out.println("搜尋 30: " + search(root, 30));
        System.out.println("搜尋 40: " + search(root, 40));
        System.out.println("搜尋 60: " + search(root, 60));
        System.out.println("搜尋 25: " + search(root, 25));
        System.out.println();
        
        // 第二次搜尋測試
        System.out.println("=== 第二次搜尋測試 ===");
        System.out.println("搜尋 10: " + search(root, 10));
        System.out.println("搜尋 80: " + search(root, 80));
        System.out.println("搜尋 90: " + search(root, 90));
        System.out.println("搜尋 35: " + search(root, 35));
    }
}