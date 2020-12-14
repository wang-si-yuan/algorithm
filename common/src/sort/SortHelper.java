package sort;

public class SortHelper {

    private SortHelper(){ }

    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w) > 0;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

     public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
