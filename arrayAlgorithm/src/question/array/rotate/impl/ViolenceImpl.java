package question.array.rotate.impl;

import question.array.rotate.Rotate;

//暴力解法
public class ViolenceImpl implements Rotate {
    @Override
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i=0;i<k;i++){
            int fir = nums[nums.length-1];
            for (int j=nums.length-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0] = fir;
        }
    }
}
