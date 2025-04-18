import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] lineup ;
    static boolean participant [];
    static int [][] info;
    static int N, maxScore;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 이닝 수
        N = Integer.parseInt(br.readLine());
        maxScore = 0;
        info = new int [N+1][9+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번쨰 선수는 4번타자 고정
        lineup = new int[10];
        participant = new boolean[10];
        lineup[4] = 1;
        participant[4] = true;

        confirmLineUp(2);

        System.out.println(maxScore);
    }

    public static void confirmLineUp(int players){
        if(players == 10) {
            baseball();
            return;
        }

        for(int i = 1; i < 10; i++) {
            if(!participant[i]) {
                participant[i] = true;
                lineup[i] = players;
                confirmLineUp(players + 1);
                participant[i] = false;
            }
        }
    }
    static void baseball() {
        boolean base[];
        int score = 0;
        int nowPlayer = 1;
        int outCount;
        for(int i = 1; i <= N; i++) {
            outCount = 3;
            base = new boolean[4];
            while(outCount > 0) {
                if(info[i][lineup[nowPlayer]] == 1) {
                    for(int j = 3; j > 0; j--) {
                        if(base[j]) {
                            if(j == 3) {
                                score ++;
                                base[j] = false;
                            }
                            else {
                                base[j+1] = true;
                                base[j] = false;
                            }
                        }
                    }
                    base[1] = true;
                }
                else if(info[i][lineup[nowPlayer]] == 2) {
                    for(int j = 3; j > 0; j--) {
                        if(base[j]) {
                            if (j >= 2) {
                                score++;
                                base[j] = false;
                            } else {
                                base[j + 2] = true;
                                base[j] = false;
                            }
                        }
                    }
                    base[2] = true;
                }
                else if(info[i][lineup[nowPlayer]] == 3) {
                    for(int j = 3; j > 0; j--) {
                        if(base[j]) {
                            if(j >= 1) {
                                score ++;
                                base[j] = false;
                            }
                        }
                    }
                    base[3] = true;
                }
                else if(info[i][lineup[nowPlayer]] == 4) {
                    for(int j = 3; j > 0; j--) {
                        if(base[j]) {
                            if(j >= 1) {
                                score ++;
                                base[j] = false;
                            }
                        }
                    }
                    score ++;
                }
                else if(info[i][lineup[nowPlayer]] == 0) {
                    outCount -= 1;
                }
                nowPlayer = (nowPlayer + 1 > 9) ? 1 : nowPlayer + 1;
            }
            maxScore = Math.max(maxScore, score);
        }
    }
}