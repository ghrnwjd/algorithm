import java.util.*;
class Solution {
    static List<Integer> collatz;

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        collatz = new ArrayList<>();
        makeCollatzNums(k);
        
        int collatzLength = collatz.size() - 1;
        double area [] = new double [collatzLength];
            
        for(int i = 0; i < collatzLength; i++) {
            area[i] = (collatz.get(i) + collatz.get(i+1)) / 2.0;
        }
        
        for(double d : area) {
            System.out.print(d + " ");
        }
        
        double tempArea;
        for(int i = 0; i < ranges.length; i++) {
            int s = ranges[i][0];
            int e = collatzLength + ranges[i][1];
            
            tempArea = 0.0;
           
            if(s > e) {
                answer[i] = -1.0;
            }
            else { 
                for(int j = s; j < e; j++) {
                    tempArea += area[j];
                }
                answer[i] = tempArea;
            }
            
        }      
        

        
        return answer;
    }
    
    public void makeCollatzNums(int N) {
        
        collatz.add(N);
        
        if(N == 1) return;
        
        if(N % 2 == 0) {
            makeCollatzNums(N / 2);
        } 
        else {
            makeCollatzNums(N * 3 + 1);
        }
    }
}