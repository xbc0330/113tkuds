public class TestC {
    public static void main(String[] args) {
        int n = 5;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                x = x + 1;
            }
        }
        System.out.println("x = x + 1 被執行次數: " + x);
    }
}
