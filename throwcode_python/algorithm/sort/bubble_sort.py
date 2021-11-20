#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/2/25 23:57

def bubble_sort(arr):
    """
    冒泡排序
    :param arr: 待排序的数组
    :return:
    """
    if arr is None or len(arr) < 2:
        return
    for i in range(len(arr) - 1):
        for j in range(len(arr) - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]


def main():
    arr = [2, 3, 1, 5, 4]
    bubble_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
