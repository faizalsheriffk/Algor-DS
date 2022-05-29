package stack.easy;

import stack.Stack;

public class BalancedExpression {

    /**
     * Key is to check while you are iterating pushing only right hand side
     * Operands in the stack
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        if(s == null || s.trim().length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        char r = ' ';
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c =='['){
                stack.push(c);
            }else{
                r = stack.isEmpty()?' ':stack.pop();
                if(r == '{' && c == '}'){
                    continue;
                }else if (r == '[' && c == ']'){
                    continue;
                }else if(r == '(' && c == ')'){
                    continue;
                }else{
                    return false;
                }
            }

        }


        return stack.isEmpty();

    }
}
