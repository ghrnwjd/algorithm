import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().matrix();
	}
	
	public void matrix() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int rowIdx = n - 2;
		int colIdx = m - 2;
		
		int [][] before = new int [n][m];
		int [][] end = new int [n][m];
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < temp.length(); j++) {
				before[i][j] = temp.charAt(j) - '0';
			}
		}

		
		for(int i = 0; i < n; i++) {
			String temp = br.readLine();
			for(int j = 0; j < temp.length(); j++) {
				end[i][j] = temp.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < rowIdx; i++) {
			for(int j = 0; j < colIdx; j++) {
				if(before[i][j] != end[i][j]) {
					changeMatrix(before, i, j);
					ans++;
				}
			}
		}
		

		if(isSame(before, end)) {
			System.out.println(ans);
		}
		else {
			System.out.println(-1);
		}
		
	}
	
	public void changeMatrix(int [][] matrix, int x, int y) {
		
		for(int i = x; i <= x+2; i++) {
			for(int j = y; j <= y+2; j++) {
				matrix[i][j] = (matrix[i][j] == 0) ? 1 : 0;
			}
		}		
	
	}
	
	public boolean isSame(int [][] mat1, int [][] mat2) {
		for(int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				if(mat1[i][j] != mat2[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
