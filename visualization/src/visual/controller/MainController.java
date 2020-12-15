package visual.controller;

import visual.view.MainView;
import visual.view.SimpleAlgoFrame;

import java.awt.*;

public class MainController {
    public MainController(String title){
        EventQueue.invokeLater(() -> {
            MainView frame = new MainView("Sort Visualization");
        });
    }
}
