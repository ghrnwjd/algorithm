import java.util.*;
import java.io.*;

public class Main {

	static int pascalTriangle[][] = new int[30][30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int W = Integer.parseInt(st.nextToken());

		makePascalTriangle();
		System.out.println(getSum(R, C, W));
	}

	public static int getSum(int R, int C, int W) {
		int sum = 0;
		int cnt = 0;

		for (int i = R; i < R + W; i++) {
			for (int j = 0; j <= cnt; j++) {
				sum += pascalTriangle[i][C + j];
			}
			cnt++;
			if(cnt == W) {
				break;
			}
		}

		return sum;
	}

	public static void makePascalTriangle() {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					pascalTriangle[i][j] = 1;
				} else {
					pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
				}
			}
		}
	}

}
