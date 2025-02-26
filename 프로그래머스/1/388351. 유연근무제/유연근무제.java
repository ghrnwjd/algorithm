class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < timelogs.length; i++) {
            int cnt = 0;
            for(int j = 0; j < 7; j++) {
                if((startday + j) % 7 == 0 || (startday + j) % 7 == 6) {
                    continue;
                }
                if(isLate(schedules[i], timelogs[i][j])) {
                    break;
                }                
                cnt ++ ;
            }
            if(cnt >= 5) {
                answer ++;
            }
        }
        return answer;
    }
    
    public boolean isLate(int hopeTime, int log) {
        int hopeTimeToMinutes = timeToMinutes(hopeTime);
        int logToMinutes = timeToMinutes(log);
        if((hopeTimeToMinutes + 10) < logToMinutes) {
            System.out.println("원래 출근 시간 : " + hopeTimeToMinutes + " 실제 출근 시간 " + logToMinutes);
        }
        
        return (hopeTimeToMinutes + 10) < logToMinutes;
    }
    
    public int timeToMinutes(int time) {
        return (int)(time / 100) * 60 + (time % 100);
    }
}