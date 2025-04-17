class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        int numLen = numbers.length;
        
        dfs(0, numLen, target, 0, numbers);
        
        return answer;
    }
    
    public static void dfs(int cnt, int numLen, int target, int now, int numbers[]) {
        
        if(cnt == numLen) {
            if(now == target) {
                answer ++;
            }
            return;
        }
        
        dfs(cnt + 1, numLen, target, now + numbers[cnt], numbers);
        dfs(cnt + 1, numLen, target, now + -1*numbers[cnt], numbers);
    }
}