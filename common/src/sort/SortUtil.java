package sort;


public interface SortUtil {

    //钩子（为可视化提供的回调方法）
    void setVis(int orderedIndexStart, int orderedIndexEnd, int currentCompareIndex, int currentMaximumIndex);

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    void sort(Comparable[] a);

}
