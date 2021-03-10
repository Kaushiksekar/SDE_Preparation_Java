package problem_solving.arrays;

// 121

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < buy)
                buy = price;
            if (price > buy && price - buy > maxProfit)
                    maxProfit = price - buy;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(new MaxProfit().maxProfit(new int[] {7,6,4,3,1}));
    }
}
