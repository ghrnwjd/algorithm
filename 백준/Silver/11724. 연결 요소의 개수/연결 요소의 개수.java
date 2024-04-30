import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main
{
      static boolean visited[];
      static int N, M, ans=0;
      static int map[][];
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(M == 0) {
                  System.out.println(N);
            }
            else {
                  visited = new boolean[N+1];
                  map = new int [N+1][N+1];

                  for(int i = 0; i < M; i++) {
                        st = new StringTokenizer(br.readLine());
                        int v1 = Integer.parseInt(st.nextToken());
                        int v2 = Integer.parseInt(st.nextToken());

                        map[v1][v2] = 1;
                        map[v2][v1] = 1;
                  }

                  for(int i = 1; i <= N; i++) {
                        if(visitNode(i)) ans += 1;
                  }
                  for(int i = 1; i <=N ; i++) {
                        if(!visited[i]) ans++;
                  }
                  System.out.println(ans);
            }
      }
      static boolean visitNode(int startVertex) {
            boolean flag = false;
            for(int i = 1; i < N+1; i++) {
                  if(map[startVertex][i] == 1 && !visited[i]) {
                        visited[startVertex] = true;
                        visited[i] = true;
                        flag = true;
                        visitNode(i);
                  }
            }
            return flag;
      }
}