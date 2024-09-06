import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] arr;
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int colorful = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, 1);
                    colorful++;
                }
            }
        }

        int notColorful = 0;
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, 2);
                    notColorful++;
                }
            }
        }
        System.out.println(colorful + " " + notColorful);

    }// end of main

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void dfs(int x, int y, int color) {

        char target = arr[x][y];
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nr = x + dist[i][0];
            int nc = y + dist[i][1];

            if(checked(nr, nc)){
                if(color == 1 && arr[nr][nc] == target){
                    dfs(nr, nc, color);
                }else if(color == 2){ //적록 색약
                    //1. target이 만약에 적이여도 초까지, 초여도 적까지.
                    //2. 블루는 그대로
                    if(target == 'R' && (arr[nr][nc] == 'R' || arr[nr][nc] == 'G')){
                        dfs(nr, nc, color);
                    }else if(target == 'G' && (arr[nr][nc] == 'R' || arr[nr][nc] == 'G')){
                        dfs(nr, nc, color);
                    } else if(target == 'B' && arr[nr][nc] == target){
                        dfs(nr, nc, color);
                    }
                }
            }
        }

    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc];
    }

} // end of class
