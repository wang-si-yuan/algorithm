package sort;

import sort.defaultSort.Bubble;
import sort.defaultSort.Insertion;
import sort.defaultSort.Selection;
import sort.defaultSort.impl.BubbleImpl;
import sort.defaultSort.impl.InsertionImpl;
import sort.defaultSort.impl.SelectionImpl;

public interface SortUtil {

    static Bubble BUBBLE = new BubbleImpl();
    static Bubble BUBBLE(Bubble bubble){
        return bubble;
    }

    static Selection SELECTION= new SelectionImpl();
    static Selection SELECTION(Selection selection){
        return selection;
    }

    static Insertion INSERTION = new InsertionImpl();
    static Insertion INSERTION(Insertion insertion){
        return insertion;
    }

    //钩子（为可视化提供的回调方法）
    void setVis(int orderedIndexStart, int orderedIndexEnd, int currentCompareIndex, int currentMaximumIndex);

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    void sort(Comparable[] a);

}
