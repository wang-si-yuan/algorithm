package visual.view;

import visual.controller.SimpleSortAlgoVisualizer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

    private final int sceneWidth = 800;
    private final int sceneHeight = 800;
    private final int N = 100;

    public MainView(String title) {
        super(title);
        setSize(1000,100);
        JPanel panel = new JPanel();
        placeComponents(panel);
        this.add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void placeComponents(JPanel panel) {

        JButton bubble = new JButton("冒泡排序");
        panel.add(bubble);
        bubble.addActionListener(this::bubbleLisener);

        JButton insertion = new JButton("插入排序");
        panel.add(insertion);
        insertion.addActionListener(this::insertionLisener);

        JButton selection = new JButton("选择排序");
        panel.add(selection);
        selection.addActionListener(this::selectionListener);

        JButton shell = new JButton("希尔排序");
        panel.add(shell);
        shell.addActionListener(this::shellListener);

        JButton merg = new JButton("归并排序");
        panel.add(merg);
        merg.addActionListener(this::mergListener);

        JButton quick = new JButton("快速排序");
        panel.add(quick);
        quick.addActionListener(this::quickListener);
    }

    private void quickListener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.QUICK);
    }

    private void mergListener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.MERG);
    }

    private void shellListener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.SHELL);
    }

    private void selectionListener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.SELECTION);
    }

    private void insertionLisener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.INSERTION);
    }

    private void bubbleLisener(ActionEvent actionEvent) {
        new SimpleSortAlgoVisualizer(sceneWidth,sceneHeight,N,SimpleSortAlgoVisualizer.BUBBLE);
    }
}
