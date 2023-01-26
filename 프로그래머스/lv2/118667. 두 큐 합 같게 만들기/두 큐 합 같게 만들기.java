import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 접근 방법: 큐의 합이 더 큰것에서 pop한다
        int answer = -1;
        
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        // queue1의 합 구하기
        long sumQ1 = 0L;
        for(int temp : queue1) {
            sumQ1 += temp;
            que1.add(temp);
        }
        
        // queue2의 합 구하기
        long sumQ2 = 0L;
        for(int temp : queue2) {
            sumQ2 += temp;
            que2.add(temp);
        }
       
        while(true) {
            answer++;
             // 두개의 큐의 합이 홀수라면 합이 같을 수 없다
            if((sumQ1 + sumQ2) % 2 != 0) {
                return -1;
            }
            // 어느 큐 하나가 비었다면 합이 같을 수 없다.
            if(que1.isEmpty() || que2.isEmpty()) {
                return -1;
            }
            // 최대 이동 횟수를 정해둔다.
            if(answer > queue1.length * 4) {
                return -1;
            }
            if(sumQ1 == sumQ2) {
                break;
            }
            else if (sumQ1 > sumQ2) {                
                int temp = que1.poll();
                sumQ1 -= temp;
                que2.add(temp);
                sumQ2 += temp;
            }
            else{
                int temp = que2.poll();
                sumQ2 -= temp;
                que1.add(temp);
                sumQ1 += temp; 
            }
            
        }
        
        return answer;
    }
}