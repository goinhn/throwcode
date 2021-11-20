#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/3/2 11:13

import random
import algorithm.sort.bucket_sort as test_sort_single

"""
对数器测试排序算法
"""


def comparator(arr):
    list.sort(arr)


def generate_random_array(max_size, max_value):
    arr = [None] * random.randint(1, max_size)
    for i in range(len(arr)):
        arr[i] = random.randint(0, max_value) - random.randint(0, max_value)
    return arr


def copy_array(arr):
    if arr is None:
        return
    res = [None] * len(arr)
    for i in range(len(arr)):
        res[i] = arr[i]
    return res


def is_equal(arr1, arr2):
    if arr1 is None or arr2 is None:
        return False
    if len(arr1) != len(arr2):
        return False
    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False
    return True


def print_array(arr):
    if arr is None:
        return
    print(arr)


def test_main(test_time, max_size, max_value):
    succeed = True
    for i in range(test_time):
        arr1 = generate_random_array(max_size, max_value)
        arr2 = copy_array(arr1)
        test_sort_single.bucket_sort(arr1)
        comparator(arr2)
        if not is_equal(arr1, arr2):
            succeed = False
            break
    print('Nice!' if succeed else 'Fucking!')


def main():
    test_main(10000, 100, 100)


if __name__ == '__main__':
    main()
