package com.jxau.schoolwork;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。
 * 输 入:薯券金额、商品分别价格
 * 输出 :组合数
 */
public class daythree {
    Scanner scanner = new Scanner(System.in);
   /* int ticket=scanner.nextInt();
    String commodity= scanner.nextLine();
    String[] arr=commodity.split(",");*/

    /**
     * 返回数组连续相加的几个数字的最大和
     *
     * @param arr
     * @return
     */
    public int returnMax(int[] arr) {
        int sum = 0;
        int temp = 0;
        int[] nums = arr;
        int[] sums = new int[nums.length * nums.length];

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums[temp] = sum;
                temp++;

            }
            System.out.println(Arrays.toString(sums));
        }
        sum = sums[0];
        for (int i = 0; i < sums.length - 1; i++) {
            sum = sum > sums[i] ? sum : sums[i];
        }
        return sum;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {  //一步只有一种方法
            return 1;
        } else if (target == 2) {   //两步则有两种方法
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);   //每走一步的方法数量相加则为所以方法
        }
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        /**
         *分析：青蛙跳上n个台阶（n>1）有两种一种直接跳上n阶，一种跳到n-1阶，当n==1时只有一种跳法
         *因此当n大于1时，每一阶有两种方法
         */
        if (target == 0) {
            return 0;
        } else if (target == 1) {  //一步只有一种方法
            return 1;
        } else {
            return JumpFloorII(target - 1) * 2;
        }
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {  //查找空格的个数
            if (str.charAt(i) == ' ')
                index++;
        }
        int newlength = str.length() + index * 2;  //定义一个新字符串的长度
        for (int i = 0; i < newlength; i++) {
            if (str.charAt(i) == ' ') {
                str.delete(i, i + 1);  //删除空格
                str.insert(i, "%20");//插入%20
            }
        }
        String s = str.toString();
        return s;
    }

    /**
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     * 原码转补码 =》原码取反后加一
     * toBinaryString(int n)方法：将n转换为二进制并以字符串形式输出
     * replaceAll("0","")方法：将字符串中的0全部替换为空；即去掉字符串中的0
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double sum = 0;
        if (base == 0.0) {
            return 0;
        }
        if (exponent == 0) {
            sum = 1;
        } else if (exponent == 1) {
            sum = base;
        } else if (exponent > 0) {
            sum = base;
            while (exponent > 1) {
                sum = sum * base;
                exponent--;
            }
        } else {
            sum = 1 / base;
            while (exponent < -1) {
                sum = sum * (1 / base);
                exponent++;
            }
        }
        return sum;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int index = 0;//存取已经插入排序好的奇数个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                for (int j = i; j > index; j--) {//如果奇数位置和当前循环遍历到的数组下标位置不一致，则把奇数插入到偶数前面
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                index++;
                System.out.println(Arrays.toString(array));
            }
        }
    }

    /**
     * 实现方案
     *
     * @param m int整型 最少m个键
     * @param n int整型 最多n个键
     * @return int整型
     */
    public int solution(int m, int n) {
        // write code here
        if (n == 0 && n == 0) {
            return 0;
        }
        int minf = 1;
        int maxf = 1;
        int result = 0;
        if (m == 0 && n == 1) {
            return 9;
        }
        if (n > m) {
            for (int i = 9; i > 9 - m; i--) {
                minf = minf * i;
            }
            for (int i = 9 - n + 1; i > 9 - n - 1; i--) {
                maxf = maxf * i;
            }
        }
        result = minf + maxf;
        return result;
    }

    /**
     * 输入一个整形数值，返回一个整形值
     *
     * @param n int整型 n>9
     * @return int整型
     */
    public int returnMin(int n) {
        if (n < 9) {
            System.out.println("输入错误，请输入大于9的数字");
            return 0;
        }
        int temp = n; //存储n的值
        int reMin = 0;//存储最大的约数
        int reValue = 0;//存储返回值
        int comperaN = 1;//存储和n比较大小的值
        for (int i = 0; i < 9; i++) {
            if (temp != comperaN) {
                if (n % 9 == 0) {
                    n = n / 9;
                    reMin = 9;
                } else if (n % 8 == 0) {
                    n = n / 8;
                    reMin = 8;
                } else if (n % 7 == 0) {
                    n = n / 7;
                    reMin = 7;
                } else if (n % 6 == 0) {
                    n = n / 6;
                    reMin = 6;
                } else if (n % 5 == 0) {
                    n = n / 5;
                    reMin = 5;
                } else if (n % 4 == 0) {
                    n = n / 4;
                    reMin = 4;
                } else if (n % 3 == 0) {
                    n = n / 3;
                    reMin = 3;
                } else if (n % 2 == 0) {
                    n = n / 2;
                    reMin = 2;
                } else if ((n % 1 == 0 && comperaN == temp)) {
                    return reValue;
                } else if (n % 1 == 0 && comperaN != temp) {
                    return -1;
                } else {
                    return -1;
                }
            } else {
                return reValue;
            }
            comperaN = reMin * comperaN;
            reValue = (int) (reValue + reMin * (Math.pow(10, i)));
        }
        return reValue;
    }

    /**
     * @param n int整型 第n天
     * @return int整型
     */
    public int NumberPhone(int n) {
        // write code here
        int i, j;
        int temp = n;
        int k = 0;
        int num = 0;
        StringBuffer s;
        if (k < n) {
            for (j = 1; k + j <= n; j = j + 1) {
                k = k + j;
                num = num + j * j;
            }
            temp = n - k;
            num = num + (temp * j);
        } else {
            return num;
        }
        return num;
    }

    /**
     * 某天猿辅导 HR 组织大家去漂流，早上，参加团建的同学都到齐了，并且按到达公司的先后顺序排好队了。 由于员工太多，一个大巴车坐不下，需要分多个车，车是足够的，但所有人需要按一定顺序上车，按如下规则安排上车的顺序：
     * 假设大巴车容量为 m，从队首开始，每 m 个人分成一个小组，每个小组坐一辆车。同时只有一个车打开车门供员工上车。 小组之间按从队尾到队首顺序依次上车，同一小组内先到的同学先上，求所有人上车的顺序。
     * <p>
     * 例如： 员工数 8， 车容量 3， 员工到达顺序为 1 2 3 4 5 6 7 8， 3个人一个小组，分三个小组， 小组一： 1， 2， 3， 小组二： 4， 5， 6，小组三： 7，8。 小组上车顺序为： 小组三，小组二，小组一 。 所有员工上车顺序为 7 8 4 5 6 1 2 3
     *
     * @param e
     * @param c
     * @param arr
     * @return
     */
    public String[] day9_1(int e, int c, int[] arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        int index = 0;
        int t = e;//暂存员工数量
        String[] strings = new String[e / c + 1];
        for (int i = 0; i < e; i += c, t -= c) {
            for (int j = i; j < c + i && j < e; j++) {
                int x = arr[j];
                q.add(arr[j]);

            }
            String s = "";
            if (t > c) {
                int[] temp = new int[c];
                for (int k = 0; k < c; k++) {
                    //temp[k]=q.poll();
                    s = s + q.poll() + " ";
                }
                //strings[index] = temp.toString();
                //System.out.println(s);
                strings[index] = s;
            } else {
                int[] temp = new int[t % c];

                for (int k = 0; k < t % c; k++) {
                    //temp[k] = q.poll();
                    s = s + q.poll() + " ";
                }
                //System.out.println(s);
                strings[index] = s;
            }
            index++;
        }

        return strings;
    }
    /**
     *
     */
}


