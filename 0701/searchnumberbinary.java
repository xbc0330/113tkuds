import java.unil.Scanner;

public class test2 {
    int[] s = {1, 3, 5, 7, 9, 11, 13};
    Scanner scanner = new Scanner(System.in);

    System.out.print("請輸入要查詢的數字:");
    int x = scanner.nextInt();
    
    int left = 0;
    int right = s.length - 1;
    boolean found = false;
 
    while (left <= right) {
        int mid = (left + right) / 2;
        System.out.println("比對中：x = " + x +",中間元素 = "+ s[mid]);

        if (s[mid] == x){
            found = true;
            break;
        } else if (s[mid] < x){
            left = mid + 1;   
        } else {
            right = mid - 1;

        }   
        }
}
