class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        int [] alphabets = new int [26];
        
        for(int i = 0; i < skip.length(); i++) {
            alphabets[skip.charAt(i) - 97] = -1;
        }
        
        for(int i = 0 ; i < s.length(); i++) {
            int idx = s.charAt(i) - 97;
            int cnt = 0;
            while(cnt < index) {
                idx = (idx + 1) % 26;
                if(alphabets[idx] == 0) {
                    cnt ++;
                }
            }
            
            answer.append((char)(idx+97));
        }

        return answer.toString();
    }
}