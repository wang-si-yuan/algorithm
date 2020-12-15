# 学长学编程官方算法代码
* 工具和版本：idea，jdk8
* 公众号：学长会编程
![Image](https://github.com/wang-si-yuan/algorithm/blob/master/images/gzh.png)
## 简单排序模块
简单排序算法所在的module是simpleSort，里面提供了三种算法,分别是冒泡排序(Bubble)、查找排序(Selection)和插入排序(Insertion)。
与公众号推送的排序算法不同的是，我为排序算法做了一层良好的封装，提高了代码的可读性和可复用性。

在SortUtil接口中，我定义了一个名为sort的抽象方法，用于实现排序算法。
```java
void sort(Comparable[] a);
```
同时我也设定了一个观察者，在排序数据发生改变时，观察者将被调用。观察者主要充当可视化时的钩子函数。
```java
void setVis(int orderedIndexStart, int orderedIndexEnd, int currentCompareIndex, int currentMaximumIndex);
```
Bubble、Insertion、Selection三个接口继承了SortUtil接口，并编写了sort的默认实现方法。
## 希尔排序模块
实现了希尔排序。
## 归并模块
实现了归并排序
## 排序可视化模块
可视化模块的核心代码区域调用了简单排序模块，通过钩子`setVis`在排序算法的数据发生改变时设置页面显示的变化，我们可以在主函数中更改传入的参数来更改排序的方式。
