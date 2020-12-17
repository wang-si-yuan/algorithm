package ApiUtils;


import sort.Merg.Merg;
import sort.Merg.impl.MergImpl;
import sort.defaultSort.Bubble;
import sort.defaultSort.Insertion;
import sort.defaultSort.Selection;
import sort.defaultSort.impl.BubbleImpl;
import sort.defaultSort.impl.InsertionImpl;
import sort.defaultSort.impl.SelectionImpl;
import sort.quick.Quick;
import sort.quick.impl.QuickImpl;
import sort.shellSort.Shell;
import sort.shellSort.impl.ShellImpl;

import java.util.List;

public class SortApiUtil {
    static Bubble BUBBLE = new BubbleImpl();
    public static Bubble BUBBLE(Bubble bubble){
        return bubble;
    }

    static Selection SELECTION= new SelectionImpl();
    public static Selection SELECTION(Selection selection){
        return selection;
    }

    static Insertion INSERTION = new InsertionImpl();
    public static Insertion INSERTION(Insertion insertion){
        return insertion;
    }

    static Shell SHELL = new ShellImpl();
    public static Shell SHELL(Shell shell){
        return shell;
    }

    static Merg MERG = new MergImpl();
    public static Merg MERG(Merg merg) {
        return merg;
    }

    static Quick QUICK = new QuickImpl();
    public static Quick QUICK(Quick quick) {
        return quick;
    }
}
