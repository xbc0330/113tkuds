import java.util.Scanner;

public class FactorialExampleinput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數：");
        int n = scanner.nextInt();

        int result = 1;
        System.out.print(n + "! = ");
        for (int i = n; i > 0; i--) {
            System.out.print(i);
            if (i != 1) {
                System.out.print(" * ");
            }
            result *= i;
        }

        System.out.println(" = " + result);
        scanner.close();
    }
}