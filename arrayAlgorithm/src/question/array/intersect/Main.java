package question.array.intersect;

import question.array.intersect.impl.HashImpl;
import question.array.intersect.impl.SortImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a={1,2,2,1};
        int[] b={2,2};
        int[] c=new SortImpl().intersect(a,b);
        System.out.println(Arrays.toString(c));
    }
}
