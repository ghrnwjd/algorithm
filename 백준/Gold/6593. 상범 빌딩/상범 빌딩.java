
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] dx = {1, -1, 0, 0, 0, 0};
    static int [] dy = {0, 0, 1, -1, 0, 0};
    static int [] dz = {0, 0, 0, 0, 1, -1};

    static int board [][][];
    static boolean visited[][][];

    static int L,R,C;

    public static void main(String[] args) throws IOException {
        new Main().sangbumBuilding();
    }

    public void sangbumBuilding() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            board = fill30000();
            visited = new boolean[L][R][C];

            int [] startPoint = new int [3];
            int [] endPoint = new int [3];

            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String temp = br.readLine();
                    for(int k = 0; k < C; k++) {
                        char tempC = temp.charAt(k);

                        if(tempC == 'S') {
                            startPoint = new int [] { i, j, k };
                            board[i][j][k] = 0;
                            visited[i][j][k] = true;
                        }
                        else if(tempC == 'E') {
                            endPoint = new int [] { i, j, k };
                        }
                        else if (tempC == '#') {
                            visited[i][j][k] = true;
                        }
                    }
                }
                String jump = br.readLine();
            }
            
            System.out.println(getAnswer(startPoint, endPoint));

        }
    }
    public String getAnswer(int start[], int end[]) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(start);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!queue.isEmpty()) {
            int [] temp = queue.poll();
            for(int i = 0; i < 6; i++) {
                int nX = temp[0] + dx[i];
                int nY = temp[1] + dy[i];
                int nZ = temp[2] + dz[i];

                if(isIn(nX, nY, nZ) && !visited[nX][nY][nZ]) {
                    visited[nX][nY][nZ] = true;
                    board[nX][nY][nZ] = Math.min(board[temp[0]][temp[1]][temp[2]] + 1, board[nX][nY][nZ]);

                    if(nX == end[0] && nY == end[1] && nZ == end[2]) {
                        sb.append("Escaped in ").append(board[nX][nY][nZ]).append(" minute(s).");
                        return sb.toString();
                    }

                    queue.add(new int [] { nX, nY, nZ });
                }


            }


        }

        return "Trapped!";
    }

    public int [][][] fill30000 () {
        int [][][] a = new int [L][R][C];
        for(int i = 0; i < L; i++) {
            for(int j = 0; j < R; j++) {
                for(int k = 0; k < C; k++) {
                    a[i][j][k] = 30000;
                }
            }
        }

        return a;

    }

    public boolean isIn(int x, int y, int z) {
        return x >= 0 && x < L && y >= 0 && y < R && z >= 0 && z < C;
    }

}

