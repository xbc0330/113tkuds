import java.text.DecimalFormat;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intNum = sc.nextInt();
        double doubleNum = sc.nextDouble();
        double sum = intNum + doubleNum;

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(sum));
    }
}