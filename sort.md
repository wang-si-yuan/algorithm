# 简单排序算法
### 本次课程要求java基础知识、面向对象编程设计的基础知识
在我们的程序中，排序是非常常见的一种需求，提供一些数据元素，把这些数据元素按照一定的规则进行排序。比如查询一些订单，按照订单的日期进行排序；再比如查询一些商品，按照商品的价格进行排序等等。在我们学习编程语言的时候，大家一定对排序这个简单的需求不陌生。
比如入门编程世界时的时候，老师都会教给我们一种简单的排序思路，我们叫它**冒泡排序**。
## 1冒泡排序
### 1.1 Comparable接口
排序时必然要对元素进行比较，为了我们代码的通用性，我们需要介绍一个接口。在**java8官方文档**中，我们找到了Comparable接口的详细介绍。
> This interface imposes a total ordering on the objects of each class that implements it. This ordering is referred to as the class’s natural ordering, and the class’s compareTo method is referred to as its natural comparison method.
我们可以知道，这个接口可以实现给类增加一个**排序规则**。java内置的很多api都实现类Comparable接口，同时也内置了很多对Comparable类的操作。**Comparable接口中定义了一个名为compareTo、参数为泛型且返回值为int型的抽象方法**。使用方式为：调用一个Comparable对象的compareTo方法，传入指定对象，获取一个返回值，返回值为负整数、零或正整数，此对象小于、等于或大于指定对象。
我们可以将返回值理解为**此对象与指定对象的距离**，如下图所示。

