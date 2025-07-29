// === 計算複雜度分析 ===
// 時間複雜度：O(n)
// 空間複雜度：O(1)

import java.util.*;
public class F04_TieredIncomeTax {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for(int i=0; i<n; i++){
            long income = sc.nextLong();
            long tax = 0;
            long rem = income;
            if(rem > 1000000){
                tax += (rem - 1000000) * 40 / 100;
                rem = 1000000;
            }
            if(rem > 600000){
                tax += (rem - 600000) * 30 / 100;
                rem = 600000;
            }
            if(rem > 300000){
                tax += (rem - 300000) * 20 / 100;
                rem = 300000;
            }
            if(rem > 100000){
                tax += (rem - 100000) * 12 / 100;
                rem = 100000;
            }
            tax += rem * 5 / 100;
            System.out.println("Tax: $" + tax);
            sum += tax;
        }
        System.out.println("Average: $" + (sum / n));
    }
}