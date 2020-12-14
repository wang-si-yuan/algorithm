package sort.defaultSort;

import sort.SortHelper;
import sort.SortUtil;

/**
 * 选择排序
 */
public interface Selection extends SortUtil{

    @Override
    default void sort(Comparable[] a){

        //最外层循环循环n-1次
        for (int i=0;i<=a.length-2;i++){

            //定义一个指针（对象的引用传递有指针的一些特点，Java对指针进行了封装，开发者无法直接通过指针操作内存）
            int minIndex=i;

            //内层循环，指针指向最小的元素
            for (int j=i+1;j<a.length;j++){
                setVis(-1,i-1,j,minIndex);
                if (SortHelper.greater(a[minIndex],a[j])){
                    minIndex=j;
                    setVis(-1,i-1,-1,minIndex);
                    setVis(-1,i-1,-1,minIndex);
                }
            }
            //在此交换元素
            SortHelper.exch(a,i,minIndex);
            setVis(-1,i-1,-1,minIndex);
        }
    }
}
