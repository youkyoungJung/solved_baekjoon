import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        
        List<int[]> questions = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            questions.add(new int[] { question, strike, ball });
        }

        int count = 0;
        
        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);
            if (candidate.charAt(0) == candidate.charAt(1) || candidate.charAt(1) == candidate.charAt(2) || candidate.charAt(0) == candidate.charAt(2)) {
                continue; 
            }
            if (candidate.contains("0")) {
                continue;  // 0이 포함된 숫자는 제외
            }

            boolean possible = true;

            for (int[] q : questions) {
                String guess = String.valueOf(q[0]);
                int expectedStrike = q[1];
                int expectedBall = q[2];

                int[] result = calculateSB(candidate, guess);
                int actualStrike = result[0];
                int actualBall = result[1];
                
                if (actualStrike != expectedStrike || actualBall != expectedBall) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        System.out.println(count);
    }
    
    public static int[] calculateSB(String candidate, String guess) {
        int strike = 0, ball = 0;

        // 스트라이크 계산
        for (int i = 0; i < 3; i++) {
            if (candidate.charAt(i) == guess.charAt(i)) {
                strike++;
            }
        }

        // 볼 계산
        for (int i = 0; i < 3; i++) {
            if (candidate.charAt(i) != guess.charAt(i) && guess.contains(String.valueOf(candidate.charAt(i)))) {
                ball++;
            }
        }

        return new int[] { strike, ball };
    }
}
