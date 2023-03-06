package math.medium;

import java.util.HashSet;
import java.util.Set;

public class ZeroIndexes {

    // private Map<Integer, Integer> zeroIndexes = new HashMap<Integer, Integer>();
    private Set<IPair> zeroIndexes = new HashSet<IPair>();
    public void setZeroes(int[][] matrix) {

        int rL = matrix.length;
        int rC = matrix[0].length;
        //scan for zero indexes
        for(int r = 0; r<matrix.length; r++){
            for(int c = 0; c<matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    zeroIndexes.add(new IPair(r,c));
                }
            }
        }

        //for each index with 0 fill with 0

        for(IPair e: zeroIndexes){
            fillRow(e.row, matrix);
            fillColumns(e.column, matrix);

        }

    }

    private void fillRow(int row, int[][] m){

        for(int c = 0; c<m[0].length; c++ ){

            if(m[row][c] != 0)
                m[row][c] = 0;

        }
    }

    private void fillColumns(int col, int[][] m){

        for(int r = 0; r<m.length; r++){

            if(m[r][col] != 0)
                m[r][col] = 0;

        }
    }


}

class IPair{
    int row;
    int column;

    IPair(){

    }
    IPair(int r, int c){
        this.row = r;
        this. column = c;
    }

}
