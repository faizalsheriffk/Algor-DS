package graph.medium;


import java.util.Arrays;

public class RedundantConnection {


    // This is a classic find and union algorithm , memorize if you have to, it comes handy in finding the redundant connection

    private int[] par;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {

        //1 indexeed
        par = new int[edges.length+1];
        rank = new int[edges.length+1];

        int[] tpar = par;
        int[] trank = rank;

        Arrays.fill(rank,1);

        //each node is a parent to itself
        for(int i =0; i<par.length; i++){
            par[i] = i;
        }

        for(int[] edge:edges){
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[0];
    }
    //basically I messed up the find part and it took close to 2 hours to fix it.
    private int find(int n){
        int[] tpar = par;
        int[] trank = rank;

        int parent = par[n];
        while(parent!=par[parent]){
            //path compression
            par[parent] = par[par[parent]];
            parent = par[parent];
        }

        return parent;
    }


    private boolean union(int n1, int n2){
        int[] tpar = par;
        int[] trank = rank;

        int p1 = find(n1);
        int p2 = find(n2);

        if(p1==p2)
            return false;

        if(rank[p1]>rank[p2]){
            rank[p1] = rank[p1]+rank[p2];
            par[p2] = p1;

        }else {
            // if(rank[p1]<rank[p2]){
            rank[p2] = rank[p2]+rank[p1];
            par[p1] = p2;
        }
        // else{
        //      par[p2] = p1;
        //      rank[p1]++;
        // }


        return true;
    }
}


// class Solution {
//     int MAX_EDGE_VAL = 1000;

//     public int[] findRedundantConnection(int[][] edges) {
//         DSU dsu = new DSU(MAX_EDGE_VAL + 1);
//         for (int[] edge: edges) {
//             if (!dsu.union(edge[0], edge[1])) return edge;
//         }
//         throw new AssertionError();
//     }
// }

// class DSU {
//     int[] parent;
//     int[] rank;

//     public DSU(int size) {
//         parent = new int[size];
//         for (int i = 0; i < size; i++) parent[i] = i;
//         rank = new int[size];
//     }

//     public int find(int x) {
//         if (parent[x] != x) parent[x] = find(parent[x]);
//         return parent[x];
//     }

//     public boolean union(int x, int y) {
//         int xr = find(x), yr = find(y);
//         if (xr == yr) {
//             return false;
//         } else if (rank[xr] < rank[yr]) {
//             parent[xr] = yr;
//         } else if (rank[xr] > rank[yr]) {
//             parent[yr] = xr;
//         } else {
//             parent[yr] = xr;
//             rank[xr]++;
//         }
//         return true;
//     }
// }

