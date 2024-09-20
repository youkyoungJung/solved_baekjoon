import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        // 바위 간의 거리 배열을 계산할 필요 없음, 그냥 바로 rocks 배열로 처리
        long left = 1;
        long right = distance;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (canRemoveRocks(mid, rocks, distance, n)) {
                left = mid + 1; // 더 큰 거리도 가능할 수 있음
            } else {
                right = mid - 1; // 너무 많은 바위를 제거해야 한다면 mid 값을 줄임
            }
        }
        
        return (int) right;
    }

    public boolean canRemoveRocks(long mid, int[] rocks, int distance, int n) {
        int prev = 0; // 출발점
        int removed = 0; // 제거한 바위 수
        
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - prev < mid) {
                removed++; // 거리가 mid보다 작다면 바위를 제거
            } else {
                prev = rocks[i]; // mid 이상인 경우, 이 바위는 유지
            }
            
            if (removed > n) {
                return false; // 제거한 바위가 n개를 넘으면 실패
            }
        }
        
        // 마지막 도착점까지의 거리도 확인
        if (distance - prev < mid) {
            removed++;
        }

        return removed <= n; // 제거한 바위가 n 이하이면 true 반환
    }
}
