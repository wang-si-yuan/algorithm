package question.array.maxProfit.impl;

import question.array.maxProfit.MaxProfit;

public class DPImpl implements MaxProfit {
    @Override
    public int maxProfit(int[] prices) {

        int N = prices.length;

        //两种状态，手里有股票以及手里没股票,次数可压缩
//        int[][] dpPrices = new int[N][2];

        //初始化dp
//        dpPrices[0][0] = 0;
//        dpPrices[0][1] = -prices[0];

        int dpPrices0 = 0;
        int dpPrices1 = -prices[0];

        int preDpPrices0 = dpPrices0;
        int proDpPrices1 = dpPrices1;

        for (int i=1;i<N;i++){
            //今天不准备手里有了，昨天以前抛出去了或者今天就抛
//            dpPrices[i][0] = Math.max(dpPrices[i-1][0],dpPrices[i-1][1]+prices[i]);
            dpPrices0 = Math.max(preDpPrices0,proDpPrices1+prices[i]);
            //今天准备有，要不然就是昨天之前抛了今天现买，要不然就是昨天手里就有
//            dpPrices[i][1] = Math.max(dpPrices[i-1][1],dpPrices[i-1][0]-prices[i]);
            dpPrices1 = Math.max(proDpPrices1,preDpPrices0-prices[i]);

            preDpPrices0 = dpPrices0;
            proDpPrices1 = dpPrices1;

        }
//        return dpPrices[N-1][0];
        return preDpPrices0;
    }
}
