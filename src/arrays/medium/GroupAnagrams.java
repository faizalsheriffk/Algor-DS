package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    private List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0){
            return null;
        }

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        /**
         * When using generics match the internal generic pn the left with right
         */
        List<List<String>> anagramList = new ArrayList<List<String>>();

        String key = "";
        List<String> val = null;
        char[] cArray = null;

        for(String s:strs){
            cArray = s.toCharArray();
            Arrays.sort(cArray);
            key = new String (cArray);
            val = map.getOrDefault(key, new ArrayList<String>());
            val.add(s);
            map.put(key, val);
        }

        for(List<String> vals:map.values()){
            anagramList.add(vals);
        }

        return anagramList;

    }

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagrams().groupAnagrams(strs);
    }
}
