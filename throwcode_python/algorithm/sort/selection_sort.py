#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/2/26 23:37

def selection_sort(arr):
    """
    选择排序
    :param arr: 待排序的数组
    :return:
    """
    if arr is None or len(arr) < 2:
        return
    for i in range(len(arr) - 1):
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]


def main():
    arr = [2, 3, 1, 5, 4]
    selection_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
