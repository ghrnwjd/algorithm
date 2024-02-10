class Solution {
    public long solution(int[] seq) {

        long ans = Long.MIN_VALUE;

        boolean isPlus = false;

        long seqStartWithPlus = 0;
        long seqStartWithMinus = 0;

        for(int num : seq) {
            seqStartWithPlus += isPlus ? num : -num;
            seqStartWithMinus += isPlus ? -num : num;

            seqStartWithPlus = Math.max(0, seqStartWithPlus);
            seqStartWithMinus = Math.max(0, seqStartWithMinus);

            ans = Math.max(ans, Math.max(seqStartWithMinus, seqStartWithPlus));

            isPlus = !isPlus;
        }

        return ans;
    }
}