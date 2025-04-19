import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] lab;
    static List<int[]> virusCandidates;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, minTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][N];
        virusCandidates = new ArrayList<>();
        minTime = Integer.MAX_VALUE;

        // 바이러스 가능 위치(2) 수집
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virusCandidates.add(new int[]{i, j});
            }
        }

        // 조합 생성 및 시뮬레이션 실행
        generateCombinations(new ArrayList<>(), 0);
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    // M개 바이러스 조합 생성 (중복 없음)
    static void generateCombinations(List<Integer> selected, int startIdx) {
        if (selected.size() == M) {
            simulateVirusSpread(selected);
            return;
        }
        for (int i = startIdx; i < virusCandidates.size(); i++) {
            selected.add(i);
            generateCombinations(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // BFS로 바이러스 확산 시뮬레이션
    static void simulateVirusSpread(List<Integer> selected) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        int[][] timeMap = new int[N][N];
        int currentMax = 0;

        // 초기 바이러스 위치 설정
        for (int idx : selected) {
            int[] pos = virusCandidates.get(idx);
            queue.add(pos);
            visited[pos[0]][pos[1]] = true;
        }

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N 
                    && !visited[nx][ny] && lab[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    timeMap[nx][ny] = timeMap[current[0]][current[1]] + 1;
                    queue.add(new int[]{nx, ny});
                    currentMax = Math.max(currentMax, timeMap[nx][ny]);
                }
            }
        }

        // 모든 감염 가능 영역 확인
        if (checkFullInfection(visited)) {
            minTime = Math.min(minTime, currentMax);
        }
    }

    // 전체 감염 여부 검사
    static boolean checkFullInfection(boolean[][] visited) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 0 || lab[i][j] == 2) {
                    if (!visited[i][j]) return false;
                }
            }
        }
        return true;
    }
}
