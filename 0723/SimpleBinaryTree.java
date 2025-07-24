public class SimpleBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        // 創建二元樹結構
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // 輸出樹的基本資訊
        System.out.println("樹的結構:");
        System.out.println("根節點: " + root.data);
        System.out.println("左子樹: " + root.left.data);
        System.out.println("右子樹: " + root.right.data);
        System.out.println("左子樹的左子樹: " + root.left.left.data);
        System.out.println("左子樹的右子樹: " + root.left.right.data);
        
        // 輸出樹狀圖
        System.out.println("\n樹狀圖:");
        printTree(root, 0);
    }
    
    public static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        // 先遞迴印右子樹（這樣會讓它出現在上方）
        printTree(node.right, level + 1);
        
        // 印出當前節點，前面加上適當的縮排
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(node.data);
        
        // 再遞迴印左子樹（這樣會讓它出現在下方）
        printTree(node.left, level + 1);
    }
}