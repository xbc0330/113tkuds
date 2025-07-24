import java.util.*;

public class BSTValidation {

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
                    10
                   /  \
                 5     8   <-- 錯：8 應該 > 10
                / \
               1   12 <-- 錯：12 應該 < 10
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);         // 錯誤節點
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);   // 錯誤節點

        // 驗證 BST
        boolean isValid = isValidBST(root);
        System.out.println("是否為有效的BST: " + isValid);

        // 找出不合法節點
        List<Integer> invalidNodes = new ArrayList<>();
        findInvalidNodes(root, Long.MIN_VALUE, Long.MAX_VALUE, invalidNodes);
        System.out.println("不合法節點: " + invalidNodes);
        System.out.println("需要移除的節點數量: " + invalidNodes.size());
    }

    // ✅ 驗證是否為合法 BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // ✅ 找出不合法的節點（違反 BST 規則）
    public static void findInvalidNodes(TreeNode node, long min, long max, List<Integer> invalid) {
        if (node == null) return;

        if (node.val <= min || node.val >= max) {
            invalid.add(node.val);
        }

        findInvalidNodes(node.left, min, Math.min(max, node.val), invalid);
        findInvalidNodes(node.right, Math.max(min, node.val), max, invalid);
    }
}