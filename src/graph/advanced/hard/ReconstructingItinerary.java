package graph.advanced.hard;

import java.util.*;

public class ReconstructingItinerary {
    LinkedHashMap<String, List<String>> adjMap = new LinkedHashMap<String, List<String>>();

    List<String> res = new ArrayList<String>();
    //List<Integer> visited = new ArrayList<Integer>();

    public List<String> findItinerary(List<List<String>> tickets) {

        if(tickets == null || tickets.size() == 0){
            return null;
        }




        for(List<String> pair:tickets){

            var valL = adjMap.getOrDefault(pair.get(0), new ArrayList<String>());

            valL.add(pair.get(1));

            adjMap.put(pair.get(0), valL);


        }

        //sort the adjacent map


        for (Map.Entry<String, List<String>> entry : this.adjMap.entrySet()) {

            Collections.sort(entry.getValue());
        }


        dfs("JFK");
        //sort tickets by pair, Collections.sort(tickets) will do teh trick
        // use a linked hash map with a list as value to itearate

        //len of res == tickets.size it is true
        //it is false if src is not in adj - no outgoing
        //dfs into the adj list of each source node

        //
        return this.res;
    }


    private boolean dfs(String src){

        if(res.size() == adjMap.size()){
            return true;
        }

        if(this.adjMap.get(src).size() == 0){
            return false;
        }

        List<String> copy = new ArrayList<String>();
        List<String> org = adjMap.get(src);
        copy.addAll(org);

        for(int i = 0; i< org.size(); i++){
            var val = org.get(i);
            this.res.add(val);
            org.remove(i);

            if(dfs(val))
                return true;
            else{
                //backtrack
                this.res.remove(val);
                org.add(i, val);
            }

        }
        return false;
    }


}
