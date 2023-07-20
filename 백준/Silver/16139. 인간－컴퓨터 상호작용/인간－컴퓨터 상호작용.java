import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int count_character [][];
    public static void main(String [] args) throws IOException {
        new Main().human_computer();
    }

    public void human_computer() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[26][input.length() + 1];
        for (int i = 0; i < 26; i++) {
            dp[i][0] = 0;
        }
        String tempChar;
        for (int i = 0; i < input.length(); i++) {
            tempChar = input.charAt(i) + "";
            int asc = tempChar.charAt(0)-97;
            dp[asc][i+1]++;
            for (int j = 0; j < 26; j++) {
                dp[j][i+1]+=dp[j][i];
            }
        }
        int[] interval = new int[2];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            tempChar = st.nextToken();
            int asc = tempChar.charAt(0)-97;
            interval[0] = Integer.parseInt(st.nextToken());
            interval[1] = Integer.parseInt(st.nextToken());
            output.append(dp[asc][interval[1]+1] - dp[asc][interval[0]] + "\n");
        }
        System.out.println(output);
    }

//    public void countAlphabet(String sequence) {
//        count_character[0][(sequence.charAt(0) - '0') - 49 ]++;
//        for(int i = 1; i < sequence.length(); i++) {
//            count_character[i] = count_character[i-1].clone();
//            count_character[i][(sequence.charAt(i) - '0') - 49] ++;
//        }
//    }
//
//    public int countAlphabetInSequence(int idx1, int idx2, String alphabet)  {
//
//
//        int alphabet_idx = alphabet.charAt(0) - '0' - 49;
//        return count_character[idx2][alphabet_idx] - count_character[(idx1 > 0) ? idx1-1 : idx1][alphabet_idx];
//    }
}
