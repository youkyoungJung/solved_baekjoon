import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    static int C;
    static int R;

    static int[][] dist = {{-1, 0}, {0, 1}, {1,0}, {0, -1}}; //상 좌 하 우
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        isVisited = new boolean[R+1][C+1];

        int K = Integer.parseInt(br.readLine());

        if(K > C * R){
            System.out.println(0);
            return;
        }

        int index = 0;
        int r = R;
        int c = 1;
        int dir = 0;

        while(++index != K){
            isVisited[r][c] = true;
            int nr = r + dist[dir][0];
            int nc = c + dist[dir][1];

            if(nr < 1 || nr > R || nc < 0 || nc > C || isVisited[nr][nc]){
                dir = ++dir % 4;
                nr = r + dist[dir][0];
                nc = c + dist[dir][1];
            }
            r = nr;
            c = nc;
        }
        System.out.println(c + " " + (R-r+1));

    }// end of main

}//end of class
