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
实现了汉诺塔算法
## 快速排序模块
实现了快速排序
## 排序可视化模块
可视化模块的核心代码区域调用了简单排序模块，通过钩子`setVis`在排序算法的数据发生改变时设置页面显示的变化，我们可以在主函数中更改传入的参数来更改排序的方式。
## 算法题
### 数组区
#### 删除排序数组中的重复项
* 描述：
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
* 思路：
首先想到的是倒叙遍历数组，这种思路太简单了，并未实敲代码，敲了一个递归，和倒叙遍历数组是一个道理，但是时间复杂度有点炸。最后想到了双指针的方法。
* 代码：
removeDuplicates
#### 买卖股票的最佳时机
* 描述：
给定一个数组，它的第i个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。注意，你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
* 思路
暴力穷举在结果树中回溯是一个可行的方法，没有敲，敲了动态规划算法以及贪心算法。
* 代码
maxProfit
#### 旋转数组
* 描述：
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。（空间复杂度为常数）
* 思路
比较暴力一点的思路是循环k次，每一次都移动一格，时间复杂度炸了，后来发现k可以优化，毕竟这是一个绕圈圈的问题，360=0用求余就可以，不过复杂度还是太高了。之后写了一个跳跃置换的方法，一次到位，复杂度为O(n)，最后在官网的解说里看到了一种不讲武德的翻转思路，茅塞顿开。
* 代码
rotates
#### 存在重复元素
* 描述
给定一个整数数组，判断是否存在重复元素。如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
* 思路
一种是先对元素进行快排，之后查看相邻元素是否重复，时间复杂度就是快排的O(logn)，另一种是做个hash集合，时间复杂度上去了，但是空间复杂度变成了O(n)。
* 代码
containsDuplicate
#### 只出现一次的数字
* 描述：
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* 思路
看到题就知道我要上hashset了，不过位运算属实是不讲武德了
* 代码
singleNumber