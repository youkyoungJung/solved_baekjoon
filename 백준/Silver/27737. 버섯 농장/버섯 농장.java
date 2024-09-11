import java.util.*;
import java.io.*;

public class Main {

    static class Location{
        int r;
        int c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;

        }
    }
    static int n;
    static int k;
    static int m;

    static int[][] arr;

    static int[][] way;
    static boolean[][] isVisited;
    static ArrayList<Location> mushies = new ArrayList<>();
    static ArrayList<Integer> counts = new ArrayList<>();
    static Queue<Location> queue = new ArrayDeque<>();
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //격자 크기
        m = Integer.parseInt(st.nextToken()); //m 개의 버섯 포자
        k = Integer.parseInt(st.nextToken()); // 최대 k 개의 연결된 칸
        arr = new int[n][n];
        isVisited = new boolean[n][n];

        //버섯 포자는 버섯이 자랄 수 있는 칸에만 심을 수 있음
        //한칸에 여러개 겹쳐 심을 수 있음. 최대(x * k)개

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){ //버섯이 자랄 수 있는 길
                    mushies.add(new Location(i, j));
                } else { //버섯이 못자라는 길
                    isVisited[i][j] = true;
                }
            }
        } // 입력 완료

        for(int i = 0; i < mushies.size(); i++){
            // 버섯이 자랄 수 있는 각 자리 마다 bfs
            Location mushi = mushies.get(i);
            if(!isVisited[mushi.r][mushi.c]) {
                queue.offer(new Location(mushi.r, mushi.c));
                isVisited[mushi.r][mushi.c] = true;
                counts.add(bfs());
            }
        }

        int cnt = 0;

        for (int current : counts) {
            if (current < k) {
                cnt += 1;
            } else if (current % k == 0) {
                int val = current / k;
                cnt += val;
            } else {
                int val = current / k + 1;
                cnt += val;
            }
        }

        if(cnt == 0 ||m - cnt < 0){
            sb.append("IMPOSSIBLE");
        }else{
            sb.append("POSSIBLE").append("\n").append(m-cnt);
        }

        System.out.println(sb.toString());
    } //end of main

    public static int bfs(){
        int cnt = 1;
        while(!queue.isEmpty()){
            Location current = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = current.r + dist[i][0];
                int nc = current.c + dist[i][1];

                if(checked(nr, nc)){
                    queue.offer(new Location(nr, nc));
                    isVisited[nr][nc] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    } // end of bfs

    public static boolean checked(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n && !isVisited[r][c] && arr[r][c] == 0;
    }

}//end of class