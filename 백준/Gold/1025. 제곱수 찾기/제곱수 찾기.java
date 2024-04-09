import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static int N, M;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        // 입력부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                makeNumber(i, j);
            }
        }
        System.out.println(answer);
    }

    public static void makeNumber(int i, int j) {
        for(int di = -N; di < N; di++) {
            for(int dj = -M; dj < M; dj++) {
                if(di == 0 && dj == 0) continue;
                else {
                    int newX = i;
                    int newY = j;
                    int number = 0;
                    while(isBoundary(newX, newY)) {
                        number = number * 10 + map[newX][newY];
                        if(isSquared(number)) {
                            answer = Math.max(answer, number);
                        }
                        newX += di;
                        newY += dj;
                    }
                }

            }
        }
    }
    public static boolean isSquared(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
    public static boolean isBoundary(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < M;
    }
}
