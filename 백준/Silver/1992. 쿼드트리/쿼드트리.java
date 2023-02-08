import java.util.*;
import java.io.*;

public class Main {
    static int board[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int [n][n];
        // 순서 좌상, 우상, 좌하, 우하
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        printTree(0, 0, n);
        System.out.println(sb.toString());
    }
    // step1 원래 사이즈에서 반을 나눈다.
    // size/2 로 좌상, 우상, 좌하, 우하를 탐색한다.

    /**
     *
     * @param x 시작 x 인덱스
     * @param y 시작 y 인덱스
     * @param size n/2
     */
    static boolean searchTree(int x, int y, int size) {
        // 첫번쨰 인덱스 정보 저장
        int temp = board[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(board[i][j] != temp) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printTree(int x, int y, int size) {
        if(searchTree(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }
        // else
        sb.append("(");
        // 좌상
        printTree(x, y, size / 2);
        // 우상
        printTree(x, y+size/2, size/2);
        // 좌하
        printTree(x+size/2, y, size/2);
        // 우하
        printTree(x+size/2, y+size/2, size/2);
        sb.append(")");
    }
}

