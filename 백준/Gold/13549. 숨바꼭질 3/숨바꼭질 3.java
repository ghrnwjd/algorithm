import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int way [] = new int [100001];

    public static void main(String [] args) throws IOException {
        new Main().hideAndSeek();
    }

    public void hideAndSeek() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(getAnswer(N, K));

    }

    public int getAnswer(int sPoint, int ePoint) {
        boolean visited[] = new boolean[100001];
        visited[sPoint] = true;
        way[sPoint] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(sPoint);

        while (!que.isEmpty()) {
            int currentPoint = que.poll();

            int tPoint1 = currentPoint * 2;
            int tPoint2 = currentPoint - 1;
            int tPoint3 = currentPoint + 1;

            if(isIn(tPoint1) && !visited[tPoint1]) {
                que.add(tPoint1);
                visited[tPoint1] = true;
                way[tPoint1] = way[currentPoint];
            }
            if(isIn(tPoint2) && !visited[tPoint2]) {
                que.add(tPoint2);
                visited[tPoint2] = true;
                way[tPoint2] = way[currentPoint] + 1;
            }
            if(isIn(tPoint3) && !visited[tPoint3]) {
                que.add(tPoint3);
                visited[tPoint3] = true;
                way[tPoint3] = way[currentPoint] + 1;
            }

            if(tPoint1 == ePoint || tPoint2 == ePoint || tPoint3 == ePoint) {
                break;
            }
        }

        return way[ePoint];
    }

    public boolean isIn(int point) {
        return point >= 0 && point < 100001;
    }

}
