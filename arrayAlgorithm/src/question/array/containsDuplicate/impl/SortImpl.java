package question.array.containsDuplicate.impl;

import question.array.containsDuplicate.ContainsDuplicate;

import java.util.Arrays;

public class SortImpl implements ContainsDuplicate {
    @Override
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
