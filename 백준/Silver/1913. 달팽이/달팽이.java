import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] dist = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북, 동, 남, 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int r = N/2;
        int c = N/2;

        map[r][c] = 1;

        int moveCnt = 1;
        int dir = 0;
        int ar = 0;
        int ac = 0;
        if(map[r][c] == target){
            ar = r+1;
            ac = c+1;
        }

        out: while(true){

            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < moveCnt; j++) {
                    int nr = r + dist[dir][0];
                    int nc = c + dist[dir][1];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) {continue;}
                    map[nr][nc] = map[r][c] + 1;
                    r = nr;
                    c = nc;

                    if(map[nr][nc] == target){
                        ar = r+1;
                        ac = c+1;
                    }

                    if(map[nr][nc] == Math.pow(N, 2)){
                        break out;
                    }
                }

                dir = (dir + 1) % 4;
            }
            moveCnt++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(ar + " " + ac);


    }


}//end of class
