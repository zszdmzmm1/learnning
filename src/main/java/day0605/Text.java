package day0605;

public class Text {
    public static void main(String[] args) {
        int[] scores = {5, 4, 6, 8, 9, 0, 1, 2, 7, 3};
        int sum = 0;
        int minScore = scores[0];
        int maxScore = scores[0];
        double avg = 0.0;


        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > maxScore){
                maxScore = scores[i];
            }
            if(scores[i] < minScore){
                minScore = scores[i];
            }
            sum += scores[i];
        }
        avg = (double)(sum - minScore - maxScore)/(scores.length - 2);
        System.out.println(minScore);
        System.out.println(maxScore);
        System.out.println(avg);

    }
}
