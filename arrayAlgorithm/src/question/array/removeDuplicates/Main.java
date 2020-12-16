package question.array.removeDuplicates;

import question.array.removeDuplicates.impl.RemoveDuplicatesImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates =new RemoveDuplicatesImpl();
        int[] a = {1,1,2,3,3,3};
        int count= removeDuplicates.removeDuplicates(a);
        for (int i = 0; i < count; i++) {
            System.out.println(a[i]);
        }
        System.out.println(Arrays.toString(a));
    }
}
