class Solution {
    /*
    dfs
        research what is what.
    */
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int longest = 0;
        int[][] memo = new int[rows][cols];
        
        for(int r=0; r< rows; r++){
            for(int c=0; c< cols; c++){
                longest = Math.max(longest, dfs(r,c, matrix, memo));
            }
        }
        return longest;
    }
    
    public int[] rDir = new int[]{0,0,1,-1};
    public int[] cDir = new int[]{1,-1,0,0};
        
    public int dfs(int r, int c, int[][] matrix, int[][]memo){
        if(memo[r][c] !=0)
            return memo[r][c];
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int longestPath = 1;
        
        for(int i=0; i<4; i++){
            int newR = r+rDir[i];
            int newC = c+cDir[i];
            
            if(newR>=0 && newR< rows && newC>=0 && newC< cols && matrix[r][c] < matrix[newR][newC])
                longestPath = Math.max(longestPath, (dfs(newR, newC, matrix, memo)+1));
            
            memo[r][c] = longestPath;
        }
        return memo[r][c];
    }
}