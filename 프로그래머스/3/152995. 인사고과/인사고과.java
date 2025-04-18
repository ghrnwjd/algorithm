import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        
        int a = scores[0][0];
        int b = scores[0][1];
        
        int sum = a + b;
        
        // 근무태도 내림차순, 근무태도가 같다면 동료 평가 오름차순
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1]; 
            }
            return o2[0] - o1[0]; 
        });
        
        int temp = 0;
        for(int [] score : scores) {
            // 완호보다 근무태도, 동료평가가 높은 사람이 있다면
            if(score[0] > a && score[1] > b) {
                return -1;
            }
            
            if(score[1] >= temp) {
                temp = score[1];
                if(score[0] + score[1] > sum) {
                    answer ++;                
                }
            }
            
        }

        return answer;
    }
}