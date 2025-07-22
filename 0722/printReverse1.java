public class   printReverse1 {

    
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }
    
    

    
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
   

    public static void main(String[] args) {
        int n = 40;

        long start1 = System.currentTimeMillis();
        int result1 = fibonacciSlow(n);
        long end1 = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + result1);
        System.out.println("Time (slow): " + (end1 - start1) + " ms");

        int[] memo = new int[n + 1];
        long start2 = System.currentTimeMillis();
        int result2 = fibonacciFast(n, memo);
        long end2 = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + result2);
        System.out.println("Time (fast): " + (end2 - start2) + " ms");
    }
}