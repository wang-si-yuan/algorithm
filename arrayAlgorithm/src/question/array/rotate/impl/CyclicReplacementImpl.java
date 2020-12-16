package question.array.rotate.impl;

import question.array.rotate.Rotate;

//环状解法
//坑：想到了环状解法，但是对于结束条件无从下手，想不到使用计数器来作为结束条件
public class CyclicReplacementImpl implements Rotate {
    @Override
    public void rotate(int[] nums, int k) {

        k=k%nums.length;

        int count = 0;
        for (int index=0;count<nums.length;index++){

            int curr = index;
            int prev = nums[index];

            do {
                int next = (curr+k)%nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
            }while (curr != index);
        }

    }
}
