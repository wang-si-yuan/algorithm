package question.array.maxProfit;

import question.array.maxProfit.impl.DPImpl;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        MaxProfit maxProfit = new DPImpl();
        System.out.println(maxProfit.maxProfit(a));
    }
}
