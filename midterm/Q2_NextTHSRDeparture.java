/*
 * Time Complexity: O(log n)
 * 說明：轉換時間為分鐘後儲存並排序，使用二分搜尋找出第一個大於查詢時間的班次，
 *       時間複雜度為 O(log n)。
 */

import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            times[i] = toMinutes(t);
        }

        String query = sc.nextLine();
        int qTime = toMinutes(query);

        int left = 0, right = n - 1, idx = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > qTime) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (idx == n) {
            System.out.println("No train");
        } else {
            int hour = times[idx] / 60;
            int min = times[idx] % 60;
            System.out.printf("%02d:%02d\n", hour, min);
        }
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}