public class ArraySearcher {
    public static void main(String[] args) {
        int[] array = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int index1 = findElement(array, 67);
        int index2 = findElement(array, 100);

        System.out.println("67 的索引: " + index1);
        System.out.println("100 的索引: " + index2);

        int count1 = countOccurrences(array, 67);
        int count2 = countOccurrences(array, 100);

        System.out.println("67 出現次數: " + count1);
        System.out.println("100 出現次數: " + count2);
    }

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) count++;
        }
        return count;
    }
}