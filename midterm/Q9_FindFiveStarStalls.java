import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5.0) count++;
        }

        if (count == 0) {
            System.out.println("None");
        } else {
            int[] idx = new int[count];
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5.0) {
                    idx[p++] = i;
                }
            }

            for (int i = 0; i < count; i++) {
                System.out.print(idx[i] + (i < count - 1 ? " " : "\n"));
            }
        }
    }
}