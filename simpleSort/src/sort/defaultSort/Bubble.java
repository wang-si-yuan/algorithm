package sort.defaultSort;

import sort.SortUtil;

/**
 * 冒泡排序
 */
public interface Bubble extends SortUtil {

    @Override
    default void sort(Comparable[] a){
        //最外层循环，从数组长度开始，每一次都缩短1（冒泡排序中，循环遍历一次，下一次循环就少遍历一个元素）
        for(int i=a.length-1;i>0;i--){
            //内层遍历开始，判断并交换相邻元素的位置
            for (int j = 0; j <i; j++) {
                setVis(i+1,a.length,j+1,-1);
                if (SortHelper.greater(a[j],a[j+1])){
                    setVis(i+1,a.length,j+1,j);
                    SortHelper.exch(a,j,j+1);
                    setVis(i+1,a.length,j,j+1);
                }else {
                    setVis(i+1,a.length,j,j+1);
                }
            }
        }
    }
}