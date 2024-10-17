import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(true) {
            Arrays.sort(wallet);
            Arrays.sort(bill);
            if(possibleIntoWallet(wallet, bill)) {
                break;
            }
            bill[1] /= 2;
            answer++;
        }
        return answer;
    }
    public boolean possibleIntoWallet(int [] wallet, int [] bill) {
        return wallet[0] >= bill[0] && wallet[1] >= bill[1]; 
    }
}