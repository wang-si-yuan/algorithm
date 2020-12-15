package sort.quick;

import sort.SortUtil;

import static sort.SortHelper.exch;
import static sort.SortHelper.less;

public interface Quick extends SortUtil {

    @Override
    default void sort(Comparable[] a){
        sort(a,0,a.length-1);
    };

    default void sort(Comparable[] a,int lo,int hi){
        if (hi<=lo){
            return;
        }
        int partition = partition(a,lo,hi);
        sort(a,lo,partition-1);
        sort(a,partition+1,hi);
    }

    default int partition(Comparable[] a,int lo,int hi){
        Comparable key = a[lo];
        int left = lo;
        int right = hi+1;

        while (true){

            while (less(key,a[--right])){
                setVis(lo,lo,left,right);
                if (right==lo){
                    break;
                }
            }

            while (less(a[++left],key)){
                setVis(lo,lo,left,right);
                if (left==hi){
                    break;
                }
            }

            if (left>=right){
                break;
            }else {
                setVis(lo,lo,right,left);
                exch(a,left,right);
                setVis(lo,lo,left,right);
            }
        }
        exch(a,lo,right);
        setVis(right,right,-1,-1);
        return right;
    }
}
