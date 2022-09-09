package graph.medium;


import java.util.ArrayList;
import java.util.List;

public class SorroundedRegions {

    //This is a unique technique to collect the opposite of what is being asked
    public static final int[][] DIRECTIONS = {{1,0},{0,1}, {-1,0}, {0, -1}};

    public void solve(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }

        //scan to collect border cells
        int nr = board.length;
        int nc = board[0].length;

        List<int[]> borders = new ArrayList<int[]>();

        for(int r = 0; r<nr; r++){
            if(board[r][0] == 'O'){
                borders.add(new int[]{r,0});

            }

            if(board[r][nc-1] == 'O'){
                borders.add(new int[]{r, nc-1});
            }
        }

        for(int c = 0; c<nc; c++){
            if(board[0][c] == 'O'){
                borders.add(new int[]{0,c});

            }

            if(board[nr-1][c] == 'O'){
                borders.add(new int[]{nr-1, c});
            }
        }

        for(int[] pair: borders){
            dfs(pair[0], pair[1], board);
        }

        for(int r=0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(board [r][c] != 'O'){
                    continue;
                }
                board[r][c] = 'X';
            }
        }

        for(int r=0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(board [r][c] == 'T'){
                    board[r][c] = 'O';
                }

            }
        }

    }


    private void dfs(int r, int c, char[][] board){

        int nr = board.length;
        int nc = board[0].length;

        if(r<0 || r>=nr || c<0 || c>=nc){
            return;
        }

        if(board[r][c] != 'O'){
            return;
        }

        board[r][c] = 'T';


        for(int[] nP:DIRECTIONS){
            dfs(r+nP[0], c+nP[1], board);
        }
    }


}