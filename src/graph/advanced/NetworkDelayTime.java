package graph.advanced;

import graph.models.Pair;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<Integer, List<Pair<Integer, Integer>>>();

        //construct adjacent list
        for(int[] edgeTime:times){
            List<Pair<Integer, Integer>> list = adjList.getOrDefault(edgeTime[0], new ArrayList<Pair<Integer,Integer>>());

            list.add(new Pair(edgeTime[1], edgeTime[2])); // edge, weight
            adjList.put(edgeTime[0], list);
        }


        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> (a.getKey() - b.getKey()));

        //add the kth node with weight

        minHeap.add(new Pair(0, k));

        Set<Integer> visited = new HashSet<Integer>();
        int time = 0;

        while(!minHeap.isEmpty()){

            Pair<Integer, Integer> node = minHeap.poll();
            var w1= node.getKey();
            var n1= node.getValue();

            if(visited.contains(n1)){
                continue;
            }

            visited.add(n1);

            time = Math.max(time, w1);

            if(adjList.get(n1) == null)
                continue;

            for(Pair<Integer, Integer> p: adjList.get(n1)){
                var w2 = p.getValue();
                var n2 = p.getKey();

                if(visited.contains(n2))
                    continue;

                minHeap.add(new Pair(w1+w2, n2));
            }
        }

        return visited.size() == n?time:-1;

    }
}
