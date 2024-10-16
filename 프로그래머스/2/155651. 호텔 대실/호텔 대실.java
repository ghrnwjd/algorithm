import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int room [] = new int [60 * 24];
                
        for(int i = 0; i < book_time.length; i++) {
            int startTime = timeTominutes(book_time[i][0]);
            int endTime = Math.min(1439, timeTominutes(book_time[i][1]) + 10);  
            
            for(int j = startTime; j < endTime; j++) {
                room[j] ++;
            }
        }      
        
        return Arrays.stream(room).max().getAsInt();
    }
    
    public int timeTominutes(String time) {
        int [] hourMinutes = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        
        return Math.min(hourMinutes[0] * 60 + hourMinutes[1], 1439);
    }
}