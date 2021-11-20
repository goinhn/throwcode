#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/3/1 16:50

import random


class ClassicQuickSort(object):
    """经典快速排序

    只有区分 <= 和 = 两个部分，标志选择为数组固定的一个位置
    """

    def quick_sort(self, arr):
        if arr is None or len(arr) < 2:
            return
        self.quick_sort_main(arr, 0, len(arr) - 1)

    def quick_sort_main(self, arr, l, r):
        """
        快排递归
        :param arr:
        :param l:
        :param r:
        :return:
        """
        if l >= r:
            return
        separate = self.search_swap(arr, l, r)
        self.quick_sort_main(arr, l, separate - 1)
        self.quick_sort_main(arr, separate + 1, r)

    def search_swap(self, arr, l, r):
        """
        根据标志数据的大小，将小的数放置在左边，大的数放置在右边
        :param arr:
        :param l:
        :param r:
        :return:
        """
        flag = r
        while l < r:
            if arr[l] < arr[flag]:
                l = l + 1
            else:
                if arr[r] >= arr[flag]:
                    r = r - 1
                else:
                    arr[l], arr[r] = arr[r], arr[l]
                    l = l + 1
        arr[l], arr[flag] = arr[flag], arr[l]
        return l


class NewQuickSort(object):
    """在经典的快速排序上增加了中间相等的部分，划分为三个区域
    """

    def quick_sort(self, arr):
        if arr is None or len(arr) < 2:
            return
        self.quick_sort_main(arr, 0, len(arr) - 1)

    def quick_sort_main(self, arr, l, r):
        if l >= r:
            return
        left_separates, right_separates = self.search_swap(arr, l, r)
        self.quick_sort_main(arr, l, left_separates - 1)
        self.quick_sort_main(arr, right_separates + 1, r)

    # def search_swap(self, arr, l, r):
    #     num = arr[r]
    #     less = l - 1
    #     more = r + 1
    #     current = l
    #     while current < more:
    #         if arr[current] < num:
    #             less = less + 1
    #             arr[less], arr[current] = arr[current], arr[less]
    #             current = current + 1
    #         elif arr[current] < arr[num]:
    #             more = more -1
    #             arr[more], arr[current] = arr[current], arr[more]
    #         else:
    #             current = current + 1
    #     return less + 1, more - 1

    def search_swap(self, arr, l, r):
        """
        划分为小于等于和大于三个区域
        :param arr:
        :param l:
        :param r:
        :return:
        """
        less = l - 1
        more = r
        while l < more:
            if arr[l] < arr[r]:
                less = less + 1
                arr[less], arr[l] = arr[l], arr[less]
                l = l + 1
            elif arr[l] > arr[r]:
                more = more - 1
                arr[more], arr[l] = arr[l], arr[more]
            else:
                l = l + 1
        arr[more], arr[r] = arr[r], arr[more]
        return less + 1, more


class RandomQuickSort(object):

    def quick_sort(self, arr):
        if arr is None or len(arr) < 2:
            return
        self.quick_sort_main(arr, 0, len(arr) - 1)

    def quick_sort_main(self, arr, l, r):
        """
        增加比较位随机的部分
        :param arr:
        :param l:
        :param r:
        :return:
        """
        if l >= r:
            return
        random_index = random.randint(l, r)
        arr[random_index], arr[r] = arr[r], arr[random_index]
        left_separates, right_separates = self.search_swap(arr, l, r)
        self.quick_sort_main(arr, l, left_separates - 1)
        self.quick_sort_main(arr, right_separates + 1, r)

    def search_swap(self, arr, l, r):
        """划分为小于等于和大于三个区域
        :param arr:
        :param l:
        :param r:
        :return:
        """
        less = l - 1
        more = r
        while l < more:
            if arr[l] < arr[r]:
                less = less + 1
                arr[less], arr[l] = arr[l], arr[less]
                l = l + 1
            elif arr[l] > arr[r]:
                more = more - 1
                arr[more], arr[l] = arr[l], arr[more]
            else:
                l = l + 1
        arr[more], arr[r] = arr[r], arr[more]
        return less + 1, more


def main():
    arr = [2, 3, 1, 5, 4]
    # classic_quick_sort = ClassicQuickSort()
    # classic_quick_sort.quick_sort(arr)
    new_quick_sort = NewQuickSort()
    new_quick_sort.quick_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
