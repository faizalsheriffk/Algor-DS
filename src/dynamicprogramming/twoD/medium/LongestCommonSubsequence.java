package dynamicprogramming.twoD.medium;

public class LongestCommonSubsequence {


        public int longestCommonSubsequence(String text1, String text2) {
            int row = text2.length();
            int col = text1.length();

            int[][] grid = new int[row+1][col+1];

            for(int r = 1; r<grid.length; r++){
                for(int c = 1; c<grid[0].length; c++){

                    // don't try to over optimize this

                    if(text2.charAt(r-1) == text1.charAt(c-1)){
                        grid[r][c] = 1+grid[r-1][c-1];
                    }else{
                        grid[r][c] = Math.max(grid[r][c-1], grid[r-1][c]);
                    }
                }
            }

            return grid[row][col];
        }

}
