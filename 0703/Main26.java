import java.util.Scanner;

public class Main26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long fact = 1;
        int i = 1;
        while (i <= N) {
            fact *= i;
            i++;
        }
        System.out.println(fact);
    }
}