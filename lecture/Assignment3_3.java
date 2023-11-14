import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Assignment3_3 {

      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int upper_root [] = new int [n+1];
            int down_root [] = new int [n+1];
            int up2down[] = new int [n];
            int down2up[] = new int [n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n+1; i++) {
                  upper_root[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                  up2down[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n+1; i++) {
                  down_root[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                  down2up[i] = Integer.parseInt(st.nextToken());
            }

            int dp_table [][] = new int [2][n+1];
            dp_table[0][0] = Math.min(upper_root[0], down_root[0] + down2up[0]);
            dp_table[1][0] = Math.min(down_root[0], upper_root[0] + up2down[0]);

            for(int i = 1; i < n; i++) {
                  dp_table[0][i] = Math.min(dp_table[0][i-1] + upper_root[i], dp_table[1][i-1] + down_root[i] + down2up[i]);
                  dp_table[1][i] = Math.min(dp_table[1][i-1] + down_root[i], dp_table[0][i-1] + upper_root[i] + up2down[i]);
            }

            System.out.println(Math.min(dp_table[0][n-1] + upper_root[n], dp_table[1][n-1] +down_root[n]));

      }
}
