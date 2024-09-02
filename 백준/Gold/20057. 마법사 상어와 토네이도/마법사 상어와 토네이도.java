import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0; // 격자 밖으로 나간 모래 양
    static int[][] arr;
    static int N;
    static int[][] dist = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // 좌, 하, 우, 상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = N/2;
        int c = N/2;
        int dir = 0;
        int moveCnt = 1;

        //1. 토네이도 시작
        int index = 0;
        out:
        while(true){

            if(r == 0 && c == 0){
                break;
            }

            for(int i = 0; i < 2; i++){
                for(int j = 0; j < moveCnt; j++){
                    int nr = r + dist[dir][0];
                    int nc = c + dist[dir][1];

                    if(checked(nr, nc)){

                        //1. 일정 비율로 흩날림
                        //2. 모래양 계산, 업데이트
                        simulation(nr, nc, dir);

                        arr[nr][nc] = 0;
                        r = nr;
                        c = nc;
                    }

                    if(nr == 0 && nc == 0){
                        break out;
                    }
                }
                dir = (dir + 1) % 4;
                index++;
            }
            moveCnt++;
        }

        System.out.println(answer);

    }// end of main

    public static void simulation(int r, int c, int dir){
        double[] per = {2, 10, 7, 1, 5, 10, 7, 1, 2, 55};
        int[][][] dist = {
                {{-2, 0}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -2}, {1, -1}, {1, 0}, {1, 1}, {2, 0}, {0, -1}},
                {{0, -2}, {1, -1}, {0, -1}, {-1, -1}, {2, 0}, {1, 1}, {0, 1}, {-1, 1}, {0, 2}, {1, 0}},
                {{-2, 0}, {-1, 1}, {-1, 0}, {-1, -1}, {0, 2}, {1, 1}, {1, 0}, {1, -1}, {2, 0}, {0, 1}},
                {{0, -2}, {-1, -1}, {0, -1}, {1, -1}, {-2, 0}, {-1, 1}, {0, 1}, {1, 1}, {0, 2}, {-1, 0}}}; //좌, 하, 우, 상

        //1. 이동시, 일정한 비율로
        int sum = 0;
        int res = 0;
        for(int i = 0; i < 10; i++){
            int nr = r + dist[dir][i][0];
            int nc = c + dist[dir][i][1];

            if(i == 9){
                res = arr[r][c] - sum;
            }else {
                res = (int) (arr[r][c] * per[i] * 0.01);
                sum += res;
            }

            if(checked(nr, nc)){
                arr[nr][nc] += res;
            }else{
                //2. 격자 밖 모래양 계산
                answer += res;
            }
        }

    }

    public static boolean checked(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
} // end of class
