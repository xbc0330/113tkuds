public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 1. 判斷一個二元樹是否是對稱的（左右子樹互為鏡像）
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true; // 空樹被認為是對稱的
        }
        return isMirror(root.left, root.right);
    }
    
    // 輔助方法：檢查兩個子樹是否互為鏡像
    private static boolean isMirror(TreeNode left, TreeNode right) {
        // 如果兩個節點都為空，則為鏡像
        if (left == null && right == null) {
            return true;
        }
        
        // 如果只有一個節點為空，則不為鏡像
        if (left == null || right == null) {
            return false;
        }
        
        // 檢查節點值是否相等，且左節點的左子樹與右節點的右子樹為鏡像，
        // 左節點的右子樹與右節點的左子樹為鏡像
        return (left.data == right.data) && 
               isMirror(left.left, right.right) && 
               isMirror(left.right, right.left);
    }
    
    // 2. 將一個二元樹轉換為其鏡像樹（左右子樹互換）
    public static TreeNode createMirror(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // 創建新的根節點
        TreeNode mirrorRoot = new TreeNode(root.data);
        
        // 遞迴創建鏡像：左子樹變成右子樹，右子樹變成左子樹
        mirrorRoot.left = createMirror(root.right);
        mirrorRoot.right = createMirror(root.left);
        
        return mirrorRoot;
    }
    
    // 原地鏡像轉換（修改原樹）
    public static void mirrorInPlace(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // 交換左右子樹
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        // 遞迴處理左右子樹
        mirrorInPlace(root.left);
        mirrorInPlace(root.right);
    }
    
    // 3. 比較兩個二元樹是否互為鏡像
    public static boolean areMirrors(TreeNode tree1, TreeNode tree2) {
        return isMirror(tree1, tree2);
    }
    
    // 輔助方法：複製樹
    public static TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode newRoot = new TreeNode(root.data);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        
        return newRoot;
    }
    
    // 顯示樹狀結構
    public static void printTree(TreeNode node, int level, String prefix) {
        if (node == null) {
            return;
        }
        
        printTree(node.right, level + 1, "R");
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(prefix + ": " + node.data);
        
        printTree(node.left, level + 1, "L");
    }
    
    // 簡化的樹狀顯示
    public static void printSimpleTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        
        printSimpleTree(node.right, level + 1);
        
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.data);
        
        printSimpleTree(node.left, level + 1);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 二元樹鏡像操作測試 ===\n");
        
        // 測試1：建立對稱樹
        System.out.println("測試1：對稱樹");
        TreeNode symmetricTree = new TreeNode(1);
        symmetricTree.left = new TreeNode(2);
        symmetricTree.right = new TreeNode(2);
        symmetricTree.left.left = new TreeNode(3);
        symmetricTree.left.right = new TreeNode(4);
        symmetricTree.right.left = new TreeNode(4);
        symmetricTree.right.right = new TreeNode(3);
        
        System.out.println("對稱樹結構:");
        printTree(symmetricTree, 0, "Root");
        System.out.println("是否對稱: " + isSymmetric(symmetricTree));
        System.out.println();
        
        // 測試2：建立非對稱樹
        System.out.println("測試2：非對稱樹");
        TreeNode asymmetricTree = new TreeNode(1);
        asymmetricTree.left = new TreeNode(2);
        asymmetricTree.right = new TreeNode(2);
        asymmetricTree.left.right = new TreeNode(3);
        asymmetricTree.right.right = new TreeNode(3);
        
        System.out.println("非對稱樹結構:");
        printTree(asymmetricTree, 0, "Root");
        System.out.println("是否對稱: " + isSymmetric(asymmetricTree));
        System.out.println();
        
        // 測試3：創建鏡像樹
        System.out.println("測試3：創建鏡像樹");
        TreeNode originalTree = new TreeNode(1);
        originalTree.left = new TreeNode(2);
        originalTree.right = new TreeNode(3);
        originalTree.left.left = new TreeNode(4);
        originalTree.left.right = new TreeNode(5);
        
        System.out.println("原始樹:");
        printSimpleTree(originalTree, 0);
        
        TreeNode mirrorTree = createMirror(originalTree);
        System.out.println("鏡像樹:");
        printSimpleTree(mirrorTree, 0);
        
        System.out.println("原樹與鏡像樹是否互為鏡像: " + areMirrors(originalTree, mirrorTree));
        System.out.println();
        
        // 測試4：原地鏡像轉換
        System.out.println("測試4：原地鏡像轉換");
        TreeNode testTree = copyTree(originalTree); // 複製原樹以保持原樹不變
        
        System.out.println("轉換前:");
        printSimpleTree(testTree, 0);
        
        mirrorInPlace(testTree);
        
        System.out.println("轉換後:");
        printSimpleTree(testTree, 0);
        
        System.out.println("轉換後的樹與原樹是否互為鏡像: " + areMirrors(originalTree, testTree));
        System.out.println();
        
        // 測試5：比較兩個不同的樹
        System.out.println("測試5：比較兩個不同的樹");
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(2);
        
        System.out.println("樹1:");
        printSimpleTree(tree1, 0);
        System.out.println("樹2:");
        printSimpleTree(tree2, 0);
        
        System.out.println("兩樹是否互為鏡像: " + areMirrors(tree1, tree2));
        System.out.println();
        
        // 測試6：空樹和單節點樹
        System.out.println("測試6：特殊情況");
        System.out.println("空樹是否對稱: " + isSymmetric(null));
        
        TreeNode singleNode = new TreeNode(1);
        System.out.println("單節點樹是否對稱: " + isSymmetric(singleNode));
        
        System.out.println("空樹與空樹是否互為鏡像: " + areMirrors(null, null));
        System.out.println("單節點樹與其自身是否互為鏡像: " + areMirrors(singleNode, singleNode));
    }
}