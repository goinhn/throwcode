#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/2/26 23:49

def insertion_sort(arr):
    """
    插入排序
    :param arr: 待排序的数组
    :return:
    """
    if arr is None or len(arr) < 2:
        return
    for i in range(1, len(arr)):
        for j in range(i, 0, -1):
            if arr[j] < arr[j - 1]:
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
            else:
                break


def main():
    arr = [2, 3, 1, 5, 4]
    insertion_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()