import java.io.*;
import java.util.*;
public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long left = 0;
        long right = arr[n-1];
        long answer = Long.MIN_VALUE;

        while(left < right) {
            long sum = 0;
            long mid = (left + right) / 2;

            //갱신을 못하면 right를 줄이기
            for(int i = 0; i < n; i++){
                if(arr[i] - mid > 0){
                    sum += (arr[i] - mid);
                }
            }

            if(sum >= m){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(answer);
    } //end of main
} //end of class
