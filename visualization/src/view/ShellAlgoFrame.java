package view;

import java.awt.*;

public class ShellAlgoFrame extends AlgoFrame {
    public ShellAlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title, canvasWidth, canvasHeight);
        AlgoCanvas canvas = new AlgoCanvas(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D)g;

                // 抗锯齿
                RenderingHints hints = new RenderingHints(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.addRenderingHints(hints);

                // 具体绘制
                int w = canvasWidth/getData().N();
                for(int i = 0 ; i < getData().N() ; i ++ ) {
                    if (getData().orderedIndexStart <= i && i <= getData().orderedIndexEnd)
                        ViewDataHelper.setColor(g2d, ViewDataHelper.Red);
                    else
                        ViewDataHelper.setColor(g2d, ViewDataHelper.Grey);

                    if(i == getData().currentCompareIndex)
                        ViewDataHelper.setColor(g2d, ViewDataHelper.LightBlue);
                    if(i == getData().currentMaximumIndex)
                        ViewDataHelper.setColor(g2d, ViewDataHelper.Indigo);
                    ViewDataHelper.fillRectangle(g2d, i * w, canvasHeight - getData().get(i), w - 1, getData().get(i));
                }
            }
        };
    }
}
