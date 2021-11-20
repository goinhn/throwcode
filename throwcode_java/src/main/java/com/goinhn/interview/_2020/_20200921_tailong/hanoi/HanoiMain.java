package com.goinhn.interview._2020._20200921_tailong.hanoi;

/**
 * <p>
 * 本方法建立在以下三个基本理论上面，若这些理论无效，则无法通过这种方式解出。
 * 1.汉诺塔的总步数为2^n-1。
 * 2.汉诺塔的移动第一步总是将顶盘（最小盘top），以A>>B>>C>>A>>B>>C……的顺序移动一步。
 * 3.汉诺塔第二部移动总是在非顶盘（not-top）的两个柱间进行移动。若其中一个为空柱，则移动到空柱。否则，将小盘移动到大盘。
 * 重复第2、3两部，当移动步数等于2^n-1的时候，则移动结束。
 * 注意，若n为奇数的时候，实际移动结果为，所有的盘都移动到了B柱位置。此时只需要在移动前，将B和C交换(B和C对应的引用交换一下)位置即可。
 * 介于所有的实现，都必须是建立在以上的基础理论上。所以其实仅仅是把这种现实方法转换成计算机方法而已。
 * 只需要用计算机方法描述该过程就可以了。
 * </p>
 *
 * @author goinhn
 * @date 2020-09-22T01:00:28
 */
public class HanoiMain {
    /**
     * 圆盘层数
     */
    public int n;

    /**
     * 总共的步数
     */
    public int step;

    /**
     * a柱
     */
    public HanoiHelper a;

    /**
     * b柱
     */
    public HanoiHelper b;

    /**
     * c柱
     */
    public HanoiHelper c;

    public HanoiMain() {

    }


    public void hanoiMain(int n, String a, String b, String c) {
        //关键点01：汉诺塔的总步数为2^n-1。若没有这个结论的话，则本方法无效。
        step = (int) (Math.pow(2, n) - 1);
        this.a = new HanoiHelper(a, n);
        this.b = new HanoiHelper(b);
        this.c = new HanoiHelper(c);
        this.n = n;
        //如果n为奇数，则将b和c交换。
        if (n % 2 != 0) {
            HanoiHelper temp = this.b;
            this.b = this.c;
            this.c = temp;
        }
        //每次循环移动2步骤，首先移动top，其次移动not top。
        while (step > 0) {
            //以下是移动的第一步top判断和移动。需参考HanoiHelper类进行理解。
            if (this.a.top()) {
                list();
                this.a.moveTo(this.b);
                step--;
            } else if (this.b.top()) {
                list();
                this.b.moveTo(this.c);
                step--;
            } else if (this.c.top()) {
                list();
                this.c.moveTo(this.a);
                step--;
            }
            //因step是奇数，而最终移动完成后step=0；
            //同时可以理解的是最后一次移动一定是top的移动，所以本循环需要在此处跳出。
            if (step == 0) {
                break;
            }

            //以下是移动的第二步not top的判断和移动。需参考HanoiHelper进行理解。
            if (this.a.top()) {
                if (this.b.arr.size() == 0) {
                    list();
                    this.c.moveTo(this.b);
                    step--;
                } else if (this.c.arr.size() == 0) {
                    list();
                    this.b.moveTo(this.c);
                    step--;
                } else if (this.b.getDiskSize() > this.c.getDiskSize()) {
                    list();
                    this.c.moveTo(this.b);
                    step--;
                } else {
                    list();
                    this.b.moveTo(this.c);
                    step--;
                }
            } else if (this.b.top()) {
                if (this.a.arr.size() == 0) {
                    list();
                    this.c.moveTo(this.a);
                    step--;
                } else if (this.c.arr.size() == 0) {
                    list();
                    this.a.moveTo(this.c);
                    step--;
                } else if (this.a.getDiskSize() > this.c.getDiskSize()) {
                    list();
                    this.c.moveTo(this.a);
                    step--;
                } else {
                    list();
                    this.a.moveTo(this.c);
                    step--;
                }
            } else if (this.c.top()) {
                if (this.a.arr.size() == 0) {
                    list();
                    this.b.moveTo(this.a);
                    step--;
                } else if (this.b.arr.size() == 0) {
                    list();
                    this.a.moveTo(this.b);
                    step--;
                } else if (this.a.getDiskSize() > this.b.getDiskSize()) {
                    list();
                    this.b.moveTo(this.a);
                    step--;
                } else {
                    list();
                    this.a.moveTo(this.b);
                    step--;
                }
            }
        }
    }

    /**
     * 打印出当前每个柱的圆盘结构。需要结合HnoiPillar类来理解。
     */
    public void list() {
        if (n % 2 == 0) {
            System.out.print(this.a.name + "柱：" + this.a.getStore() +
                    "		" + this.b.name + "柱：" + this.b.getStore() +
                    "		" + this.c.name + "柱：" + this.c.getStore() + "			");
        } else {
            System.out.print(this.a.name + "柱：" + this.a.getStore() +
                    "		" + this.c.name + "柱：" + this.c.getStore() +
                    "		" + this.b.name + "柱：" + this.b.getStore() + "			");
        }
    }
}
