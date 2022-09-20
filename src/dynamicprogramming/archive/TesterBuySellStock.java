package dynamicprogramming.archive;

public class TesterBuySellStock {

    public static void main(String[] args){
        BuySellStock bs = new BuySellStock();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(""+bs.maxProfit(2, prices));
    }
}

