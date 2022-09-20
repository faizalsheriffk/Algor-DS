package dynamicprogramming.archive;

public class TesterHouseRobber {

    public static void main(String[] args){
        HouseRobber robber = new HouseRobber();
        int[] house = {2,3,12,78,1};
        System.out.println(robber.calcMaxBounty(house));
    }
}
