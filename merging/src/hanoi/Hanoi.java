package hanoi;

import java.util.Stack;

public class Hanoi {
    public int N = 0;

    public void move(HanoiData hanoiData){
        moveNums(hanoiData.getA(),hanoiData.getB(),hanoiData.getC(),hanoiData.getA().size());
        int index = hanoiData.getB().size();
        for (int i=0;i<index;i++){
            System.out.println(hanoiData.getB().pop());
        }
        System.out.println("N:"+N);
    }

    private void moveNums(Stack<Integer> from, Stack<Integer> to, Stack<Integer> temp, int nums){
        if (nums==1){
            moveNum(from,to);
        }else {
            moveNums(from,temp,to,nums-1);
            moveNums(from,to,temp,1);
            moveNums(temp,to,from,nums-1);
        }
    }

    private void moveNum(Stack<Integer> from, Stack<Integer> to){
        to.push(from.pop());
        N++;
    }
}