![image](https://github.com/wang-si-yuan/algorithm/blob/master/images/sort/comparable.gif)

因此，我们可以直接封装一个处理Comparable对象的排序类，以此来完成排序工作。
### 1.2 冒泡排序原理
想要理解冒泡排序为什么可以排序，我们可以借助一个指针来查看最大元素的移动轨迹。
1. 首先我们拥有一个指针p，指向排序列的第一个元素。
2. 按照顺序对排序列进行一次遍历，并进行交换，交换规则为：将顺序遍历的元素分别与指针p做比较，如果其值比指针p更小，则交换p对应元素与该元素的位置，并且使p永远指向更大的元素。
3. 忽略每次遍历后的结尾元素重复遍历，最终得到有序列。
下图显示了冒泡排序第一次遍历得到的结果。

![image](https://github.com/wang-si-yuan/algorithm/blob/master/images/sort/bubble.gif)

我们发现，每一次都是在比较和交换相邻的元素，所以此时指针是多余的，我们可以每次遍历只比较相邻元素大小即可。
最后我们得到了冒泡排序的定义：
冒泡排序算法重复地走访过要排序的元素列，依次比较两个相邻的元素，如果顺序（如从大到小、首字母从Z到A）错误就把他们交换过来。走访元素的工作是重复地进行直到没有相邻元素需要交换，也就是说该元素列已经排序完成。

| **案例** | **3,6,2,7,1,5,4** |
|----|----|
|第一趟排序|3,2,6,1,5,4,**7**|
|第二趟排序|2,3,1,5,4,**6,7**|
|第三趟排序|2,1,3,4,**5,6,7**|
|第四趟排序|1,2,3,**4,5,6,7**|
|第五趟排序|1,2,**3,4,5,6,7**|
|第六趟排序|1,**2,3,4,5,6,7**|

### 1.3 冒泡排序算法的java实现
```java
public class Bubble {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //最外层循环，从数组长度开始，每一次都缩短1（冒泡排序中，循环遍历一次，下一次循环就少遍历一个元素）
        for(int i=a.length-1;i>0;i--){
            //内层遍历开始，判断并交换相邻元素的位置
            for (int j = 0; j <i; j++) {
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

```

### 1.4 冒泡排序算法的时间复杂度
冒泡算法使用了双层的for循环，在最差的情况下：
元素比较次数为(N-1)+(N-2)+(N-3)+…+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2，元素交换的次数为(N-1)+(N-2)+(N-3)+…+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2。
总执行的次数等于N^2-N，时间复杂度为O(N^2)。
## 2 选择排序
### 2.1 选择排序原理
通过算法的分析，我们发现，冒泡排序在排序的过程中做了大量无用的交换，这导致了性能的折损，我们能不能有 一种简单的方式来避免这种无用的交换呢？
**选择排序**解决了这个问题。
选择排序是一种更加直观的排序解决方案，它的原理就是**将元素放到应该放到的位置**。

它在每一次遍历时，都让一个指针指向最小值，在遍历结束后将最小值交换到无序列的前面。
**在遍历期间，元素不再进行交换。**
下图显示了选择排序第一趟的排序过程。

![image](https://github.com/wang-si-yuan/algorithm/blob/master/images/sort/insertion.gif)

这样，即使是在最坏的情况下，元素也只交换了n-1次，解决了大量无用交换的问题。

| **案例** | **3,6,2,7,1,5,4** |
|----|----|
|第一趟排序|**1**,6,2,7,3,5,4|
|第二趟排序|**1,2**,6,7,3,5,4|
|第三趟排序|**1,2,3**,7,6,5,4|
|第四趟排序|**1,2,3,4**,6,5,7|
|第五趟排序|**1,2,3,4,5**,6,7|
|第六趟排序|**1,2,3,4,5,6**,7|

选择排序的定义：
插入排序是指第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。以此类推，直到全部待排序的数据元素的个数为零。
### 2.2 选择排序算法的java实现
```java
public class Selection {
    
    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){

        //最外层循环循环n-1次
        for (int i=0;i<=a.length-2;i++){

            //定义一个指针（对象的引用传递有指针的一些特点，Java对指针进行了封装，开发者无法直接通过指针操作内存）
            int minIndex=i;

            //内层循环，指针指向最小的元素
            for (int j=i+1;j<a.length;j++){
                if (greater(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            //在此交换元素
            exch(a,i,minIndex);
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
```

### 2.3 选择排序算法的时间复杂度
选择排序算法在外层循环交换元素，内层循环比较元素，因此：
元素比较的次数为(N-1)+(N-2)+(N-3)+…+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2，元素交换的次数为N-1。
时间复杂度为O(n^2)。

## 3 插入排序
### 3.1 插入排序原理
大家都应该玩过扑克牌。

![image](https://github.com/wang-si-yuan/algorithm/blob/master/images/sort/selectionb.gif)

插入排序就是“抓牌”。
我们将所有元素分为两组，一组是未排序的（排堆），另一组是排好序的（手里），初始状态下，手里没有牌，我们将在乱序的元素中抽取元素，之后插入到手上合适的位置。
下图是插入排序的过程。

![image](https://github.com/wang-si-yuan/algorithm/blob/master/images/sort/selection.gif)

|**案例**|**3,6,2,7,1,5,4**|
|----|----|
|第一趟排序|**3,6**,2,7,1,5,4|
|第二趟排序|**2,3,6**,7,1,5,4|
|第三趟排序|**2,3,6,7**,1,5,4|
|第四趟排序|**1,2,3,6,7**,5,4|
|第五趟排序|**1,2,3,5,6,7**,4|
|第六趟排序|**1,2,3,4,5,6,7**|

插入排序的定义：
插入排序是指在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的，现将第n个数插到前面已经排好的序列中，然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。按照此法对所有元素进行插入，直到整个序列排为有序的过程.
### 3.2 插入排序算法的java实现
```java
public class Insertion {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){

        //外层循环从乱序列中依次选择元素
        for (int i=1;i<a.length;i++) {

            //内层将元素插入到指定位置
            for (int j = i; j > 0; j--) {
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w) > 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

```

### 3.3 插入算法的时间复杂度
插入排序使用了双层for循环，其中内层循环是真正完成排序的代码。
最坏情况下：
比较的次数为(N-1)+(N-2)+(N-3)+…+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2，交换的次数为(N-1)+(N-2)+(N-3)+…+2+1=((N-1)+1)*(N-1)/2=N^2/2-N/2，总执行次数为(N^2/2-N/2)+(N^2/2-N/2)=N^2-N;
时间复杂度为O(N^2)。
可是，眼睛贼尖的小伙伴还是发出了疑问。
方法换来换去，时间复杂度它还是没有变啊？

O(N^2)是一个非常low的时间复杂度，随着数据量规模的增大，我们的排序算法将会变得越来越慢。我们是否能有一种简单的方式，将排序算法的时间复杂度降低呢？

# 未完待续
希尔排序、归并排序、快速排序、堆排序、桶排序

