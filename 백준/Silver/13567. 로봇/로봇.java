import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //우, 상, 좌, 하
        int dir = 0;
        int r = 0;
        int c = 0;

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

           if(operation.equals("MOVE")){
               r = r + dist[dir][0] * num;
               c = c + dist[dir][1] * num;
//                System.out.println(r + " " + c);

               if(!checked(r, c, M)){
                   System.out.println(-1);
                   return;
               }
           }else if(operation.equals("TURN")){
               if(num == 1){
                   if(dir-1 < 0){
                       dir = 4;
                   }
                   dir = (dir-1) % 4;
               }else{
                   dir = Math.abs(dir+1) % 4;
               }
           }

        }

        System.out.println(c + " " + r);


    }   // end of main

    static boolean checked(int r, int c, int M){
        return r >= 0 && r <= M && c >= 0 && c <= M;
    }

} // end of class
