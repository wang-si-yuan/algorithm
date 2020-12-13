package sort.defaultSort;

class SortHelper {

    private SortHelper(){ }

    static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

     static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
