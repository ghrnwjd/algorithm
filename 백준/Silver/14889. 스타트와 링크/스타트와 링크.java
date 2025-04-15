import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean [] visited;
    static int [][] stat;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        StringTokenizer st;
        stat = new int [N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combination(0, 0, N);

        System.out.println(answer);
    }

    public static void combination(int members, int idx, int N) {
        if(members == N / 2) {
            diffScore(N);
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(members + 1, i + 1, N);
                visited[i] = false;
            }
        }
    }

    public static void diffScore(int N) {
        int aTeamScore = 0;
        int bTeamScore = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    aTeamScore += stat[i][j];
                    aTeamScore += stat[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    bTeamScore += stat[i][j];
                    bTeamScore += stat[j][i];
                }
            }
        }
        answer = Math.min(answer, Math.abs(aTeamScore - bTeamScore));
    }
}