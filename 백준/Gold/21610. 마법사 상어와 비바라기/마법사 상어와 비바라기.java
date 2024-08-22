import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] dist = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static List<Cloud> clouds;
    static int[][] bucket;
    static boolean[][] isPast;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bucket = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bucket[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구름 생성
        clouds = new ArrayList<>();
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));
        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());

            simulation(d, s);

        }

        //answer : 바구니에 들어 있는 물의 양 계산
        int res = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res += bucket[i][j];
            }
        }
        System.out.println(res);

    }// end of main

    public static void simulation(int d, int s) {
        //ㅊ
        isPast = new boolean[N+1][N+1];
        //1. 이동 하기
        move(d, s);
//        System.out.println(clouds);
        //2. 구름 영역 비 내리기
        //2. 초기화
        //3. 대각선 중 물 있는 칸 수 만큼 증량
        waterAdd();
        //4. 구름 삭제
        clouds.removeAll(clouds);

        //5. past 값을 제외한, 물의 양이 2 이상인 칸, 구름 생성
        create();
    }

    public static void create() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isPast[i][j] && bucket[i][j] >= 2) {
                    clouds.add(new Cloud(i, j));
                    bucket[i][j] -= 2;
                }
            }
        }
    }

    public static void waterAdd(){
        int[][] dist = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for(int index = 0; index < clouds.size(); index++) {
            Cloud cloud = clouds.get(index);
            int r = cloud.r;
            int c = cloud.c;

            int cnt = 0;
            for(int i = 0; i < 4; i++){
                int nr = r + dist[i][0];
                int nc = c + dist[i][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                    if(bucket[nr][nc] > 0){
                        cnt++;
                    }
                }
            }
            bucket[r][c] += cnt;

        }
    }

    public static void move(int d, int s) {

        for(int i = 0; i < clouds.size(); i++) {
            Cloud current = clouds.get(i);

            int nr = (current.r + ((dist[d][0] + N) * s)) % N;
            int nc = (current.c + ((dist[d][1] + N) * s)) % N;

            clouds.get(i).r = nr;
            clouds.get(i).c = nc;

            // rain()
            bucket[nr][nc]++;
            isPast[nr][nc] = true;
        }

    }

    public static class Cloud {
        int r;
        int c;

        public Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public String toString() {
            return "[r=" + r + ", c=" + c + "]";
        }
    }

}//end of class
