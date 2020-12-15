package hanoi;

import java.util.Stack;

public class HanoiData {
    private Stack<Integer> A;
    private Stack<Integer> B;
    private Stack<Integer> C;

    public HanoiData(int num){
        A=new Stack<>();
        B=new Stack<>();
        C=new Stack<>();

        for (int i = 1; i <= num; i++) {
            A.push(i);
        }
    }

    public Stack<Integer> getA() {
        return A;
    }

    public Stack<Integer> getB() {
        return B;
    }

    public Stack<Integer> getC() {
        return C;
    }
}
