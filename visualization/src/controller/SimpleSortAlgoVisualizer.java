package controller;

import model.SortData;
import sort.SortUtil;
import view.AlgoFrame;
import view.SimpleAlgoFrame;
import view.ViewDataHelper;

import java.awt.*;

public class SimpleSortAlgoVisualizer{

    public static int DELAY = 30;
    public final static int BUBBLE = 0;
    public final static int INSERTION = 1;
    public final static int SELECTION = 2;
    public final static int SHELL = 3;

    private final SortData data;
    private AlgoFrame frame;
    private final int TYPE;

    public SimpleSortAlgoVisualizer(int sceneWidth, int sceneHeight, int N, int type){
        this.TYPE = type;

        data = new SortData(N, sceneHeight);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new SimpleAlgoFrame("Sort Visualization", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    private void run(){

        setData(0, 0, -1,-1);

        //在这里更改排序算法
        //这里是一个继承排序算法的匿名内部类，实现了三个钩子函数
        SortUtil sortUtil;
        if (TYPE==BUBBLE){
            sortUtil = SortUtil.BUBBLE(this::setData);
        }else if (TYPE==INSERTION){
            sortUtil = SortUtil.INSERTION(this::setData);
        }else if (TYPE==SELECTION){
            sortUtil = SortUtil.SELECTION(this::setData);
        }else if (TYPE==SHELL) {
            sortUtil = SortUtil.SHELL(this::setData);
        } else {
            return;
        }
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
}
