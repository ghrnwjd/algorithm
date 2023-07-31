
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().mixTwoLiquor();
    }

    public void mixTwoLiquor() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int liqour [] = new int [N];

        for(int i = 0; i < N; i++) {
            liqour[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAnswer(N, liqour));
    }
    public int getAnswer(int N, int [] liqour) {
        int s = 0;
        int e = N-1;

        int ans = liqour[s] + liqour[e];

        while(true) {
            /* 종료조건 */
            if(liqour[s]+liqour[e]>0)e--;
            else s++;
            if(s>=e)break;
            if(Math.abs(liqour[s]+liqour[e])<Math.abs(ans)){
                ans=liqour[s]+liqour[e];
            }
        }

        return ans;
    }

    public int nearbyZero(int d1, int d2) {
        return (Math.abs(d1) > Math.abs(d2)) ? d2 : d1;
    }
}

