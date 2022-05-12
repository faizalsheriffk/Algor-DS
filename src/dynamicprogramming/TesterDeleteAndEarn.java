package dynamicprogramming;

public class TesterDeleteAndEarn {

    public static void main(String[] args){
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        int[] stairsCost = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn.deleteAndEarn(stairsCost));
    }
}
