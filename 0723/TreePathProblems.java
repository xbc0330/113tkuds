import java.util.*;

public class TreePathProblems {

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
                    5
                   / \
                  4   8
                 /   / \
                11  13  4
               /  \      \
              7    2      1
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        // 1️⃣ 所有從根到葉的路徑
        System.out.println("所有根到葉的路徑：");
        List<List<Integer>> allPaths = new ArrayList<>();
        findAllPaths(root, new ArrayList<>(), allPaths);
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }

        // 2️⃣ 是否存在總和為目標的根到葉路徑
        int targetSum = 22;
        boolean hasPath = hasPathSum(root, targetSum);
        System.out.println("\n是否存在總和為 " + targetSum + " 的路徑: " + hasPath);

        // 3️⃣ 找出最大總和的根到葉路徑
        List<Integer> maxPath = findMaxSumPath(root);
        int maxSum = maxPath.stream().mapToInt(i -> i).sum();
        System.out.println("\n最大總和的路徑: " + maxPath);
        System.out.println("最大總和為: " + maxSum);
    }

    // 1️⃣ 找出所有根到葉路徑
    public static void findAllPaths(TreeNode node, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) return;

        currentPath.add(node.val);

        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findAllPaths(node.left, currentPath, allPaths);
            findAllPaths(node.right, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1); // 回溯
    }

    // 2️⃣ 是否存在某個總和的根到葉路徑
    public static boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;

        // 葉節點且加總剛好等於目標
        if (node.left == null && node.right == null) {
            return node.val == targetSum;
        }

        return hasPathSum(node.left, targetSum - node.val) ||
               hasPathSum(node.right, targetSum - node.val);
    }

    // 3️⃣ 找出總和最大的根到葉路徑
    public static List<Integer> findMaxSumPath(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        findMaxPathHelper(root, temp, 0, maxSum, result);
        return result;
    }

    private static void findMaxPathHelper(TreeNode node, List<Integer> path, int sum, int[] maxSum, List<Integer> result) {
        if (node == null) return;

        path.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                result.clear();
                result.addAll(path);
            }
        }

        findMaxPathHelper(node.left, path, sum, maxSum, result);
        findMaxPathHelper(node.right, path, sum, maxSum, result);
        path.remove(path.size() - 1); // 回溯
    }
}