package com.goinhn.algorithm.sort;

/**
 * <p>
 * 快速排序
 * </p>
 * <p>
 * 时间复杂度 O(N*logN)
 * 空间复杂度 O(logN)
 * </P>
 *
 * @author goinhn
 * @date 2020-08-23T23:30:04
 */
public class QuickSort {

    /**
     * 经典快速排序
     * 只有区分 <= 和 = 两个部分，标志选择为数组固定的一个位置
     */
    public static class ClassicQuickSort {

        /**
         * 初始条件判断
         *
         * @param arr
         */
        public static void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            quickSort(arr, 0, arr.length - 1);
        }

        /**
         * 快速排序
         * 递归进行
         *
         * @param arr
         * @param l
         * @param r
         */
        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }

            int separate = searchSwap(arr, l, r);
            quickSort(arr, l, separate - 1);
            quickSort(arr, separate + 1, r);
        }

        /**
         * 根据标志数据的大小将小的数放置到左边，大的数放置到右边
         *
         * @param arr
         * @param l
         * @param r
         */
        public static int searchSwap(int[] arr, int l, int r) {
            // 设置标志的位置，统一将标志位设置为数组的最后一个数
            int flag = r;
            while (l < r) {
                if (arr[l] < arr[flag]) {
                    l++;
                } else {
                    if (arr[r] >= arr[flag]) {
                        r--;
                    } else {
                        swap(arr, l++, r);
                    }
                }
            }

            swap(arr, l, flag);
            return l;
        }

        /**
         * 交换方法
         *
         * @param arr
         * @param x
         * @param y
         */
        public static void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        public static void main(String[] args) {
            int[] arr = new int[]{1, 1, 1, 1, 2, 1, 2};
            quickSort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }

    }


    /**
     * 在经典的快速排序上增加了中间相等的部分，划分为三个区域
     */
    public static class NewQuickSort {

        /**
         * 初始条件判断
         *
         * @param arr
         */
        public static void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            quickSort(arr, 0, arr.length - 1);
        }

        /**
         * 快速排序
         * 递归进行
         *
         * @param arr
         * @param l
         * @param r
         */
        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }

            // 中间相等的部分的分隔，第一个数为相等的左侧边界，第二个数为右侧相等的部分
            int[] equalSeparates = searchSwap(arr, l, r);
            quickSort(arr, l, equalSeparates[0] - 1);
            quickSort(arr, equalSeparates[1] + 1, r);
        }

        /**
         * 根据标志数据的大小将小的数放置到左边，大的数放置到右边
         *
         * @param arr
         * @param l
         * @param r
         */
//        public static int[] searchSwap(int[] arr, int l, int r) {
//            // 设置标志的位置，统一将标志位设置为数组的最后一个数
//            int num = arr[r];
//            int less = l - 1;
//            int more = r + 1;
//            int current = l;
//
//            while (current < more) {
//                if (arr[current] < num) {
//                    swap(arr, ++less, current++);
//                } else if (arr[current] > num) {
//                    swap(arr, --more, current);
//                } else {
//                    current++;
//                }
//            }
//
//            return new int[]{less + 1, more - 1};
//        }
        public static int[] searchSwap(int[] arr, int l, int r) {
            int less = l - 1;
            int more = r;
            while (l < more) {
                if (arr[l] < arr[r]) {
                    swap(arr, ++less, l++);
                } else if (arr[l] > arr[r]) {
                    swap(arr, --more, l);
                } else {
                    l++;
                }
            }
            swap(arr, more, r);
            return new int[]{less + 1, more};
        }

        /**
         * 交换方法
         *
         * @param arr
         * @param x
         * @param y
         */
        public static void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        public static void main(String[] args) {
            int[] arr = new int[]{1, 2, 3, 1, 5, 6, 3, 2, 1, 0};
            quickSort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }

    }

    /**
     * 随机快速排序，标志位的选择为随机，符合概率分布
     */
    public static class RandomQuickSort {

        /**
         * 初始条件判断
         *
         * @param arr
         */
        public static void quickSort(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }

            quickSort(arr, 0, arr.length - 1);
        }

        /**
         * 快速排序
         * 递归进行
         *
         * @param arr
         * @param l
         * @param r
         */
        public static void quickSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }

            // 随机选择标志位，和最后一个位置的数进行对换
            swap(arr, r, (int) (Math.random() * (r - l + 1)) + l);
            int[] equalSeparates = searchSwap(arr, l, r);
            quickSort(arr, l, equalSeparates[0] - 1);
            quickSort(arr, equalSeparates[1] + 1, r);
        }

        /**
         * 根据标志数据的大小将小的数放置到左边，大的数放置到右边
         *
         * @param arr
         * @param l
         * @param r
         */
//        public static int[] searchSwap(int[] arr, int l, int r) {
//            // 设置标志的位置，统一将标志位设置为数组的最后一个数
//            int num = arr[r];
//            int less = l - 1;
//            int more = r;
//            int current = l;
//
//            while (current < more) {
//                if (arr[current] < num) {
//                    swap(arr, ++less, current++);
//                } else if (arr[current] > num) {
//                    swap(arr, --more, current);
//                } else {
//                    current++;
//                }
//            }
//
//            return new int[]{less + 1, more - 1};
//        }
        public static int[] searchSwap(int[] arr, int l, int r) {
            int less = l - 1;
            int more = r;
            while (l < more) {
                if (arr[l] < arr[r]) {
                    swap(arr, ++less, l++);
                } else if (arr[l] > arr[r]) {
                    swap(arr, --more, l);
                } else {
                    l++;
                }
            }
            swap(arr, more, r);
            return new int[]{less + 1, more};
        }

        /**
         * 交换方法
         *
         * @param arr
         * @param x
         * @param y
         */
        public static void swap(int[] arr, int x, int y) {
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        public static void main(String[] args) {
            int[] arr = new int[]{1, 2, 3, 1, 5, 6, 3, 2, 1, 0};
            quickSort(arr);
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }
}
