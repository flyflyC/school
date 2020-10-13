package com.jxau.schoolwork;

import java.util.Scanner;

public class DayTwo {

    /**
     * 逆序输出5句话
     * 首先创建数组。放5句话。
     * 逆序打印出来。
     */
    public void ReversedOrder(String[] strs) {
        System.out.println("逆序前：");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println("逆序后：");
        for (int i = strs.length - 1; i >= 0; i--) {
            System.out.println(strs[i]);
        }
    }

    /**
     * 输入5个积分。
     * 打印出最低积分，和所在的位置。
     */
    public void printMinIntegral(int[] arr) {
        int temp = arr[0];
        int index = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (temp > arr[i]) {
                temp = arr[i];
                index = i;
            }
        }
        System.out.println("最小积分为：" + temp + "  位置：" + index);
    }

    /**
     * 统计非法数字。
     * 用户输入10个数字，其中1,2,3才是合法数字。
     * 其他不合法。
     * 打印出1，2，3分别的个数，和非法数字的个数。
     */
    public void illegalStatistics(int[] arr) {
        int one = 0;
        int two = 0;
        int three = 0;
        int illegal = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                one++;
            } else if (arr[i] == 2) {
                two++;
            } else if (arr[i] == 3) {
                three++;
            } else {
                illegal++;
            }
        }
        System.out.println("1的个数：" + one);
        System.out.println("2的个数：" + two);
        System.out.println("3的个数：" + three);
        System.out.println("非法数字个数：" + illegal);
    }

    /**
     * 输入初一年级的成绩存储到二维数组中
     * 初一年级一共有3个班;第一个班5个人;第二个班7个人;第三个班4个人
     * 把他们的成绩装入二维数组中
     */
    public void twoArr() {
        int[][] arr = new int[3][];
        arr[0] = new int[5];
        arr[1] = new int[7];
        arr[2] = new int[4];
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个班成绩");
        for (int a = 0; a < 5; a++) {
            arr[0][a] = input.nextInt();
        }
        System.out.println("请输入第二个班成绩");
        for (int b = 0; b < 7; b++) {
            arr[1][b] = input.nextInt();
        }
        System.out.println("请输入第三个班成绩");
        for (int c = 0; c < 4; c++) {
            arr[2][c] = input.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + 1 + "个班成绩为：");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "/t");
            }
            System.out.println();
        }
    }
}

