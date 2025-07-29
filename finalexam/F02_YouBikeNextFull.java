// === 計算複雜度分析 ===
// 時間複雜度：O(log n)
// 空間複雜度：O(n)

import java.util.*;
public class F02_YouBikeNextFull {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        for(int i=0; i<n; i++){
            String[] hhmm = sc.nextLine().split(":");
            times[i] = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
        }
        String[] q = sc.nextLine().split(":");
        int qt = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);
        int idx = Arrays.binarySearch(times, qt + 1);
        if(idx < 0) idx = -idx - 1;
        if(idx >= n){
            System.out.println("No bike");
        } else {
            int t = times[idx];
            System.out.printf("%02d:%02d\n", t/60, t%60);
        }
    }
}