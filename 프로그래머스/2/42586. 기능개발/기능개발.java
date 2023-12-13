import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    int[] answer = {};
        Stack<Integer> stack = new Stack();

        // 작업일
        for (int i = progresses.length - 1; i >= 0; i--) {
            double speed = speeds[i];
            stack.push((int) Math.ceil((100 - progresses[i]) / speed));
        }

        // 배포 갯수
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            int count = 1;
            if (stack.size() == 1) {
                result.add(count);
                break;
            }
            int pop = stack.peek();
            while (stack.pop() >= stack.peek() || pop >= stack.peek()) {
                count++;
                if (stack.size() == 1) {
                    stack.clear();
                    break;
                }
            }
            result.add(count);
        }

        answer = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            answer[j] = result.get(j);
        }

        return answer;
    }
}