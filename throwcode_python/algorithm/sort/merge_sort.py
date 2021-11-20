#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/2/27 0:17

def merge_sort(arr):
    """
    归并排序
    :param arr:
    :return:
    """
    if arr is None or len(arr) < 2:
        return
    merge_sort_recursion(arr, 0, len(arr) - 1)


def merge_sort_recursion(arr, l, r):
    if l == r:
        return

    m = (l + r) // 2
    merge_sort_recursion(arr, l, m)
    merge_sort_recursion(arr, m + 1, r)
    merge(arr, l, m, r)


def merge(arr, l, m, r):
    arr_temp = [None] * (r - l + 1)
    arr_temp_index = 0
    l_temp = l
    r_temp = m + 1
    while l_temp < m + 1 and r_temp < r + 1:
        if arr[l_temp] < arr[r_temp]:
            arr_temp[arr_temp_index] = arr[l_temp]
            l_temp = l_temp + 1
        else:
            arr_temp[arr_temp_index] = arr[r_temp]
            r_temp = r_temp + 1
        arr_temp_index = arr_temp_index + 1

    while l_temp < m + 1:
        arr_temp[arr_temp_index] = arr[l_temp]
        l_temp = l_temp + 1
        arr_temp_index = arr_temp_index + 1

    while r_temp < r + 1:
        arr_temp[arr_temp_index] = arr[r_temp]
        r_temp = r_temp + 1
        arr_temp_index = arr_temp_index + 1

    for i in range(len(arr_temp)):
        arr[l + i] = arr_temp[i]


def main():
    arr = [2, 3, 1, 5, 4]
    merge_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
