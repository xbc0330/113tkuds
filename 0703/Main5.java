import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int celsius = sc.nextInt();
        int fahrenheit = (int)((celsius * 9.0 / 5) + 32);
        System.out.println(fahrenheit);
    }
}