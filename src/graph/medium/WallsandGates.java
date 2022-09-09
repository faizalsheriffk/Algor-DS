package graph.medium;


//This is a working solution with an additional space complexity of a set that holds the visited coordinates
//class Solution {
//     public void wallsAndGates(int[][] rooms) {

//         if(rooms == null || rooms.length == 0){
//             return;
//         }

//         //collect all the nodes with gates

//         int nr = rooms.length;
//         int nc = rooms[0].length;

//         Queue<int[]> q = new LinkedList<int[]>();
//         Set<String> visited = new HashSet<String>();
//         for(int r=0; r<nr; r++){
//             for(int c = 0; c<nc; c++){
//                 if(rooms[r][c] == 0){
//                     //gate
//                     q.offer(new int[] {r,c});
//                     visited.add(r+","+c);
//                 }

//             }
//         }

//         bfs(q, rooms, visited);
//     }

//     private void bfs(Queue<int[]> q, int[][] rooms, Set<String> visited){

//         int dist = 0;
//         int nr = rooms.length;
//         int nc = rooms[0].length;

//         while(!q.isEmpty()){

//             int len = q.size();

//             //traversing this length signifies, traversing levelwise which translated to traversing gates
//             for(int i = 0; i<len; i++){
//             int[] cell = q.poll();
//             int r = cell[0];
//             int c = cell[1];

//             rooms[r][c] = dist;

//             addRoom(r+1,c,q,visited,dist, rooms);
//             addRoom(r-1,c,q,visited,dist, rooms);
//             addRoom(r,c-1,q,visited,dist, rooms);
//             addRoom(r,c+1,q,visited,dist, rooms);


//             }
//             //after completon of each level increment the value
//             dist++;
//         }

//     }

//     private void addRoom(int r, int c, Queue<int[]> q, Set<String> visited, int dist, int[][] rooms){

//           int nr = rooms.length;
//         int nc = rooms[0].length;

//         if(r<0 || r>= nr || c<0 || c >= nc || rooms[r][c] == -1 || visited.contains(r+","+c)){
//             return;
//         }

//         q.offer(new int[]{r,c});
//         visited.add(r+","+c);
//     }
// }



//comprehsive solution relying on BFS
// One that that is not obvious in this solution is each gate is not fully searched before moving on to a new gate. Each gate only looks at the areas within 1 space before we check the next gate. So each area within one space of the gates are checked for rooms and these rooms are marked, then added to the queue. Once all gates are checked, each new space is checked, and so forth. So, once a room gets hit, it has to be from the closest gate rooms[r][c] != EMPTY  and  rooms[r][c] = rooms[row][col] + 1 is the key

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {


    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0, -1}};


    public void wallsAndGates(int[][] rooms) {
        if(rooms == null){
            return;
        }

        //collect the coordinates with gates

        int nr = rooms.length;
        int nc = rooms[0].length;
        Queue<int[]> q = new LinkedList<int[]>();

        for(int r = 0; r<nr; r++){
            for(int c=0; c<nc; c++){
                if(rooms[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        while(!q.isEmpty()){
            int cell[]  = q.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction:DIRECTIONS){
                int r = direction[0]+row;
                int c = direction[1]+col;

                if(r<0 || r == nr || c == nc || c <0 || rooms[r][c]!= Integer.MAX_VALUE){
                    continue;
                }

                rooms[r][c] = rooms[row][col]+1;
                q.offer(new int[]{r,c});

            }
        }


    }
}