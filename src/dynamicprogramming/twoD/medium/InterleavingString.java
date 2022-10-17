package dynamicprogramming.twoD.medium;


import java.util.HashMap;
import java.util.Map;

// Needed some help, classic state reduction problem
public class InterleavingString {

    // The key in this problem is state reduction. It is actually a three dimensional problem with s1 index, s2 index and s3 index. The idea to s1 index and s2 index to deduce s3 index is the key

    private Map<String, Boolean> map = new HashMap<String, Boolean>();

    private String s1;
    private String s2;
    private String s3;

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length()+s2.length() != s3.length()){
            return false;
        }

        // this.s1 = s1;
//         this.s2 = s2;
//         this.s3 = s3;

//         return dp(0,0);


        //proper dp problem

        int row = s1.length()+1;
        int col = s2.length()+1;


        boolean[][] grid = new boolean[row][col];

        grid[row-1][col-1] = true;

        for(int r= row-1; r>=0; r--){
            for(int c = col-1; c>=0; c--){

                //this is a good use case where we loop the grid but we control the out of bounds situation in the ;o[=0p[=00]]
                if(r<s1.length() && s1.charAt(r) == s3.charAt(r+c) && grid[r+1][c]){
                    //s1path =  true;
                    grid[r][c] = true;
                }

                if(c<s2.length() && s2.charAt(c) == s3.charAt(r+c) && grid[r][c+1]){
                    // s2path = true;
                    grid[r][c] =true;
                }
            }
        }

        return grid[0][0];


    }


    /*
    recursive problem
    */

    private boolean dp(int i, int j)//s1index, s2index
    {
        if(i == s1.length() && j == s2.length()){
            return true;
        }

        String key = i+"_"+j;

        if(map.containsKey(key)){
            return map.get(key);
        }

        boolean s1path = false;
        boolean s2path = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j) && dp(i+1, j)){
            //s1path =  true;
            return true;
        }

        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j) && dp(i, j+1)){
            // s2path = true;
            return true;
        }

        map.put(key, false);

        return map.get(key);
    }
}