public class ScoreStatistics {
    public static void main(String[] args) {
        int[] scores = {85, 92, 77, 60, 88, 95, 73, 68, 89, 91};
 
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
 
       
        double average = (double) sum / scores.length;
        int studentCount = scores.length;
 
        System.out.println("==== 成績統計結果 ====");
        System.out.printf("學生人數共: %d 人\n", studentCount);
        System.out.printf("總分: %d 分\n", sum);
        System.out.printf("平均成績: %.2f 分\n", average);

    
        System.out.println("\n個別成績為：");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("第 %2d 位學生: %d 分\n", i + 1, scores[i]);
        }
    }
}
}
