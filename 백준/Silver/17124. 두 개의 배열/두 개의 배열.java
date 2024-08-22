import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
//            System.out.println("test case: " + testCase);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            int[] brr = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(brr);
            //1. A값에 대한 B값 찾기
            long sumC = 0;
            for(int i = 0; i < n; i++) {
               sumC += findElement(arr[i], brr);
            }

            sb.append(sumC).append("\n");
        }
        System.out.println(sb.toString());
    }// end of main

    public static int findElement(int target, int[] brr) {
        int left = 0;
        int right = brr.length - 1;
        int closest = brr[0];

        while(left <= right) {
            int mid = (right+left) / 2;

            //조건
            if(Math.abs(brr[mid] - target) < Math.abs(closest - target) ||
                    (Math.abs(brr[mid] - target) == Math.abs(closest - target) && brr[mid] < closest)) {
                closest = brr[mid];
            }

            if(brr[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        return closest;
    }


}//end of class
