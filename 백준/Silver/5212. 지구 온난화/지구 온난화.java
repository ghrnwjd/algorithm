import com.sun.security.jgss.GSSUtil;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static char island [][];
    static char [][] island_50yearLater;
    static int dict[][] = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    static int firstY = Integer.MAX_VALUE;
    static int lastY = Integer.MIN_VALUE;
    static int firstX = Integer.MAX_VALUE;
    static int lastX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 겉 부분이 모두 바다이기 때문에 그냥 .으로 채워준다.
        island = new char [r+2][c+2];
        island_50yearLater = new char [r+2][c+2];
        for(int i = 0; i < r+2; i++) {
            Arrays.fill(island[i], '.');
            Arrays.fill(island_50yearLater[i], '.');
        }


        for(int i = 1; i <= r; i++) {
            String s = br.readLine();
            for(int j = 1; j <= c; j++) {
                char temp = s.charAt(j-1);
                if(temp == 'X') {
                    island[i][j] = 'X';
                    island_50yearLater[i][j] = 'X';
                }
            }
        }

        for(int i = 1; i <=r; i++) {
            for(int j = 1; j <= c; j++) {
                if(island[i][j] == 'X') {
                    yearLater(i, j);
                }
            }
        }

        findBoundary(r, c);


        for(int i = firstX; i <= lastX; i++) {
            for(int j = firstY; j <= lastY; j++) {
                System.out.print(island_50yearLater[i][j]);
            }
            System.out.println();
        }
    }

    static void findBoundary(int r, int c) {

        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(island_50yearLater[i][j] == 'X') {
                    firstX = Math.min(firstX, i);
                    lastX = Math.max(lastX, i);
                    firstY = Math.min(firstY, j);
                    lastY = Math.max(lastY, j);
                }
            }
        }
    }

    static void yearLater(int x, int y) {
        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int tempX = x + dict[i][0];
            int tempY = y + dict[i][1];

            if(island[tempX][tempY] == '.') {
                cnt++;
            }
            if(cnt >= 3) {
                island_50yearLater[x][y] = '.';
                return;
            }
        }
    }
}

