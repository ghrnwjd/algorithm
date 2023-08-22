import java.io.*;
import java.util.*;

public class Main {

    static int dx [] = { 1, -1, 0, 0 };
    static int dy [] = { 0 , 0, -1, 1};
    static int N, M;
    public static void main(String [] args) throws IOException {
        new Main().easyShortCut();
    }

    public void easyShortCut() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean map [][] = new boolean[N][M];
        Point startPoint = null;
        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) {
                    map[i][j] = true;
                }
                if(temp == 2) {
                    startPoint = new Point(i, j);
                }
            }
        }

        int [][] shortCut = getEasyShortCut(map, startPoint);
        printEasyShortCut(shortCut);
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int [][] getEasyShortCut(boolean [][] map, Point startPoint) {
        int [][] shortCut = new int [map.length][map[0].length];

        Queue<Point> points = new LinkedList<>();
        points.add(startPoint);
        map[startPoint.x][startPoint.y] = true;

        while (!points.isEmpty()) {
            Point currentPoint = points.poll();
            for(int i = 0; i < 4; i ++) {
                int nX = currentPoint.x + dx[i];
                int nY = currentPoint.y + dy[i];

                if(isInsideArea(nX, nY)) {
                    if(!map[nX][nY]) {
                        shortCut[nX][nY] = shortCut[currentPoint.x][currentPoint.y] + 1;
                        points.add(new Point(nX, nY));
                        map[nX][nY] = true;
                    }
                }
            }
        }

        for(int i = 0; i < map.length; i ++) {
            for(int j = 0; j < map[0].length; j++) {
                if(!map[i][j]) shortCut[i][j] = -1;
            }
        }

        return shortCut;
    }

    public void printEasyShortCut(int [][] shortCut) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < shortCut.length; i++) {
            for(int j = 0; j < shortCut[0].length; j++) {
                sb.append(shortCut[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public boolean isInsideArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
