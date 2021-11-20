#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/2/27 0:09

def shell_sort(arr):
    """
    希尔排序
    :param arr: 待排序的数组
    :return:
    """
    if arr is None or len(arr) < 2:
        return
    gap = len(arr) // 2
    while gap > 0:
        for i in range(gap):
            for j in range(gap, len(arr), gap):
                for m in range(j, len(arr), gap):
                    if arr[m] < arr[m - gap]:
                        arr[m], arr[m - gap] = arr[m - gap], arr[m]
                    else:
                        break
        gap = gap // 2


def main():
    arr = [2, 3, 1, 5, 4]
    shell_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
