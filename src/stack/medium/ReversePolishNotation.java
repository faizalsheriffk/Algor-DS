package stack.medium;

import java.util.Stack;

public class ReversePolishNotation {


    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<String>();
        int l = 0, r = 0;

        for(String c: tokens){


            if(isNumeric(c)){
                stack.push(c);
            }else{
                /**
                 * This order is important with right being
                 * the first operand
                 */
                r = Integer.parseInt(stack.pop());
                l = Integer.parseInt(stack.pop());

                switch (c){
                    case "+":
                        stack.push(l+r+"");
                        break;
                    case "-":
                        stack.push(l-r+"");
                        break;
                    case "*":
                        stack.push(l*r+"");
                        break;

                    case "/":
                        stack.push(l/r+"");
                        break;

                }
            }
        }

        return Integer.parseInt(stack.pop());
    }


    private boolean isNumeric(String c){
        try{
            Integer.parseInt(c);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
