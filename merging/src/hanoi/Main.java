package hanoi;

public class Main {
    public static void main(String[] args) {
        Hanoi hanoi=new Hanoi();
        hanoi.move(new HanoiData(20));
    }
}
