import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // B의 원소들을 정렬 상태로 관리하며 이분탐색(upper_bound) 및 삭제
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int b : B) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        for (int a : A) {
            // a보다 큰 가장 작은 키 탐색 (Upper Bound)
            Integer target = map.higherKey(a);
            
            if (target != null) {
                // a를 이길 수 있는 가장 작은 카드로 승리
                answer++;
                removeCard(map, target);
            } else {
                // 이길 수 없다면 가장 작은 카드를 버림
                removeCard(map, map.firstKey());
            }
        }
        return answer;
    }

    private void removeCard(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}