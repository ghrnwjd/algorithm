import java.util.Arrays;

class Solution {
    public String solution(long n, String[] bans) {
        long[] bannedNums = new long[bans.length];
        for (int i = 0; i < bans.length; i++) {
            bannedNums[i] = stringToNumber(bans[i]);
        }
        
        Arrays.sort(bannedNums);
        
        for (long ban : bannedNums) {
            if (n >= ban) n++;
        }
        
        return numberToString(n);
    }
    
    private long stringToNumber(String s) {
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = num * 26 + (c - 'a' + 1); // 누적 계산으로 효율화
        }
        return num;
    }
    
    private String numberToString(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--; // 0 기반 인덱스 조정
            char c = (char) (num % 26 + 'a');
            sb.append(c);
            num /= 26;
        }
        return sb.reverse().toString();
    }
}
