package graph.medium;


import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private static final int[][] DIRECTIONS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {

        if(grid == null || grid.length == 0){
            return -1;
        }

        //collect all the rotten tomatoes
        //do a bfs
        //after completion of EACH LEVEL INCREMENT THE TIME -- THIS IS IMPORTANT
        // Return the time units if there are no fresh oranges else return -1

        int nr = grid.length;
        int nc = grid[0].length;
        Queue<int[]> q = new LinkedList<int[]>();
        int timeLapse = 0;
        int freshT = 0;

        //scan and collect on the grid
        for(int r = 0; r<nr; r++){
            for(int c=0; c<nc; c++){

                if(grid[r][c] == 1){
                    freshT++;

                }else if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }else{
                    continue;
                }

            }
        }

        //key is utilizing fresh tomatoes as another variable to break the q
        while(!q.isEmpty() && freshT >0){

            //traverse by level
            var len = q.size();
            for(int i = 0; i<len; i++){
                int[] cell = q.poll();

                for(int[] dir:DIRECTIONS){
                    var newR = cell[0]+ dir[0];
                    var newC = cell[1] + dir[1];

                    if(newR<0 || newR>= nr || newC<0 || newC >= nc || grid[newR][newC] == 0){
                        continue;
                    }

                    if(grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        freshT--;

                        q.offer(new int[]{newR, newC});
                    }
                }

            }

            timeLapse++;
        }

        if(freshT > 0){
            return -1;
        }else{
            return timeLapse;
        }


    }
}
