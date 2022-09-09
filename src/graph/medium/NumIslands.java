package graph.medium;

import java.util.*;

public class NumIslands {


    public static final String COMMA = ",";

    public int numIslands(char[][] grid) {
        int islands = 0;

        if (grid == null || grid.length == 0) {
            return 0;
        }

        Set<String> visited = new HashSet<String>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == '1' && !visited.contains(r + COMMA + c)) {

                    islands++;
                    bfs(r, c, grid, visited);
                }
            }
        }

        return islands;
    }


    private void bfs(int r, int c, char[][] grid, Set<String> visited) {

        visited.add(r + COMMA + c);
        Queue<Integer> bfsQ = new LinkedList<Integer>();
        int nr = grid.length;
        int nc = grid[0].length;

        bfsQ.add(calc(r, c, nc));

        while (!bfsQ.isEmpty()) {

            int val = bfsQ.poll();

            //This formulae only works if it is column, do not send in row
            int row = retRow(val, nc);
            int col = retCol(val, nc);

            if (row - 1 >= 0) {
                if (grid[row - 1][col] == '1' && !visited.contains((row - 1) + COMMA + col)) {
                    bfsQ.add(calc(row - 1, col, nc));
                    visited.add((row - 1) + COMMA + col);
                }
            }

            if (col - 1 >= 0) {
                if (grid[row][col - 1] == '1' && !visited.contains(row + COMMA + (col - 1))) {
                    bfsQ.add(calc(row, col - 1, nc));
                    visited.add(row + COMMA + (col - 1));
                }
            }


            if (col + 1 < nc) {
                if (grid[row][col + 1] == '1' && !visited.contains(row + COMMA + (col + 1))) {
                    bfsQ.add(calc(row, col + 1, nc));
                    visited.add(row + COMMA + (col + 1));
                }
            }


            if (row + 1 < nr) {
                if (grid[row + 1][col] == '1' && !visited.contains((row + 1) + COMMA + col)) {
                    bfsQ.add(calc(row + 1, col, nc));
                    visited.add((row + 1) + COMMA + col);
                }
            }


        }

    }

    private int calc(int r, int c, int d) {
        return (r * d) + c;
    }

    private int retRow(int v, int d) {
        return v / d;
    }

    private int retCol(int v, int d) {
        return v % d;
    }


}
