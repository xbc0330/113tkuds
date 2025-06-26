public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 12, 5, 9, 21, 8, 14, 6, 10};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        System.out.println("所有元素的總和為：" + sum);
    }
}