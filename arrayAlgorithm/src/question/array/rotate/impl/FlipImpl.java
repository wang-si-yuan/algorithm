package question.array.rotate.impl;

import question.array.rotate.Rotate;

//翻转，神奇思路，不讲武德
public class FlipImpl implements Rotate {
    @Override
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        flip(nums,0,nums.length-1);
        flip(nums,0,k-1);
        flip(nums,k,nums.length-1);
    }

    void flip(int[] nums,int start,int end){
        int p1=start;
        int p2=end;
        int temp;
        while (p1<p2){
            temp=nums[p1];
            nums[p1++]=nums[p2];
            nums[p2--]=temp;
        }
    }
}
