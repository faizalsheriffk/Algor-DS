package greedy.medium;

public class ValidParenthesisString {


    // It is not natural to come up with a solution
    //natural intuition was to use open close and star variable with open-close+star > 0 return true
    //This algo won't work if * is out of place so we need to keep track of posistion
    // We use max posibility and min posibility, towards the end, if min is balanced then we are good.
    //
    public boolean checkValidString(String s) {



        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == '('){
                leftMin++;
                leftMax++;

            }
            else if(s.charAt(i) == ')'){
                leftMin--;
                leftMax--;
            }else { // *
                leftMax++; // open possibility
                leftMin--; // close possibility
            }

            if(leftMax<0){ // invalid string as left max should never be less than 0
                return false;
            }

            if(leftMin<0){ // reset it
                leftMin = 0;
            }
        }

        return leftMin == 0; // if left min is not zero then the string is not balanced.
    }
}
