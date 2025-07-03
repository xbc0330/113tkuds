import java.util.Scanner;

public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] colSums = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = sc.nextInt();
                colSums[j] += val;
            }
        }

        for (int j = 0; j < M; j++) {
            System.out.print(colSums[j]);
            if (j != M - 1) System.out.print(" ");
        }
    }
}