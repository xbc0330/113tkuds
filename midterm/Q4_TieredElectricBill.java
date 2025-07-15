/*
 * Time Complexity: O(n)
 * 說明：每筆電量透過條件判斷計算電費，最多進行 6 次分段處理，
 *       處理 n 筆輸入資料為 O(n)。
 */

import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            total += bill;
            System.out.println("Bill: $" + bill);
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int kWh) {
        double fee = 0;
        int[] bounds = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};
        int[] limits = new int[6];
        limits[0] = Math.min(120, kWh);
        limits[1] = Math.min(330, kWh) - limits[0];
        limits[2] = Math.min(500, kWh) - 330;
        limits[3] = Math.min(700, kWh) - 500;
        limits[4] = Math.min(1000, kWh) - 700;
        limits[5] = Math.max(0, kWh - 1000);

        for (int i = 0; i < 6; i++) {
            if (limits[i] > 0)
                fee += limits[i] * rates[i];
        }

        return (int) Math.round(fee);
    }
}