class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[][] dp = new boolean[n][2];
		dp[n - 1][0] = true; // 
        dp[n - 1][1] = true;
        map.put(A[n - 1], n - 1);
        int res = 1;

        for (int i = n - 2; i >= 0; i--) { // 이미 n-1Idx는 true
            // Odd step
            Integer nextGreater = map.ceilingKey(A[i]);
            if (nextGreater != null) {
                dp[i][0] = dp[map.get(nextGreater)][1];
            }
            // Even step
            Integer nextSmaller = map.floorKey(A[i]);
            if (nextSmaller != null) {
                dp[i][1] = dp[map.get(nextSmaller)][0];
            }
            map.put(A[i], i);

            res += dp[i][0] ? 1 : 0;
        }

        return res;
    }
}