package view;

import model.SortData;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {

    private final int canvasWidth;
    private final int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

    }

    public void init(){
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}

    public SortData getData() {
        return data;
    }

    // data
    private SortData data;
    public void render(SortData data){
        this.data = data;
        repaint();
    }

    public class AlgoCanvas extends JPanel{

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}