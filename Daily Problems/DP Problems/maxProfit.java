public class maxProfit {
    public static void main(String[] args){
        int[] prices={7,1,5,3,6,4};
        int ans=MaxProfit(prices);
        System.out.println(ans);
    }
    public static int MaxProfit(int[] prices){
        int mini =prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-mini;
            maxProfit=Math.max(maxProfit,cost);
            mini=Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
}
