package com.goinhn.interview._2020._20200921_tailong.hanoi;

import java.util.ArrayList;


/**
 * <p>
 * 汉诺塔非递归实现
 * </p>
 *
 * @author goinhn
 * @date 2020-09-22T00:55:25
 */
public class HanoiHelper {

    /**
     * 用于传递hanoi的圆盘数量;
     */
    int n;

    /**
     * 记录柱子的名称。
     */
    public String name;

    /**
     * 记录柱子上的圆盘以及统计该柱子上圆盘数量（arr.size())。
     */
    ArrayList<Integer> arr = new ArrayList<>();

    public HanoiHelper() {

    }

    /**
     * 建立B柱和C柱时使用的构造方法。
     */
    public HanoiHelper(String name) {
        this.name = name;
    }

    /**
     * 仅用于第一次初始化第一柱A柱的构造方法。用于将n个圆盘添加到A柱的arr里。
     *
     * @param name
     * @param n
     */
    public HanoiHelper(String name, int n) {
        this.name = name;
        //此处的循环条件是n到1.因为n个圆盘的情况下，编号是1到n.没有0号。
        for (int i = n; i >= 1; i--) {
            this.arr.add(i);
        }
    }

    /**
     * 判断该柱子上方是否为顶盘top
     *
     * @return
     */
    public boolean top() {
        boolean result = false;
        //当当前柱子的arr.size() == 0 即说明该柱子上方没有圆盘。
        if (arr.size() == 0) {

        } else if (arr.get(arr.size() - 1).equals(1)) {
            result = true;
        }
        return result;
    }

    /**
     * 将当前柱子移动到下一个柱子。并打印移动流程。
     *
     * @param b
     */
    public void moveTo(HanoiHelper b) {
        //移动过程是b会增加一个圆盘。同时this会减少一个圆盘。一定是先增加，后减少。
        b.arr.add(this.getDiskSize());
        this.arr.remove(this.arr.size() - 1);
        System.out.println(this.name + ">>" + b.name);
    }

    /**
     * 得到该柱子下面存储的圆盘列表，转化为String。
     *
     * @return
     */
    public String getStore() {
        if (this.arr.size() == 0) {
            return null;
        } else {
            String result = "";
            for (int i = this.arr.size() - 1; i >= 0; i--) {
                result = result + this.arr.get(i) + ",";
            }
            result = result.trim();
            return result;
        }
    }

    /**
     * 得到该柱子下面最小的圆盘数值。以1、2、3、4、……、n来表示各圆盘的大小。方便比较。
     *
     * @return
     */
    public int getDiskSize() {
        return this.arr.get(this.arr.size() - 1);
    }

}
