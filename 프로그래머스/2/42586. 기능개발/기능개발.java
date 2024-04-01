import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<int []> que = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            que.add(new int [] {progresses[i], speeds[i]});
        }
        
        while(true) {
            int tempAnswer = 0;
            int tempQueSize = que.size();
            // 하루 이후 진도율 체크
            for(int i = 0; i < tempQueSize; i++) {
                int temp [] = que.poll();
                que.add(new int [] {temp[0] + temp[1], temp[1]});
            }
            // 100% 체크
            for(int i = 0; i < tempQueSize; i++) {
                int temp[] = que.peek();
                if(temp[0] >= 100) {
                    tempAnswer += 1;
                    que.poll();
                }
                else {
                    break;
                }
            }
            if(tempAnswer > 0)
                answer.add(tempAnswer);
            if(que.isEmpty())
                break;
        }


        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}