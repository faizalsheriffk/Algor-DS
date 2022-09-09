package graph.medium;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic{

    public final int[][] DIRECTIONS = {{-1,0},{1,0}, {0,-1}, {0,1} };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0){
            return null;
        }

        Queue<int[]> pacificQ = new LinkedList<int[]>();
        Queue<int[]> atlanticQ = new LinkedList<int[]>();
        int nr = heights.length;
        int nc = heights[0].length;

        // Populating logic you messed it up
        for(int r=0; r<nr; r++){
            pacificQ.offer(new int[]{r,0});
            atlanticQ.offer(new int[]{r, nc-1});
        }

        for(int c=0; c<nc; c++){
            pacificQ.offer(new int[]{0,c});
            atlanticQ.offer(new int[]{nr-1,c});
        }



        boolean[][] pReachable = bfs(heights, pacificQ);
        boolean[][] qReachable = bfs(heights, atlanticQ);

        List<List<Integer>> reachables = new ArrayList<>();

        for(int r=0; r<nr; r++){
            for(int c =0; c<nc; c++){
                if(pReachable[r][c] && qReachable[r][c]){
                    reachables.add(List.of(r,c));
                }
            }
        }

        return reachables;
    }

    // bfs logic is different. They do a breadth first from reachable cell.==============

    private boolean[][] bfs(int[][] heights, Queue<int[]> q){
        int nr = heights.length;
        int nc = heights[0].length;

        boolean[][] reachable = new boolean [nr][nc];

        while(!q.isEmpty()){
            int[] cell = q.poll();
            reachable [cell[0]][cell[1]] = true;
            //go in all 4 directions
            int curr = cell[0];
            int curc = cell[1];

            for(int[] dir:DIRECTIONS){
                int r = cell[0]+dir[0];
                int c = cell[1]+dir[1];

                if(r>=nr || r<0 || c<0  || c>=nc){
                    continue;
                }

                if(reachable[r][c]){
                    continue;
                }

                if(heights[r][c] < heights[curr][curc]){
                    //water won't flow in
                    continue;
                }

                q.offer(new int[]{r,c});
            }
        }
        return reachable;
    }

}



