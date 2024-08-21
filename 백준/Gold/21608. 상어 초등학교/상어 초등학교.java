import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<ArrayList<Integer>> num;
    static int[][] arr;
    static int[][] test;
    static PriorityQueue<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        test = new int[N+1][N+1];

        num = new ArrayList<>(N*N+1);
        for(int i = 0; i <= N*N; i++){
            num.add(new ArrayList<>());
        }
        int[] teacher = new int[N*N+1];

        for(int i = 1; i <= N*N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int bf1 = Integer.parseInt(st.nextToken());
            int bf2 = Integer.parseInt(st.nextToken());
            int bf3 = Integer.parseInt(st.nextToken());
            int bf4 = Integer.parseInt(st.nextToken());

            if(i == 1){
                arr[2][2] = student;
            }

            num.get(student).add(bf1);
            num.get(student).add(bf2);
            num.get(student).add(bf3);
            num.get(student).add(bf4);
            teacher[i] = student;

        }
        //1. 모든 빈칸 탐색, 자리 배치
        for(int t = 2; t <= N*N; t++) {
            int target = teacher[t];
            queue = new PriorityQueue<>();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] == 0) { // 빈칸일 경우
                        //2. 근처에 몇 명 있는지 탐색
                        int[] res = findStudent(target, i, j);
                        queue.offer(new Pair(i, j, res[0], res[1]));
                    }
                }
            }

            //3. arr 갱신
            Pair peek = queue.peek();
            arr[peek.r][peek.c] = target;
        }

        //4. 만족도 구하기
        int answer = satisfaction();
        System.out.println(answer);

    }// end of main


    public static int[] findStudent(int student, int r, int c){
        int bf = 0;
        int em = 0;

        for(int i = 0; i < 4; i++){
            int nr = r + dist[i][0];
            int nc = c + dist[i][1];

            if(checked(nr, nc)){
                if(num.get(student).contains(arr[nr][nc])){
                    ++bf;
                }
                if(arr[nr][nc] == 0){
                    ++em;
                }
            }
        }
        return new int[]{bf, em};
    }

    public static boolean checked(int nr, int nc){
        return nr > 0 && nr <= N && nc > 0 && nc <= N;
    }

    public static class Pair implements Comparable<Pair>{
        int r;
        int c;
        int bf;
        int em;
        public Pair(int r, int c, int bf, int em){
            this.r = r;
            this.c = c;
            this.bf = bf;
            this.em = em;
        }

        public int compareTo(Pair o){
            if(this.bf == o.bf){
                return Integer.compare(o.em, this.em);
            }
            return Integer.compare(o.bf, this.bf);
        }
    }

    public static int satisfaction(){
        int answer = 0;
        test = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                int target = arr[i][j];
                int[] res = findStudent(target, i, j);
                test[i][j] = res[0];
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(test[i][j] == 0){
                    answer += 0;
                }
                if(test[i][j] == 1){
                    answer += 1;
                }
                if(test[i][j] == 2){
                    answer += 10;
                }
                if(test[i][j] == 3){
                    answer += 100;
                }
                if(test[i][j] == 4){
                    answer += 1000;
                }
            }
        }
        return answer;
    }

}//end of class
