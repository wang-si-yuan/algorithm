package sort.shellSort;

import sort.SortUtil;

import static sort.SortHelper.*;

public interface Shell extends SortUtil {
    @Override
    default void sort(Comparable[] a){

        //初始化增量
        int h=initIncrement(a.length);
        while (h>=1){
            //进行插入排序
            for (int i=h;i<a.length;i++){
                for (int j=i;j>=h;j-=h){
                    if (greater(a[j-h],a[j])){
                        exch(a,j,j-h);
                    }else {
                        break;
                    }
                }
            }
            //减小增量
            h=decreaseIncrement(h);
        }
    };

    default int initIncrement(int N){
        int increment = 1;
        while (increment<N/2){
            increment=increment*2+1;
        }
        return increment;
    }
    default int decreaseIncrement(int increment){
        return increment/2;
    }
}
