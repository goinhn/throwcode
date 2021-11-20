package com.goinhn.saima;

import java.util.Scanner;

/**
 * <p>
 * 股神
 * <p>
 * 有股神吗？
 * <p>
 * 有，小赛就是！
 * <p>
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 * <p>
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 * </p>
 *
 * @author goinhn
 * @date 2020-12-05T00:25:13
 */
public class StockGod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int day = scanner.nextInt();
            System.out.println(getPriceToday(day));
        }
    }

    public static int getPriceToday(int day) {
        if (day < 1 || day > 1000000000) {
            return -1;
        }

        int price = 1;
        int addDay = 1;
        int less = 1;
        while (day > 1) {
            if (less > 0) {
                price++;
                less--;
            } else {
                price--;
                addDay++;
                less = addDay;
            }
            day--;
        }

        return price;
    }

}
