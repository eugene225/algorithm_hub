import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int sum = 0; // 다리 위의 트럭의 무게
        int time = 0; // 총 시간

        for(int truck : truck_weights) {

            while(true) {

                // 다리가 빈 경우
                if(q.isEmpty()) {
                    q.offer(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if(q.size() == bridge_length) {
                    sum -= q.poll();
                }
                // 트럭 무게를 더했을 때 최대 무게 넘는 경우
                else if(sum+truck > weight) {
                    q.offer(0);
                    time++;
                }
                // 다음 트럭 무게 더해도 최대무게 안넘으면
                else{
                    q.offer(truck);
                    sum += truck;
                    time++;
                    break;
                }
            }
        }

        answer = time + bridge_length;

        return answer;
    }
}