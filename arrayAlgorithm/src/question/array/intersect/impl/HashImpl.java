package question.array.intersect.impl;

import question.array.intersect.Intersect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashImpl implements Intersect {
    @Override
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if(map.putIfAbsent(nums1[i],1)!=null){
                map.put(nums1[i],map.get(nums1[i])+1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i])!=null && map.get(nums2[i])!=0){
                map.put(nums2[i],map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
