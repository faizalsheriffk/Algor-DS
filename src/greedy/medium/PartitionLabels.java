package greedy.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    /*I was not able come up with solution but with one clue I was able to figure it out*/
    public List<Integer> partitionLabels(String s) {

        //one pass

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i <s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int currentSize = 0;

        int end = 0;


        for(int i = 0; i <s.length(); i++){

            end = Math.max(end, map.get(s.charAt(i)));


            currentSize++;

            if(i == end){
                result.add(currentSize);
                currentSize = 0;

            }

        }

        return result;
    }
}
