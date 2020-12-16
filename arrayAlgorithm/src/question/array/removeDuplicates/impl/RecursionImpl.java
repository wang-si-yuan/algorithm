package question.array.removeDuplicates.impl;

import question.array.removeDuplicates.RemoveDuplicates;

//递归解法
public class RecursionImpl implements RemoveDuplicates {

    @Override
    public int removeDuplicates(int[] nums) {
        int count=nums.length;
        return removeDuplicates(nums,0,count);
    }

    /**
     * 从index处开始删除重复元素
     * @param nums
     * @param index
     */
    public int removeDuplicates(int[] nums,int index,int count){
        for (int i=index;i<nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                count = removeDuplicates(nums,i+1,count);
                count--;
                for (int j=i+1;j<count;j++){
                    nums[j] = nums[j+1];
                }
                return count;
            }
        }
        return count;
    }
}
