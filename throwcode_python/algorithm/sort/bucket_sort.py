#!/use/bin/env/python3
# -*- coding:utf-8 -*-
# @author: goinhn
# @date: 2021/3/2 14:23

def bucket_sort(arr):
    if arr is None or len(arr) < 2:
        return
    min_value = arr[0]
    max_value = arr[0]
    for i in range(len(arr)):
        min_value = min(min_value, arr[i])
        max_value = max(max_value, arr[i])
    distance = -min_value
    bucket = [0] * (max_value - min_value + 1)
    for i in range(len(arr)):
        bucket[arr[i] + distance] = bucket[arr[i] + distance] + 1
    index = 0
    for i in range(len(bucket)):
        while bucket[i] > 0:
            arr[index] = i - distance
            index = index + 1
            bucket[i] = bucket[i] - 1


def main():
    arr = [2, 3, 1, 5, 4]
    bucket_sort(arr)
    for value in arr:
        print(value)


if __name__ == '__main__':
    main()
