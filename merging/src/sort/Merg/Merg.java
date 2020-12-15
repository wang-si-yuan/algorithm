package sort.Merg;

import sort.SortUtil;

import static sort.SortHelper.*;

public interface Merg extends SortUtil {
    @Override
    default void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    default void sort(Comparable[] a,int lo,int hi) {
        if (hi<=lo){
            return;
        }
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merg(a,lo,mid,hi);
    }

    default void merg(Comparable[] a,int lo,int mid,int hi) {
        int i = 0;
        int p1 = lo;
        int p2 = mid+1;

        Comparable[] temp=new Comparable[hi-lo+1];

        while (p1<=mid&&p2<=hi){
            if (less(a[p1],a[p2])){
                setVis(-1,-1,p2,p1);
                temp[i++]=a[p1++];
            }else {
                temp[i++]=a[p2++];
                setVis(-1,-1,p1,p2);
            }
        }

        while (p1<=mid){
            temp[i++]=a[p1++];
            setVis(-1,-1,p1,-1);
        }

        while (p2<=hi){
            temp[i++]=a[p2++];
            setVis(-1,-1,p2,-1);
        }

        System.arraycopy(temp, 0, a, lo, temp.length);
        setVis(lo,hi,-1,-1);
    }
}
