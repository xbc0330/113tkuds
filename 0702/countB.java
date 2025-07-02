public class countB {
   
    public static void main(String[] args){
        int n = 5;
        int x = 0;
        int count = 0 ;
       
        for (int i = 1 ; i <= n; i++ ){
        x = x + 1;
        count++;
        x = x +2;
        }
        System.out.println("(a) x = x + 1 執行次書" + count);
    }
}