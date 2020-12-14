package sort.defaultSort;

import sort.SortHelper;
import sort.SortUtil;

/**
 * 插入排序
 */
public interface Insertion extends SortUtil {

    @Override
    default void sort(Comparable[] a){

        //外层循环从乱序列中依次选择元素
        for (int i=1;i<a.length;i++) {

            //内层将元素插入到指定位置
            for (int j = i; j > 0; j--) {
                if (SortHelper.greater(a[j - 1], a[j])) {
                    setVis(-1,i,j,-1);
                    setVis(-1,i,j,j-1);
                    SortHelper.exch(a, j - 1, j);
                    setVis(-1,i,j-1,j);
                } else {
                    setVis(-1,i,j,-1);
                    setVis(-1,i,j-1,j);
                    break;
                }
            }
            setVis(-1,i,-1,-1);
        }
    }
}