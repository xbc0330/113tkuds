import java.util.Arrays;
import java.util.Scanner;
 
public class LinearSearchDemoin {
 
    // 基本線性搜尋：找第一個符合的元素
    static int linearSearch(int[] array, int target) {
        int comparisons = 0;
        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n", comparisons, i, array[i], target);
            if (array[i] == target) {
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;
            }
        }
        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;
    }
 
    // 找出所有符合的索引
    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        if (count == 0) return new int[0];
 
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[index++] = i;
            }
        }
        return result;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[6];
        System.out.println("請依序輸入 6 個整數：");
 
        // 使用者輸入 6 個整數
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("第 " + (i + 1) + " 個整數：");
            numbers[i] = scanner.nextInt();
        }
 
        // 使用者輸入搜尋目標值
        System.out.print("請輸入要搜尋的目標值：");
        int target = scanner.nextInt();
 
        // 顯示陣列與目標
        System.out.println("\n輸入的陣列：" + Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
 
        // 執行基本搜尋
        System.out.println("\n=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);
        if (result != -1) {
            System.out.printf("目標值 %d 出現在索引 %d。\n", target, result);
        } else {
            System.out.printf("找不到目標值 %d。\n", target);
        }
 
        // 執行所有出現次數搜尋
        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allMatches = linearSearchAll(numbers, target);
        if (allMatches.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：%s\n", target, Arrays.toString(allMatches));
            System.out.printf("總共出現 %d 次。\n", allMatches.length);
        } else {
            System.out.printf("目標值 %d 沒有出現在陣列中。\n", target);
        }
 
        scanner.close();
    }
}