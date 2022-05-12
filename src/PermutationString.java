public class PermutationString {

    public static void main(String[] args){
        PermutationString ps = new PermutationString();
        ps.generatePS("ABC");

    }

    private void generatePS(String toString) {

       System.out.println(toString.substring(2));
    }
}