// class Solution {
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {

//         if(heights == null || heights.length == 0){
//             return null;
//         }
//         int nr = heights.length;
//         int nc = heights[0].length;

//         Map<Integer, Set<Integer>> pCord = retPacific(heights);
//         Map<Integer, Set<Integer>> aCord = retAtlantic(heights);

//         Map<Integer, Set<Integer>> visitedPCord = new HashMap<Integer, Set<Integer>>();
//         Map<Integer, Set<Integer>> visitedACord = new HashMap<Integer, Set<Integer>>();

//         Set<String> visited = new HashSet<String>();


//         for(int r = 0; r<nr; r++){
//             for(int c = 0; c<nc; c++){
//                 if(!visited.contains(r+","+c)){
//                 bfs(heights, visited, pCord, aCord, visitedPCord, visitedACord, r, c);
//                 }

//             }
//         }

//         return intersectAndTransform(visitedPCord, visitedACord);

//     }


//     private void bfs(int[][] heights, Set<String> visited, Map<Integer, Set<Integer>> pCord, Map<Integer, Set<Integer>> aCord, Map<Integer, Set<Integer>> vPCord, Map<Integer, Set<Integer>> vACord, int r, int c){

//         Queue<Integer> pQ = new LinkedList<Integer>();
//         int nr = heights.length;
//         int nc = heights[0].length;

//         visited.add(r+","+c);
//         pQ.add(r*nc+c);

//         while(!pQ.isEmpty()){
//             var curH = pQ.poll();
//             var cr = curH/nc;
//             var cc = curH%nc;
//             visited.add(cr+","+cc);

//             if(pCord.containsKey(cr) && pCord.get(cr)!=null && pCord.get(cr).contains(cc)){
//                 Set s = vPCord.getOrDefault(cr, new HashSet<Integer>());
//                 s.add(cc);

//                 vPCord.put(cr, s);
//             }


//             if(aCord.containsKey(cr) && aCord.get(cr)!=null && aCord.get(cr).contains(cc)){
//                 Set s = aCord.getOrDefault(cr, new HashSet<Integer>());
//                 s.add(cc);
//                 vACord.put(cr, s);
//             }



//             if(cr-1 >= 0 && heights[cr-1][cc] >= heights[cr][cc]){

//                 if(!visited.contains(cr-1+","+cc))
//                 pQ.add((cr-1)*nc+cc);

//                 populateReachable(pCord, aCord, vPCord, vACord, cr-1, cc,cr, cc);

//             }




//             if(cr+1 < nr && heights[cr+1][cc] >= heights[cr][cc]){

//                 if(!visited.contains(cr+1+","+cc))
//                 pQ.add((cr+1)*nc+cc);

//                 populateReachable(pCord, aCord, vPCord, vACord, cr+1, cc, cr, cc);

//             }

//             var ccminus1 = cc-1;
//             if(cc-1 >= 0 && heights[cr][cc-1] >= heights[cr][cc]){

//                 if(!visited.contains(cr+","+ccminus1))
//                 pQ.add(cr*nc+(cc-1));

//                 populateReachable(pCord, aCord, vPCord, vACord, cr, cc-1, cr, cc);

//             }

//             if(cc+1 < nc && heights[cr][cc+1] >= heights[cr][cc]){

//                 if(!visited.contains(cr+","+cc+1))
//                 pQ.add(cr*nc+(cc+1));

//                 populateReachable(pCord, aCord, vPCord, vACord, cr, cc+1, cr, cc);

//             }

//         }



//     }


//     private void populateReachable(Map<Integer, Set<Integer>>p, Map<Integer, Set<Integer>>a, Map<Integer, Set<Integer>>vP, Map<Integer, Set<Integer>>vA, int r, int c, int curR, int curC){

//          if((vP.containsKey(r) && vP.get(r)!=null && vP.get(r).contains(c))
//                    || (p.containsKey(r) && p.get(r)!=null && p.get(r).contains(c)))
//                    {
//                 Set s = vP.getOrDefault(r, new HashSet<Integer>());
//                 s.add(curC);

//                 vP.put(curR, s);
//                 }

//                 if((vA.containsKey(r) && vA.get(r)!=null && vA.get(r).contains(c))
//                    || (a.containsKey(r) && a.get(r)!=null && a.get(r).contains(c))){

//                 Set s = vA.getOrDefault(r, new HashSet<Integer>());
//                 s.add(curC);

//                 vA.put(curR, s);
//                 }


//     }


//     private Map<Integer, Set<Integer>> retPacific(int[][] heights){

//         int nr = heights.length;
//         int nc = heights[0].length;

//         Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

//         int r = 0;
//         int c=0;
//         Set<Integer> s = new HashSet<Integer>();

//         for(; c<nc; c++){
//             s.add(c);

//         }
//         map.put(r, s);

//         c=0;
//         for(; r<nr; r++){
//             s = map.getOrDefault(r, new HashSet<Integer>());
//             s.add(c);
//             map.put(r,s);
//         }

//         return map;
//     }

//      private Map<Integer, Set<Integer>> retAtlantic(int[][] heights){

//         int nr = heights.length;
//         int nc = heights[0].length;

//         Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

//         int r = nr-1;
//         int c=0;

//         Set<Integer> s = new HashSet<Integer>();
//         for(; c<nc; c++){
//             s.add(c);
//         }
//         map.put(r, s);


//         c=nc-1;
//         r = 0;


//         for(; r<nr; r++){
//             s = map.getOrDefault(r,new HashSet<Integer>());
//             s.add(c);
//             map.put(r, s);
//         }

//         return map;
//     }

//     private List<List<Integer>> intersectAndTransform(Map<Integer, Set<Integer>> a, Map<Integer, Set<Integer>> b){

//         List<List<Integer>> res = new ArrayList<>();

//         for(Map.Entry<Integer,Set<Integer>> entry : a.entrySet()){

//             if(b.containsKey(entry.getKey())){
//                 Set<Integer> eSet = entry.getValue();
//                 Set<Integer> bSet = b.get(entry.getKey());

//                 for(Integer column:bSet){
//                    if(eSet.contains(column)){
//                         List<Integer> list = new ArrayList<>();
//                         list.add(entry.getKey());
//                         list.add(column);
//                         res.add(list);
//                    }
//                 }
//             }
//         }
//         return res;
//     }
// }


