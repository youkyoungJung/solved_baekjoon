import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int sum = 0;
    static int bottom = 0;
    static int top = 0;
    static int[][] dice;
    static int[] tops = {5, 3, 4, 1, 2, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dice = new int[N][6];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum = 0;

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < 6; i++){
            //1.밑면 숫자 구하기
            bottom = dice[0][i];
            //2. 윗면 숫자 구하기
            top = dice[0][tops[i]];

            //3. findMax (옆면 중 최댓값 구하기)
            findMax(0, i);
            //4. simulation
            for(int s = 1; s < N; s++){
                simulation(s);
            }
            res = Math.max(res, sum);
            sum = 0;
        }
        System.out.println(res);
    } // end of main

    static int index = 0;
    public static void simulation(int next){
        for(int i = 0; i < 6; i++){
            //1. top 과 동일한 아랫면 숫자 구하기
            bottom = dice[next][i];
            if(dice[next][i] == top){
                //2. 윗면 숫자 구하기
                top = dice[next][tops[i]];
                findMax(next, i);
                break;
            }
        }
    }

    public static void findMax(int next, int index){

        int diff = tops[index];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 6; i++){
            if(i == diff || i == index){
                continue;
            }
            max = Math.max(max, dice[next][i]);
        }
        sum += max;
    }

}//end of class
