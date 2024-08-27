import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 사진틀의 개수
        K = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천 수

        ArrayList<Recommend> list = new ArrayList<>(N);
        Recommend[] student = new Recommend[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(st.nextToken()); //추천 받을 순서

            if(student[num] != null){
                student[num].voteCnt++;
            }else{
                Collections.sort(list);

                if(list.size() == N){
                    Recommend current = list.remove(N-1);
                    student[current.num] = null;
                }

                student[num] = new Recommend(num, i, 1);
                list.add(student[num]);
            }
        }

        Collections.sort(list, (o1, o2)-> Integer.compare(o1.num, o2.num));
        StringBuilder sb = new StringBuilder();
        for (Recommend s : list) {
           sb.append(s.num).append(" ");
        }
        System.out.println(sb);

    }//end of main

    public static class Recommend implements Comparable<Recommend>{
        int num;
        int order;
        int voteCnt;

        public Recommend(int num, int order, int voteCnt){
            this.num = num;
            this.order = order;
            this.voteCnt = voteCnt;
        }

        public String toString(){
            return "[num: " + num
                    + " , order: " + order + ", voteCnt: " + voteCnt+"]";
        }

        public int compareTo(Recommend o){

            if(this.voteCnt == o.voteCnt){
                return Integer.compare(o.order, this.order);
            }
            return Integer.compare(o.voteCnt, this.voteCnt);
        }

    }


}//end of class
