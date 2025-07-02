import java.util.Scanner;

public class q7permutation {
    static int ops = 0;

    public static void permute(int[] arr, int l, int r) {
        if (l == r) {
            for (int i = 0; i <= r; i++) {
                System.out.print(arr[i]);
                if (i < r) System.out.print(" ");
            }
            System.out.println();
            ops++;
            return;
        }
        for (int i = l; i <= r; i++) {
            int temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;

            permute(arr, l + 1, r);

            temp = arr[l];
            arr[l] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        permute(arr, 0, n - 1);
        System.out.println(ops);
        sc.close();
    }
}