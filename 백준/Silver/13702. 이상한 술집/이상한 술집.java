import java.io.*;
import java.util.*;
public class Main {

    static int[] arr;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());
    } //end of main

    public static long binarySearch() {
        long left = 0; // 용량 최솟값
        long right = arr[arr.length - 1]+1; //용량 최댓값

        while(left + 1 < right) {
            long mid = (left + right) / 2;

            if(checked(mid)){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static boolean checked(long mid){
        int answer = 0;
        if(mid == 0) {
            if(k == 0) return true;
            else return false;
        }
        for(int i = 0; i < n; i++){
            answer += (int)arr[i] / mid;
            if(answer >= k){
                return true;
            }
        }
        return false;
    }
} //end of class
