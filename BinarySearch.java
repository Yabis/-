package com.yabis.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
//        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };


        //
//		int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }
// 二分查找算法
    /**
     *
     * @param arr
     *            数组
     * @param left
     *            左边的索引
     * @param right
     *            右边的索引
     * @param findVal
     *            要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static  List<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            //完成一个课后思考题:
            /*
             * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
             * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
             *
             * 思路分析
             * 1. 在找到mid 索引值，不要马上返回
             * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
             * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
             * 4. 将Arraylist返回
             */

            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                } else {
                    resIndexlist.add(temp);
                    temp -= 1;
                }
            }
            resIndexlist.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                } else {
                    resIndexlist.add(temp);
                    temp += 1;
                }
            }
            return resIndexlist;
        }
    }
}


