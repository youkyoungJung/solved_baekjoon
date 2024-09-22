import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭수
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = lowerBound(Integer.parseInt(st.nextToken()));
            int e = upperBound(Integer.parseInt(st.nextToken()));

//            System.out.println("s: " + s + " e: " + e);
            sb.append(e-s).append("\n");
        }
        System.out.println(sb);
    }
    public static int lowerBound(int target){
        int left = -1;
        int right = arr.length;

        while(left + 1 < right){
            int mid = (left + right) / 2;

            if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static int upperBound(int target){
        int left = -1;
        int right = arr.length;

        while(left+1 < right){
            int mid = (left + right) / 2;

            if(arr[mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return right;
    }
}
