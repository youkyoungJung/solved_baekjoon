import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int h;
    static boolean[][] isVisited;
    static int[][] arr;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static int w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            isVisited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            for(int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if(arr[i][j] == 1 && !isVisited[i][j]){
                        res++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }   // end of main

    public static void dfs(int r, int c){
        isVisited[r][c] = true;
       for(int i = 0; i < 8; i++){
           int nr = r + dist[i][0];
           int nc = c + dist[i][1];

           if(checked(nr, nc)){
               dfs(nr, nc);
           }
       }
    }

    public static boolean checked(int nr, int nc){
        return nr >= 0 && nr < h && nc >= 0 && nc < w && !isVisited[nr][nc] && arr[nr][nc] == 1;
    }

} // end of class
