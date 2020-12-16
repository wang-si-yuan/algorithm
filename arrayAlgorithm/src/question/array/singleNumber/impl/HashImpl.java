package question.array.singleNumber.impl;

import question.array.singleNumber.SingleNumber;

import java.util.HashSet;

public class HashImpl implements SingleNumber {
    @Override
    public int singleNumber(int[] nums) {

        HashSet<Integer> hashSet=new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.add(nums[i])){
                hashSet.remove(nums[i]);
            }
        }
        return hashSet.iterator().next();
    }
}
