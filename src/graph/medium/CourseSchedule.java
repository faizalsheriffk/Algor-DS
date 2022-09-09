package graph.medium;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //construct a graph
        // run a dfs on each pre-req node to detect loop
        // if a node is doable, mark it as doable


        //This code has lots of bugs still worked checkout Course Schedule II as it is more stringent

        Map<Integer, Set<Integer>> adj = new HashMap<Integer, Set<Integer>>();

        for(int crs = 0; crs<numCourses; crs++){
            adj.put(crs, new HashSet<Integer>());
        }



        for (int[] course: prerequisites){

            Set<Integer> value = adj.get(course[0]);

            value.add(course[1]);

            adj.put(course[0], value);


        }

        Set<Integer> visited = new HashSet<Integer>();
        for(int crs = 0; crs<numCourses; crs++){
            if(!dfs(crs, adj, visited))
                return false;
            else
                continue;
        }
        return true;
    }


    private boolean dfs(int node, Map<Integer, Set<Integer>>adj, Set<Integer> visited){

        if(visited.contains(node)){
            return false;
        }


        if(adj.get(node) == null || adj.get(node).isEmpty()){
            return true;
        }else{

            //track path for each node
            visited.add(node);

            for(int preR : adj.get(node)){
                if(!dfs(preR, adj, visited)){
                    return false;
                }else{
                    adj.put(node, new HashSet<Integer>());
                }
            }

            // you do this as you do dfs on each node and it's pre req. Basically your visited set is storage to track only the current path
            visited.remove(node);
            return true;
        }
    }
}