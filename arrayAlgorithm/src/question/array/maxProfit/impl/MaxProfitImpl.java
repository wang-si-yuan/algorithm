package question.array.maxProfit.impl;

import question.array.maxProfit.MaxProfit;

//贪心算法
public class MaxProfitImpl implements MaxProfit {
    @Override
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int res=0;
        for (int i = 1; i < prices.length; i++) {

            int d=prices[i]-prices[i-1];
            if (d>0){
                res+=d;
            }
        }
        return res;
    }
}
