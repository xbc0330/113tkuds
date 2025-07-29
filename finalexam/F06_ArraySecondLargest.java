// === 計算複雜度分析 ===
// 時間複雜度：O(n)
// 空間複雜度：O(log n)

import java.util.*;
public class F06_ArraySecondLargest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] v = new int[n];
        for(int i=0; i<n; i++) v[i] = sc.nextInt();
        Pair result = findSecond(v, 0, n-1);
        System.out.println("SecondMax: " + result.second);
    }
    static class Pair {
        int max, second;
        Pair(int m, int s){ max = m; second = s; }
    }
    static Pair findSecond(int[] v, int lo, int hi){
        if(lo == hi) return new Pair(v[lo], Integer.MIN_VALUE);
        int mid = (lo + hi) / 2;
        Pair L = findSecond(v, lo, mid);
        Pair R = findSecond(v, mid+1, hi);
        int max, second;
        if(L.max > R.max){
            max = L.max;
            second = Math.max(L.second, R.max);
        } else {
            max = R.max;
            second = Math.max(R.second, L.max);
        }
        return new Pair(max, second);
    }
}