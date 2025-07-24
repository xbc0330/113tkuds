public class TreeStatistics {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 1. 計算樹中所有節點值的總和
    public static int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.data + calculateSum(root.left) + calculateSum(root.right);
    }
    
    // 2. 找出樹中的最大值
    public static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE; // 空樹時返回最小整數值
        }
        
        int maxValue = root.data;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        
        if (leftMax != Integer.MIN_VALUE && leftMax > maxValue) {
            maxValue = leftMax;
        }
        if (rightMax != Integer.MIN_VALUE && rightMax > maxValue) {
            maxValue = rightMax;
        }
        
        return maxValue;
    }
    
    // 找出樹中的最小值
    public static int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE; // 空樹時返回最大整數值
        }
        
        int minValue = root.data;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        
        if (leftMin != Integer.MAX_VALUE && leftMin < minValue) {
            minValue = leftMin;
        }
        if (rightMin != Integer.MAX_VALUE && rightMin < minValue) {
            minValue = rightMin;
        }
        
        return minValue;
    }
    
    // 3. 計算所有葉節點的數量
    public static int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // 如果是葉節點（左右子樹都為空）
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // 遞迴計算左右子樹的葉節點數量
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }
    
    // 4. 計算樹的深度（高度）
    public static int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);
        
        // 返回較深的子樹深度 + 1（當前節點）
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    // 輔助方法：顯示樹狀結構
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
        // 建立測試用的二元樹
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(1);
        
        // 顯示樹的結構
        System.out.println("二元樹結構:");
        printTree(root, 0);
        System.out.println();
        
        // 執行統計功能測試
        System.out.println("=== 樹的基本統計 ===");
        
        // 1. 計算總和
        int sum = calculateSum(root);
        System.out.println("所有節點值的總和: " + sum);
        
        // 2. 找出最大值和最小值
        int maxValue = findMax(root);
        int minValue = findMin(root);
        System.out.println("樹中的最大值: " + maxValue);
        System.out.println("樹中的最小值: " + minValue);
        
        // 3. 計算葉節點數量
        int leafCount = countLeafNodes(root);
        System.out.println("葉節點的數量: " + leafCount);
        
        // 4. 計算樹的深度
        int depth = calculateDepth(root);
        System.out.println("樹的深度（高度）: " + depth);
        
        System.out.println();
        
        // 額外測試：建立另一個更簡單的樹
        System.out.println("=== 測試簡單樹 ===");
        TreeNode simpleRoot = new TreeNode(1);
        simpleRoot.left = new TreeNode(2);
        simpleRoot.right = new TreeNode(3);
        
        System.out.println("簡單樹結構:");
        printTree(simpleRoot, 0);
        System.out.println();
        
        System.out.println("簡單樹統計:");
        System.out.println("總和: " + calculateSum(simpleRoot));
        System.out.println("最大值: " + findMax(simpleRoot));
        System.out.println("最小值: " + findMin(simpleRoot));
        System.out.println("葉節點數量: " + countLeafNodes(simpleRoot));
        System.out.println("深度: " + calculateDepth(simpleRoot));
    }
}