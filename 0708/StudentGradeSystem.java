public class StudentGradeSystem {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};
        char[] grades = new char[scores.length];
        int[] gradeCount = new int[4];
        int sum = 0, max = scores[0], min = scores[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
            if (scores[i] >= 90) {
                grades[i] = 'A';
                gradeCount[0]++;
            } else if (scores[i] >= 80) {
                grades[i] = 'B';
                gradeCount[1]++;
            } else if (scores[i] >= 70) {
                grades[i] = 'C';
                gradeCount[2]++;
            } else {
                grades[i] = 'D';
                gradeCount[3]++;
            }
        }

        double average = (double) sum / scores.length;
        int aboveAvgCount = 0;
        for (int score : scores) {
            if (score > average) aboveAvgCount++;
        }
        double aboveAvgPercent = (double) aboveAvgCount / scores.length * 100;

        System.out.println("====== 學生成績報告 ======");
        System.out.printf("總分: %d, 平均: %.2f\n", sum, average);
        System.out.printf("最高分: %d (學生編號 %d)\n", max, maxIndex);
        System.out.printf("最低分: %d (學生編號 %d)\n", min, minIndex);
        System.out.printf("A: %d 人, B: %d 人, C: %d 人, D: %d 人\n", gradeCount[0], gradeCount[1], gradeCount[2], gradeCount[3]);
        System.out.printf("高於平均分數的學生比例: %.1f%%\n", aboveAvgPercent);
        System.out.println("--------------------------");
        System.out.println("編號\t分數\t等級");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%2d\t%3d\t %c\n", i, scores[i], grades[i]);
        }
    }
}