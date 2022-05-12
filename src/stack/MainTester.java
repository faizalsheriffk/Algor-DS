package stack;

public class MainTester {

    public static void main(String[] args){
       MainTester tester = new MainTester();
       System.out.println(tester.reverse("Hello World"));
       System.out.println(tester.reversePrettyCode("Hello World"));
       System.out.printf("is expression balanced%s%n", tester.isExpressionBalanced("(5+6)x6x7x(8x9)"));
    }

    public String reverse(String s){
        if(s == null || s.length() == 0){
            return s;
        }

        Stack<Character> stack = new Stack<Character>();

        for(Character c:s.toCharArray()){
            stack.push(c);
        }


        char[] c = new char[stack.size()];

        int i = 0;
        while(!stack.isEmpty()){
            c[i] = stack.pop();
            i++;
        }
        return new String(c);
    }

    public String reversePrettyCode(String s){
        if(s == null || s.length() == 0){
            return s;
        }

        Stack<Character> stack = new Stack<Character>();

        for(Character c:s.toCharArray()){
            stack.push(c);
        }

        StringBuilder reverseString  = new StringBuilder();
        while (!stack.isEmpty()){
            reverseString.append(stack.pop());
        }
        return reverseString.toString();
    }

//(5+6)x6x7x8x9)
    public boolean isExpressionBalanced(String expression){
        Stack<Character> stack = new Stack<Character>();

        for (Character c : expression.toCharArray()){
            if(c  == '(') {
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
