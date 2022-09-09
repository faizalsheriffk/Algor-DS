package graph.medium;


import java.util.*;

public class CourseSchedule2 {

    private Set<Integer> result = new LinkedHashSet<Integer>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //construct a graph
        // run a dfs on each pre-req node to detect loop
        // if a node is doable, mark it as doable

        Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();

        for (int[] course: prerequisites){

            Set<Integer> value = adj.getOrDefault(course[1], new HashSet<Integer>());

            value.add(course[0]);

            adj.put(course[1], value);


        }

        Set<Integer> visited = new HashSet<Integer>();
        for(int crs = 0; crs<numCourses; crs++){
            if(!dfs(crs, adj, visited))
                return new int[0];
            else
                continue;
        }
        return result.stream().mapToInt(i->i).toArray();
    }


    private boolean dfs(int node, Map<Integer, Set<Integer>>adj, Set<Integer> visited){

        if(visited.contains(node)){
            return false;
        }


        // if(adj.get(node) == null || adj.get(node).isEmpty()){
        //     result.add(node);
        //     return true;
        // }else{

        //track path for each node
        visited.add(node);

        for(int preR : adj.get(node)){
            if(!dfs(preR, adj, visited)){
                return false;
            }else{
                adj.put(node, new HashSet<Integer>());
                result.add(node);
            }
        }

        // you do this as you do dfs on each node and it's pre req. Basically your visited set is storage to track only the current path
        visited.remove(node);
        return true;
        // }

    }
}