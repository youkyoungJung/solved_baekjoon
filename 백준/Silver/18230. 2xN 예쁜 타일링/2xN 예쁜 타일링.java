import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static PriorityQueue<Integer> arr;
    static PriorityQueue<Integer> brr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        arr = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        brr = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            brr.add(Integer.parseInt(st.nextToken()));
        }

        int res;

        if (N % 2 == 0){ // 짝수일 경우
            res = calc();

        } else { // 홀수 일 경우.
            int fix = arr.poll();
            res = calc();
            res += fix;
        }
        System.out.println(res);
    }// end of main

    public static int calc(){
        int answer = 0;

        for(int i = 0; i < N / 2; i++){
            if(!brr.isEmpty() && arr.size() >= 2) {
                int first = arr.poll();
                int second = arr.poll();

                if (brr.peek() >= first + second) {
                    answer += brr.poll();
                    arr.add(first);
                    arr.add(second);
                } else {
                    answer += (first + second);
                }
            } else if (brr.isEmpty() && arr.size() >= 2){
                int first = arr.poll();
                int second = arr.poll();
                answer += (first + second);

            } else if (!brr.isEmpty() && arr.size() < 2){
                answer += brr.poll();
            }
        }
        return answer;
    }

}//end of class
