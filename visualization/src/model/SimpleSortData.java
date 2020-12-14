package model;

public class SimpleSortData extends SortData {

    public int orderedIndexStart = -1;
    public int orderedIndexEnd = -1;
    public int currentCompareIndex = -1;    // 当前正在比较的元素索引
    public int currentMaximumIndex = -1;        // 当前找到的最小元素的索引
    
    public SimpleSortData(int N, int randomBound) {
        super(N, randomBound);
    }
}
