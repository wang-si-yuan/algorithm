import controller.SimpleSortAlgoVisualizer;

public class Main {
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        new SimpleSortAlgoVisualizer(sceneWidth, sceneHeight, N, SimpleSortAlgoVisualizer.SHELL);
    }
}
