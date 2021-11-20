#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/3/1 16:29

def heap_sort(arr):
    """
    堆排序
    :param arr: 待排序的数组
    :return:
    """
    if arr is None or len(arr) < 2:
        return

    for i in range(1, len(arr)):
        heap_insert(arr, i)

    end = len(arr) - 1
    arr[0], arr[end] = arr[end], arr[0]
    while end > 0:
        heapify(arr, 0, end)
        end = end - 1
        arr[0], arr[end] = arr[end], arr[0]


def heap_insert(arr, index):
    """
    构建大顶堆的过程
    :param arr:
    :param index:
    :return:
    """
    while arr[index] > arr[(index - 1) // 2]:
        arr[index], arr[(index - 1) // 2] = arr[(index - 1) // 2], arr[index]
        index = (index - 1) // 2


def heapify(arr, index, end):
    """
    堆化的过程
    :param arr:
    :param index: 堆化数组的左边界，堆的头结点
    :param end:  堆化数组的右边界，堆的尾部
    :return:
    """
    left = index * 2 + 1
    while left < end:
        largest = left + 1 if left + 1 < end and arr[left] < arr[left + 1] else left
        largest = left if arr[index] < arr[left] else index
        if largest == index:
            break

        arr[index], arr[largest] = arr[largest], arr[index]
        index = largest
        left = index * 2 + 1


def main():
    arr = [2, 3, 1, 5, 4]
    heap_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
