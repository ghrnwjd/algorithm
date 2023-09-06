import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

      static int [][] map;
      static int N, M;
      public static void main(String[] args) throws IOException {
            new Main().kevinBacon();
      }

      public void kevinBacon() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int [N+1][N+1];

            for(int i = 1; i <= N; i++) {
                  for(int j = 1; j <= N; j++) {
                        if(i != j) {
                              map[i][j] = 100000;
                        }
                  }
            }

            for(int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int t1 = Integer.parseInt(st.nextToken());
                  int t2 = Integer.parseInt(st.nextToken());

                  map[t1][t2] = map[t2][t1] =1;
            }

            bacon();
            int min = Integer.MAX_VALUE;
            int idx= 0;
            for(int i = 1; i <= N; i++) {
                 int sum = 0;
                 for(int j = 1; j <= N; j++) {
                       sum += map[i][j];
                 }
                 if(min > sum) {
                       min = sum;
                       idx = i;
                 }
            }
            System.out.println(idx);
      }

      public void bacon() {
           for(int i = 1; i <= N; i++ ) {
                  for(int j = 1; j <= N; j++) {
                        for(int k = 1; k <= N; k++) {
                              map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                        }
                  }
           }
      }
}