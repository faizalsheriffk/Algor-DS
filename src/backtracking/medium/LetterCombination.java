package backtracking.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    //Map of number to sting
    public List<String> letterCombinations(String digits) {

        //loop through digits
        //look up string value to the digit
        //
        //call function sned emptylist, list of
        final Map<String, String> map = new HashMap<String, String>();
        //construct the static map;
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");


        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();

        List<String> letterCombination = new ArrayList<String>();
        for (int i = 0; i<digits.length(); i++){

            letterCombination = genLetterCombination(map.get(digits.charAt(i)+""), letterCombination);
        }
        return letterCombination;
    }


    private List<String> genLetterCombination(String val, List<String> lc){
        List<String> letterCombination = new ArrayList<String>();

        for(int i = 0; i<val.length(); i++){
            if(lc.size()>0){
                for(String s:lc){
                    letterCombination.add(s+val.charAt(i)+"");
                }

            }else{
                letterCombination.add(val.charAt(i)+"");
            }
        }

        return letterCombination;

    }
}
