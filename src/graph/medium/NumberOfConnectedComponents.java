package graph.medium;


import java.util.Arrays;

public class NumberOfConnectedComponents {




    // This is a classic find and union algorithm , memorize if you have to, it comes handy in finding the redundant connection

    private int[] par;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {

        //1 indexeed
        par = new int[n];
        rank = new int[n];

        int[] tpar = par;
        int[] trank = rank;

        Arrays.fill(rank,1);

        //each node is a parent to itself
        for(int i =0; i<par.length; i++){
            par[i] = i;
        }
        int res = n;
        for(int[] edge:edges){
            res = res-union(edge[0], edge[1]);
        }

        return res;
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


    private int union(int n1, int n2){
        int[] tpar = par;
        int[] trank = rank;

        int p1 = find(n1);
        int p2 = find(n2);

        if(p1==p2)
            return 0;

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


        return 1;
    }

}