package model;

public class SortData {
    private Integer[] numbers;

    public int orderedIndexStart = -1;
    public int orderedIndexEnd = -1;
    public int currentCompareIndex = -1;    // 当前正在比较的元素索引
    public int currentMaximumIndex = -1;        // 当前找到的最小元素的索引

    public SortData(int N, int randomBound){

        numbers = new Integer[N];

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;
    }

    public int N(){
        return numbers.length;
    }

    public Integer[] getArray(){
        return numbers;
    }


    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        return numbers[index];
    }
}
