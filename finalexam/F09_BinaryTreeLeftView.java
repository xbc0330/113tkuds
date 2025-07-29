import java.util.*;
public class F09_BinaryTreeLeftView {
    static class Node {
        int val;
        Node left, right;
        Node(int v){ val = v; }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        if(arr.length == 0 || arr[0].equals("-1")){
            System.out.println("LeftView:");
            return;
        }
        Node root = buildTree(arr);
        List<Integer> leftView = getLeftView(root);
        System.out.print("LeftView:");
        for(int v : leftView) System.out.print(" " + v);
        System.out.println();
    }
    static Node buildTree(String[] arr){
        if(arr.length == 0) return null;
        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < arr.length){
            Node cur = q.poll();
            if(!arr[i].equals("-1")){
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
    static List<Integer> getLeftView(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node cur = q.poll();
                if(i == 0) res.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}