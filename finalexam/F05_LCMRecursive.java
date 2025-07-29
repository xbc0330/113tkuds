// === 計算複雜度分析 ===
// 時間複雜度：O(max(a, b))
// 空間複雜度：O(1)

import java.util.*;
public class F05_LCMRecursive {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long gcd = gcd(a, b);
        long lcm = a / gcd * b;
        System.out.println("LCM: " + lcm);
    }
    static long gcd(long a, long b){
        if(a == b) return a;
        if(a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }
}