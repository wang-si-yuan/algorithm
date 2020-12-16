package question.array.singleNumber.impl;

import question.array.singleNumber.SingleNumber;

//不讲武德的位运算
public class BitImpl implements SingleNumber {
    @Override
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
