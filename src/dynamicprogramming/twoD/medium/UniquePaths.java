package dynamicprogramming.twoD.medium;

public class UniquePaths  {
    /**
     * I was able to solve this proble,
     */
    public int uniquePaths(int m, int n) {

        int row = m+1;
        int col = n+1;

        int[][] grid = new int[row][col];

        grid[m-1][n-1] = 1;//right most corner

        for(int r=m-1; r>=0; r--){
            for(int c=n-1; c>=0; c--){
                //recurrence relation coming up with this challenging
                grid[r][c] = grid[r][c]+grid[r+1][c]+grid[r][c+1];
            }
        }

        return grid[0][0];
    }
}