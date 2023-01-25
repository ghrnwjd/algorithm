import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> town[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도로 개수
        int k = Integer.parseInt(st.nextToken()); // 이 거리가 최단 거리
        int x = Integer.parseInt(st.nextToken()); // 시작 도시 번호

        town = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            town[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            town[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int distance[] = distanceAtTown(x);
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            if (distance[i] == k) {
                ans.append(i + "\n");
            }
        }

        if (ans.length() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans.toString());
        }
    }

    // 시작하는 도시 정보를 인자로 받는다.
    static int[] distanceAtTown(int x) {
        
        int distance[] = new int[n + 1];

        Queue<Integer> que = new LinkedList<>();
        que.add(x); // 시작 도시를 넣어준다.

        while(!que.isEmpty()) {
            int city = que.poll();
            // city로 부터 갈 수 있는 곳
            for(int i = 0; i < town[city].size(); i++) {
                int temp = town[city].get(i);
                if(distance[temp] == 0) { // 방문한적 없는 도시라면
                    distance[temp] = distance[city] + 1;
                    que.add(temp);
                }
            }
        }

        return distance;
    }
}

