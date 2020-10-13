package com.jxau.schoolwork;

public class DayOne {
    /**
     * 由命令行输入一个成绩a,使用switch结构求出a的等级。A:90－100，B:80－89，C:70－79，D:60－69，E:0－59。
     *
     * @param score
     * @return
     */
    public char swichDemo(int score) {
        char grade = ' ';
        switch (score / 10) {
            case 10:
                grade = 'A';
                break;
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                grade = 'E';
                break;
            //default:grade='E';
        }
        return grade;
    }

    /**
     * 打印出如下九九乘法表
     * 1
     * 2   4
     * 3   6  9
     * 4   8  12  16
     * 5  10  15  20  25
     * 6  12  18  24  30  36
     * 7  14  21  28  35  42  49
     * 8  16  24  32  40  48  56  64
     * 9  18  27  36  45  54  63  72  81
     */
    public void printMulTable() {
        int result;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                result = i * j;
                System.out.print(result + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 已知公鸡5元1只，母鸡3元一只，小鸡1元3只，要求用100元刚好买100只鸡，问有多少种采购方案。
     */
    public void solution() {
        int i, j, k;   //i=公鸡；j=母鸡；k=小鸡。
        for (i = 0; i < 20; i++) {
            for (j = 0; j < 33; j++) {
                for (k = 3; k < 100; k += 3) {
                    if (5 * i + 3 * j + k / 3 == 100 && i + j + k == 100) {
                        System.out.print("公鸡：" + i);
                        System.out.print("  母鸡：" + j);
                        System.out.println("  小鸡：" + k);
                    }
                }
            }
        }
    }

    //求2-1000内的所有素数。
    public void primeNumber() {
        int count = 0;
        boolean judge = false;
        for (int i = 2; i < 1000; i++) {
            judge = true;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && j != 1) {
                    judge = false;
                }
            }
            if (judge) {
                count++;
                System.out.print(i + "\t");
                if (count % 8 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("2~1000共有素数：" + count);
    }

    /**
     * 求1至1000之间的所有“完全数”，
     * “完全数”是该数的所有因子之和等于该数的数。例如：6的因子有1、2、3且6=1+2+3，所以6是完全数。
     */
    public void PerfectNumber() {
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            int temp = 0;
            for (int j = 1; j < i / 2 + 1; j++) {
                if (i % j == 0) {
                    temp += j;
                }
            }
            if (temp == i) {
                count++;
                System.out.print(i + "\t");
            }
        }
        System.out.println("1~1000共有完全数：" + count);
    }

    public int enchage(int x) {
        int add = 0;
        if (x < 2) {
            return 0;
        } else if (x == 2) {
            return 1;
        } else {
            add = x / 3;
            int i = x % 3;
            add += enchage(add + i);
            return add;
        }
    }
}