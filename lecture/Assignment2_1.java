import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Assignment2_1 {
      static int n;
      // static boolean isChecked [];
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());

            int nums [] = new int [n];
            // isChecked = new boolean[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                  nums[i] = Integer.parseInt(st.nextToken());
            }

            quickSort(nums, 0, n-1);
             for(int i : nums) {
                   System.out.print(i + " ");
             }
            printMaxSum(nums);
      }
      public static void printMaxSum(int [] sortedArr) {
            // 입력크기가 최소 5이상이기때문에 배열의 크기는 5C3 = 10으로 설정
            int answerCandidates [] = new int [10];
            int sortedArrSize = sortedArr.length;
            int arrIdx = 0;
            for(int i = sortedArrSize-5; i < sortedArrSize - 2; i++) {
                  for(int j = i+1; j < sortedArrSize - 1; j++) {
                        for(int k = j+1; k < sortedArrSize; k++) {
                              answerCandidates[arrIdx ++] = sortedArr[i] + sortedArr[j] + sortedArr[k];
                        }
                  }
            }

            quickSort(answerCandidates, 0, 9);
            for(int i = 9; i >= 7; i--) {
                  System.out.print(answerCandidates[i] + " ");
            }
      }
      public static void swap(int [] nums, int idx1, int idx2) {
            int temp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
      }

      public static int partition(int[] nums, int left, int right) {

            int randomPivot = (int)( Math.random() * (right-left) ) + left ;
            int pivotValue = nums[randomPivot];

            int pivotPoint = left;

            swap(nums, randomPivot, right);

            for(int i = left; i < right; i++ ) {
                  if(nums[i] <= pivotValue) {
                        swap(nums, i, pivotPoint);
                        pivotPoint++;
                  }
            }

            swap(nums, pivotPoint, right);
            return pivotPoint;
      }

      public static void quickSort(int[] nums, int left, int right) {
            // 종료조건
            // left가 right보다 크거나 같을 때

            if (left < right) {

                  int randomPivot = partition(nums, left, right);
                  // 피봇 왼쪽 파티션
                  quickSort(nums, left, randomPivot - 1);
                  // 피봇 오른쪽 파티션
                  quickSort(nums, randomPivot + 1, right);

            }
      }
}