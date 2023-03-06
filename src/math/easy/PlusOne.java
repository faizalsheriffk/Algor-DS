package math.easy;

public class PlusOne {
        public int[] plusOne(int[] digits) {

            var increment = 1;
            for(int index = digits.length-1; index >= 0; index--){

                var sum = digits[index]+increment;

                // if(sum > 9){
                digits[index] = sum % 10;
                increment = sum/10;
                // }else{
                //     increment = 0;
                // }

            }

            if(increment > 0){
                int[] result = new int[digits.length+1];
                System.arraycopy(digits, 0, result, 1, result.length-1);
                result[0] = increment;
                return result;
            }else{

                return digits;
            }
        }
}
