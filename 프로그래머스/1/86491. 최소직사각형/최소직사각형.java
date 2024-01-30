class Solution {
      public int solution(int[][] sizes) {
            sizes = swap(sizes);

            int w_max = Integer.MIN_VALUE;
            int h_max = Integer.MIN_VALUE;
            for(int i = 0; i < sizes.length; i++) {
                  w_max = Math.max(w_max, sizes[i][0]);
                  h_max = Math.max(h_max, sizes[i][1]);
            }

            int answer = h_max * w_max;
            return answer;
      }

      public int [][] swap(int [][] sizes) {
            for(int i = 0; i < sizes.length; i++) {
                  if(sizes[i][1] > sizes[i][0]) {
                        int temp = sizes[i][1];
                        sizes[i][1] = sizes[i][0];
                        sizes[i][0] = temp;
                  }
            }

            return sizes;
      }
}