import java.io.*;
import java.util.*;

public class Assignment4_1 {
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int map[][] = new int[N][N];

            for (int i = 0; i < M; i++) {
                  st = new StringTokenizer(br.readLine());
                  int t1 = Integer.parseInt(st.nextToken());
                  int t2 = Integer.parseInt(st.nextToken());

                  map[t2][t1] = 1;
            }

            List<Integer> subjects = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int nSubjects = Integer.parseInt(st.nextToken());
            for (int i = 0; i < nSubjects; i++) {
                  subjects.add(Integer.parseInt(st.nextToken()));
            }

            dfs(N, map, subjects);

      }

      public static void dfs(int N, int[][] map, List<Integer> subjects) {
            boolean visit[] = new boolean[N];

            Stack<Integer> stack = new Stack<>();

            for (int subject : subjects) {
                  stack.add(subject);
            }

            while (!stack.isEmpty()) {
                  int tempSubject = stack.pop();
                  for (int i = 0; i < N; i++) {
                        if (i == tempSubject) continue;
                        if (!visit[i] && map[tempSubject][i] != 0) {
                              stack.add(i);
                              visit[i] = true;
                        }
                  }
            }

            for(int i = 0; i < N; i++) {
                  if(visit[i]) {
                        System.out.print(i + " ");
                  }
            }
      }

}
