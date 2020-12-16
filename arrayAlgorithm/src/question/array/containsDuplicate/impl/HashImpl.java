package question.array.containsDuplicate.impl;

import question.array.containsDuplicate.ContainsDuplicate;

import java.util.HashSet;

public class HashImpl implements ContainsDuplicate {
    @Override
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet=new HashSet();
        for (int i = 0; i < nums.length; i++) {
            boolean res = hashSet.add(nums[i]);
            if (!res){
                return true;
            }
        }
        return false;
    }
}
