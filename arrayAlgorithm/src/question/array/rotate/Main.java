package question.array.rotate;

import question.array.rotate.impl.CyclicReplacementImpl;
import question.array.rotate.impl.FlipImpl;
import question.array.rotate.impl.ViolenceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rotate rotate = new FlipImpl();
        int[]a = {1,2,3,4,5};
        rotate.rotate(a,2);
        System.out.println(Arrays.toString(a));
    }
}
