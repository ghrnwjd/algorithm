import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;
	static char[][] temp_board;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		board = new char[N][N];
		temp_board = new char[N][N];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < temp.length(); j++) {
				board[i][j] = temp.charAt(j);
				temp_board[i][j] = temp.charAt(j);
			}
		}

		switchCandy();
		System.out.println(ans);
	}


	public static void switchCandy() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// 바꾸지 않았을 때
				maxCandy_Row(i, j);
				maxCandy_Col(i, j);

				// 가로로 교환
				if (j < board.length - 1) {
					if (temp_board[i][j] != temp_board[i][j + 1]) {
						temp_board[i][j + 1] = board[i][j];
						temp_board[i][j] = board[i][j + 1];

						maxCandy_Col(i, j + 1);
						maxCandy_Col(i, j);
						maxCandy_Row(i, j);

						// 복구
						temp_board[i][j + 1] = board[i][j + 1];
						temp_board[i][j] = board[i][j];
					}
				}
				// 세로로 교환
				if (i < board.length - 1) {
					if (temp_board[i][j] != temp_board[i + 1][j]) {
						temp_board[i + 1][j] = board[i][j];
						temp_board[i][j] = board[i + 1][j];

						maxCandy_Col(i, j);
						maxCandy_Row(i + 1, j);
						maxCandy_Row(i, j);

						// 복구
						temp_board[i + 1][j] = board[i + 1][j];
						temp_board[i][j] = board[i][j];
					}
				}
				if (ans == board.length) {
					return;
				}
			}
		}
	}

	public static void maxCandy_Row(int x, int y) {
		// 가로축 확인
		int count = 0;
		char temp = temp_board[x][0];
		for (int i = 0; i < board.length; i++) {
			if (temp_board[x][i] == temp) {
				count++;

			} else {
				ans = (ans > count) ? ans : count;
				temp = temp_board[x][i];
				count = 1;
			}
		}

		ans = (ans > count) ? ans : count;

	}

	public static void maxCandy_Col(int x, int y) {
		// 세로축 확인
		char temp = temp_board[0][y];
		int count = 0;

		for (int i = 0; i < board.length; i++) {
			if (temp_board[i][y] == temp) {
				count++;
			} else {
				ans = (ans > count) ? ans : count;
				temp = temp_board[i][y];
				count = 1;
			}
		}
		ans = (ans > count) ? ans : count;
	}

}
