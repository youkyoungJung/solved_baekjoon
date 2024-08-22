import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> tree = new HashMap<>();
        Map<Integer, Integer> speed = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree.put(i, Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            speed.put(i, Integer.parseInt(st.nextToken()));
        }

        List<Integer> keySet = new ArrayList<>(speed.keySet());
        keySet.sort((o1, o2)-> Integer.compare(speed.get(o1), speed.get(o2)));

        long answer = 0;
        int index = 0;
        while(N-- > 0){
            int targetIndex = keySet.get(0);
            answer += ((long) tree.get(targetIndex) + ((long) speed.get(targetIndex) * index));

            keySet.remove(0);
            index++;
        }

        System.out.println(answer);
    }// end of main

}//end of class
