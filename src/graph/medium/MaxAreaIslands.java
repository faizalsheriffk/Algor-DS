package graph.medium;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxAreaIslands {


    public int maxAreaOfIsland(int[][] grid) {

        if(grid == null){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int maxArea = 0;

        Set<Integer> visited = new HashSet<Integer>();

        for(int r = 0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(grid[r][c] == 1 && !isVisited(visited, r, c, nc)){
                    visited.add(r*nc+c);

                    maxArea = Math.max(maxArea, traverseBFS(grid, r, c, visited));
                }
            }
        }
        return maxArea;
    }

    private int traverseBFS(int[][] grid, int r, int c, Set<Integer> visited){
        int curMaxArea = 0;
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        int nr = grid.length;
        int nc = grid[0].length;

        visited.add(r*nc+c);
        bfsQueue.add(r*nc+c);
        curMaxArea++;


        while(!bfsQueue.isEmpty()){
            var val = bfsQueue.poll();

            int cr = val/nc;
            int cc = val%nc;

            if(cr-1>=0 && grid[cr-1][cc] == 1 && !isVisited(visited, cr-1,cc,nc)){
                curMaxArea++;
                visited.add((cr-1)*nc+cc);
                bfsQueue.add((cr-1)*nc+cc);
            }

            if(cr+1 < nr && grid[cr+1][cc] == 1 && !isVisited(visited, cr+1,cc,nc)){
                curMaxArea++;
                visited.add((cr+1)*nc+cc);
                bfsQueue.add((cr+1)*nc+cc);
            }
            if(cc-1>=0 && grid[cr][cc-1] == 1 && !isVisited(visited, cr,cc-1, nc)){
                curMaxArea++;
                visited.add(cr*nc+(cc-1));
                bfsQueue.add(cr*nc+(cc-1));
            }
            if(cc+1<nc && grid[cr][cc+1] == 1 && !isVisited(visited, cr,cc+1, nc)){
                curMaxArea++;
                visited.add(cr*nc+(cc+1));
                bfsQueue.add(cr*nc+(cc+1));
            }

        }

        return curMaxArea;
    }


    private boolean isVisited(Set<Integer> visited, int r, int c, int d){
        var val= r*d+c;
        return visited.contains(val);

    }
}