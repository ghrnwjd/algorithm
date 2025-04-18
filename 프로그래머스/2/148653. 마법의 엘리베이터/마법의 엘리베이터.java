class Solution {
    public int solution(int storey) {
        int answer = 0;
       
        while(storey > 0) {
            int divideTen = storey % 10;
            if(divideTen == 5) {
                if((storey % 100) >= 50) {
                    answer += (10 - divideTen);
                    storey += 10;
                }
                else {
                    answer += divideTen;
                }  
            }
            else if(divideTen < 5) {
                answer += divideTen;
            }
            else if(divideTen > 5) {
                answer += (10 - divideTen);
                storey += 10;
            }
            storey /= 10;
        }
        
        return answer;
    }
}