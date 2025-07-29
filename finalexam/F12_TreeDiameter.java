import java.util.*;
public class F12_TreeDiameter {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ val = v; }
    }
    static int diameter;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        Node root = buildTree(arr);
        diameter = 0;
        height(root);
        System.out.println(diameter);
    }
    static Node buildTree(String[] arr){
        if(arr.length == 0 || arr[0].equals("-1")) return null;
        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            Node cur = q.poll();
            if(i < arr.length && !arr[i].equals("-1")){
                cur.left = new Node(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            i++;
            if(i < arr.length && !arr[i].equals("-1")){
                cur.right = new Node(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }
    static int height(Node root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}