package graph.medium;


import java.util.Arrays;

public class GraphValidTree {

    int[] par;
    int[] rank;

    public boolean validTree(int n, int[][] edges) {

        par = new int[n];
        rank = new int[n];

        Arrays.fill(rank,1);

        for(int i=0; i<n; i++){
            par[i] = i;
        }

        var cnt = n;
        var res = 0;
        for(int[] edge: edges){
            res = union(edge[0], edge[1]);
            if(res == 0){
                return false;
            }

            cnt = cnt - res;
        }

        return cnt == 1;
    }


    private int find(int n){
        var p = par[n];

        while(p!= par[p]){
            par[p] = par[par[p]];
            p = par[p];

        }

        return p;
    }

    private int union(int n1, int n2){
        var p1 = find(n1);
        var p2 = find(n2);

        if(p1 == p2) // loop found
            return 0;

        else if(rank[p1] < rank[p2]){
            par[p1] = p2;
            rank[p2] = rank[p2]+rank[p1];
        }else{
            par[p2] = p1;
            rank[p1] = rank[p1]+rank[p2];
        }
        return 1;
    }
}