// === 計算複雜度分析 ===
// 時間複雜度：O(n)
// 空間複雜度：O(n)

import java.util.*;
public class F01_TMRTStopCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stops = new String[n];
        for(int i=0; i<n; i++) stops[i] = sc.next();
        String start = sc.next();
        String end = sc.next();
        int i1 = -1, i2 = -1;
        for(int i=0; i<n; i++){
            if(stops[i].equals(start)) i1 = i;
            if(stops[i].equals(end)) i2 = i;
        }
        if(i1 == -1 || i2 == -1){
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(i2 - i1) + 1);
        }
    }
}