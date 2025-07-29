import java.util.*;
public class F10_BSTRangeSum {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ val = v; }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int L = sc.nextInt();
        int R = sc.nextInt();
        Node root = buildBST(arr);
        System.out.println(rangeSum(root, L, R));
    }
    static Node buildBST(String[] arr){
        Node root = null;
        for(String s : arr){
            if(s.equals("-1")) continue;
            root = insert(root, Integer.parseInt(s));
        }
        return root;
    }
    static Node insert(Node root, int val){
        if(root == null) return new Node(val);
        if(val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    static int rangeSum(Node root, int L, int R){
        if(root == null) return 0;
        if(root.val < L) return rangeSum(root.right, L, R);
        if(root.val > R) return rangeSum(root.left, L, R);
        return root.val + rangeSum(root.left, L, R) + rangeSum(root.right, L, R);
    }
}