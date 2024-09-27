import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static int m;
    static int[] line;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        int dong = 0; //동근이 위치

        line = new int[k];

        for(int i = 0; i <= k; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int raw = Integer.parseInt(st.nextToken());
            int temp = 0;

            switch(dir){
                case 1:
                    temp = raw;
                    break;
                case 2:
                    temp = n + m + n - raw;
                    break;
                case 3:
                    temp = n + m + n + m - raw;
                    break;
                case 4:
                    temp = n + raw;
                    break;
            }

            if(i < k){
                line[i] = temp;
            }else{
                dong = temp;
            }
        }

        for(int i = 0; i < k; i++){
            int first = Math.abs(dong - line[i]);
            int second = Math.abs(2*n + 2*m - first);
            cnt += Math.min(first, second);
        }

        System.out.println(cnt);

    } //end of main

} //end of class
