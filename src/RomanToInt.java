import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    Map<String, Integer> rMap = new HashMap<String, Integer>() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }
    };

    public int romanToIntMap(char c){
        return rMap.get(String.valueOf(c))==null?0:rMap.get(String.valueOf(c));
    }

    public int romanToInt(String s) {

        //Having a map to map all the chars




        //Do one pass to get the max roman char and thier loweset index
        //keeping that as an pivot left

        int curValue = 0;
        int nextValue = 0;
        int res = 0;

        for(int i = 0; i < s.length(); i++){

            curValue = romanToIntMap(s.charAt(i));

            if(i+1 < s.length()){
                nextValue =  romanToIntMap(s.charAt(i+1));
                if(nextValue > curValue){
                    res = res + (nextValue - curValue);
                }else{
                    res = res + nextValue;
                }

            }else{
                curValue = romanToIntMap(s.charAt(i));
                res = res + curValue;
            }

        }

        return res;


    }

    public static void main(String[] args){
        RomanToInt atoi =  new RomanToInt();
        System.out.println(atoi.romanToInt("III"));
    }
}
