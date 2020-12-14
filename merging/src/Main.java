import sort.SortUtil;

public class Main {
    public static void main(String[] args) {
        Integer[] a={10,3,2,5,6,7,1,9,8,4};
        SortUtil.MERG.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
