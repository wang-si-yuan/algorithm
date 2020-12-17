package question.array.intersect.impl;

import question.array.intersect.Intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortImpl implements Intersect {

    @Override
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int p1=0;
        int p2=0;

        while (p1<nums1.length&&p2<nums2.length){
            if (nums1[p1]<nums2[p2]){
                p1++;
            }else if (nums1[p1]>nums2[p2]){
                p2++;
            }else {
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
