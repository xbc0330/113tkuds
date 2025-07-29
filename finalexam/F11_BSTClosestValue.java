import java.util.*;
public class F11_BSTClosestValue {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ val = v; }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int T = sc.nextInt();
        Node root = buildBST(arr);
        System.out.println(closestValue(root, T));
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
    static int closestValue(Node root, int target){
        int closest = root.val;
        Node cur = root;
        while(cur != null){
            if(Math.abs(cur.val - target) < Math.abs(closest - target) ||
              (Math.abs(cur.val - target) == Math.abs(closest - target) && cur.val < closest)){
                closest = cur.val;
            }
            if(target < cur.val) cur = cur.left;
            else if(target > cur.val) cur = cur.right;
            else break;
        }
        return closest;
    }
}