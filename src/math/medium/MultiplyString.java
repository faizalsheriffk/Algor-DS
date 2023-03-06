package math.medium;

public class MultiplyString {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int[] sum = new int[num1.length()+num2.length()];

        //reverse the string
        num1 = reverseString(num1);
        num2 = reverseString(num2);

        for(int i = 0; i< num1.length(); i++){
            for(int j= 0; j<num2.length(); j++){
                sum[i+j] = sum[i+j]+Integer.parseInt(num1.charAt(i)+"")* Integer.parseInt(num2.charAt(j)+"");
                sum[i+j+1] = sum[i+j+1]+(sum[i+j]/10);
                sum[i+j] = sum[i+j]%10;

            }
        }
        return reverseArrayAsString(sum);
    }

    private String reverseString(String s){
        StringBuilder str = new StringBuilder(s);
        return new String(str.reverse());
    }

    private String reverseArrayAsString(int[] sum){
        StringBuilder result = new StringBuilder();
        for(int i = sum.length-1; i>=0; i--){
            result.append(sum[i]+"");

        }
        if(result.charAt(0) == '0')
            result.setCharAt(0,' ');
        return result.toString().trim();
    }
}
