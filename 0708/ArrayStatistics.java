public class ArrayStatistics {
    public static void main(String[] args) {
        int[] array = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0, max = array[0], min = array[0];
        int maxIndex = 0, minIndex = 0;
        int evenCount = 0, oddCount = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
            if (array[i] % 2 == 0) evenCount++;
            else oddCount++;
        }

        double average = (double) sum / array.length;

        int aboveAverageCount = 0;
        for (int num : array) {
            if (num > average) aboveAverageCount++;
        }

        System.out.println("+------------------------+");
        System.out.printf("| 總和           | %6d |\n", sum);
        System.out.printf("| 平均值         | %6.2f |\n", average);
        System.out.printf("| 最大值         | %6d |\n", max);
        System.out.printf("| 最大值索引     | %6d |\n", maxIndex);
        System.out.printf("| 最小值         | %6d |\n", min);
        System.out.printf("| 最小值索引     | %6d |\n", minIndex);
        System.out.printf("| 大於平均的數量 | %6d |\n", aboveAverageCount);
        System.out.printf("| 偶數數量       | %6d |\n", evenCount);
        System.out.printf("| 奇數數量       | %6d |\n", oddCount);
        System.out.println("+------------------------+");
    }
}