import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int [] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
            
        return min + " " + max;
    }
}