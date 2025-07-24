public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 方法1：使用計數器的中序遍歷（最直觀）
    private static int count = 0;
    private static int result = -1;
    
    public static int findKthSmallest(TreeNode root, int k) {
        count = 0;  // 重置計數器
        result = -1; // 重置結果
        inorderWithCount(root, k);
        return result;
    }
    
    private static void inorderWithCount(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }
        
        // 遍歷左子樹
        inorderWithCount(node.left, k);
        
        // 處理當前節點
        count++;
        if (count == k) {
            result = node.data;
            return;
        }
        
        // 遍歷右子樹
        inorderWithCount(node.right, k);
    }
    
    // 方法2：使用包裝類避免靜態變數（更好的設計）
    static class Counter {
        int count = 0;
        int result = -1;
    }
    
    public static int findKthSmallestV2(TreeNode root, int k) {
        Counter counter = new Counter();
        inorderWithCounter(root, k, counter);
        return counter.result;
    }
    
    private static void inorderWithCounter(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) {
            return;
        }
        
        // 遍歷左子樹
        inorderWithCounter(node.left, k, counter);
        
        // 處理當前節點
        counter.count++;
        if (counter.count == k) {
            counter.result = node.data;
            return;
        }
        
        // 遍歷右子樹
        inorderWithCounter(node.right, k, counter);
    }
    
    // 方法3：優化版本 - 利用BST性質和子樹大小
    static class NodeWithSize {
        int data;
        NodeWithSize left;
        NodeWithSize right;
        int size; // 以此節點為根的子樹節點數量
        
        public NodeWithSize(int data) {
            this.data = data;
            this.size = 1;
        }
    }
    
    // 插入節點並維護size資訊
    public static NodeWithSize insertWithSize(NodeWithSize root, int data) {
        if (root == null) {
            return new NodeWithSize(data);
        }
        
        if (data < root.data) {
            root.left = insertWithSize(root.left, data);
        } else if (data > root.data) {
            root.right = insertWithSize(root.right, data);
        }
        
        // 更新節點大小
        root.size = 1 + getSize(root.left) + getSize(root.right);
        return root;
    }
    
    private static int getSize(NodeWithSize node) {
        return node == null ? 0 : node.size;
    }
    
    // 利用子樹大小找第k小元素 - O(log n) 平均時間複雜度
    public static int findKthSmallestOptimized(NodeWithSize root, int k) {
        if (root == null) {
            return -1;
        }
        
        int leftSize = getSize(root.left);
        
        if (k <= leftSize) {
            // 第k小在左子樹
            return findKthSmallestOptimized(root.left, k);
        } else if (k == leftSize + 1) {
            // 當前節點就是第k小
            return root.data;
        } else {
            // 第k小在右子樹，調整k值
            return findKthSmallestOptimized(root.right, k - leftSize - 1);
        }
    }
    
    // 輔助方法：插入節點到普通BST
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
    
    // 輔助方法：中序遍歷顯示BST
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
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
    
    // 顯示帶大小資訊的樹
    public static void printTreeWithSize(NodeWithSize node, int level) {
        if (node == null) {
            return;
        }
        
        printTreeWithSize(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data + "(size:" + node.size + ")");
        
        printTreeWithSize(node.left, level + 1);
    }
    
    public static void main(String[] args) {
        System.out.println("=== BST第k小元素查找 ===\n");
        
        // 建立測試BST
        TreeNode root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35, 1, 8, 12, 18};
        
        System.out.println("建立BST，插入順序: ");
        for (int value : values) {
            System.out.print(value + " ");
            root = insert(root, value);
        }
        System.out.println("\n");
        
        System.out.println("BST結構:");
        printTree(root, 0);
        System.out.println();
        
        System.out.print("中序遍歷結果（排序）: ");
        inorderTraversal(root);
        System.out.println("\n");
        
        // 測試方法1：基本版本
        System.out.println("=== 方法1測試：基本中序遍歷 ===");
        for (int k = 1; k <= 5; k++) {
            int kthSmallest = findKthSmallest(root, k);
            System.out.println("第" + k + "小的元素: " + kthSmallest);
        }
        System.out.println();
        
        // 測試方法2：改進版本
        System.out.println("=== 方法2測試：使用Counter類 ===");
        for (int k = 6; k <= 10; k++) {
            int kthSmallest = findKthSmallestV2(root, k);
            System.out.println("第" + k + "小的元素: " + kthSmallest);
        }
        System.out.println();
        
        // 測試邊界情況
        System.out.println("=== 邊界情況測試 ===");
        System.out.println("第1小的元素: " + findKthSmallestV2(root, 1));
        System.out.println("第11小的元素: " + findKthSmallestV2(root, 11));
        System.out.println("第12小的元素（超出範圍）: " + findKthSmallestV2(root, 12));
        System.out.println("第0小的元素（無效k）: " + findKthSmallestV2(root, 0));
        System.out.println();
        
        // 測試方法3：優化版本
        System.out.println("=== 方法3測試：優化版本（利用子樹大小）===");
        NodeWithSize optimizedRoot = null;
        
        System.out.println("建立帶大小資訊的BST:");
        for (int value : values) {
            optimizedRoot = insertWithSize(optimizedRoot, value);
        }
        
        System.out.println("帶大小資訊的BST結構:");
        printTreeWithSize(optimizedRoot, 0);
        System.out.println();
        
        System.out.println("使用優化方法查找:");
        for (int k = 1; k <= 11; k++) {
            int kthSmallest = findKthSmallestOptimized(optimizedRoot, k);
            System.out.println("第" + k + "小的元素: " + kthSmallest);
        }
        System.out.println();
        
        // 性能比較說明
        System.out.println("=== 方法比較 ===");
        System.out.println("方法1&2 - 中序遍歷:");
        System.out.println("  時間複雜度: O(k) 最佳，O(n) 最壞");
        System.out.println("  空間複雜度: O(h) 其中h是樹的高度");
        System.out.println("  優點: 實作簡單，不需要額外空間存儲");
        System.out.println();
        
        System.out.println("方法3 - 利用子樹大小:");
        System.out.println("  時間複雜度: O(log n) 平均，O(n) 最壞");
        System.out.println("  空間複雜度: O(n) 用於存儲大小資訊");
        System.out.println("  優點: 查詢效率高，適合頻繁查詢");
        System.out.println("  缺點: 需要額外空間，插入/刪除需維護大小資訊");
    }
}