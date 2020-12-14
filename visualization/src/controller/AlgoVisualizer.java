package controller;

import model.SortData;
import sort.SortUtil;
import view.AlgoFrame;
import view.SimpleAlgoFrame;
import view.ViewDataHelper;

import java.awt.*;

public class AlgoVisualizer {

    private static int DELAY = 50;

    private SortData data;
    private AlgoFrame frame;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        data = new SortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new SimpleAlgoFrame("Sort Visualization", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run(){

        setData(0, 0, -1,-1);

        //在这里更改排序算法
        //这里是一个继承排序算法的匿名内部类，实现了三个钩子函数
        SortUtil sortUtil = SortUtil.BUBBLE(this::setData);
        sortUtil.sort(data.getArray());
        setData(0,data.N()-1,-1,-1);
    }

    private void setData(int orderedIndexStart,int orderedIndexEnd, int currentCompareIndex, int currentMaximumIndex){
        data.orderedIndexStart = orderedIndexStart;
        data.orderedIndexEnd = orderedIndexEnd;
        data.currentCompareIndex = currentCompareIndex;
        data.currentMaximumIndex = currentMaximumIndex;

        frame.render(data);
        ViewDataHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 100;

        new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
