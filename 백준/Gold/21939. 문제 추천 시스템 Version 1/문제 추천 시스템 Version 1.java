import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> problem;
    static TreeSet<Integer> sortedSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        problem = new HashMap<>();
        sortedSet = new TreeSet<>((a, b) -> {
            int levelA = problem.get(a);
            int levelB = problem.get(b);
            if (levelA != levelB) {
                return Integer.compare(levelB, levelA); // 레벨 내림차순
            } else {
                return Integer.compare(b, a); // 문제 번호 내림차순
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int problemNum = Integer.parseInt(st.nextToken());
            int problemLevel = Integer.parseInt(st.nextToken());
            problem.put(problemNum, problemLevel);
            sortedSet.add(problemNum);
        }

        int l = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int pNum = Integer.parseInt(st.nextToken());
                    int pLevel = Integer.parseInt(st.nextToken());
                    if (problem.containsKey(pNum)) {
                        sortedSet.remove(pNum);
                    }
                    problem.put(pNum, pLevel);
                    sortedSet.add(pNum);
                    break;
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    int result = (x == 1) ? sortedSet.first() : sortedSet.last();
                    answer.append(result).append("\n");
                    break;
                case "solved":
                    int sNum = Integer.parseInt(st.nextToken());
                    if (problem.containsKey(sNum)) {
                        sortedSet.remove(sNum);
                        problem.remove(sNum);
                    }
                    break;
            }
        }
        System.out.println(answer);
    }
}
