package com.jxau.schoolwork;

import com.jxau.schoolwork.demo11.ManMachineGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DayOne dayOne = new DayOne();
        DayTwo dayTwo = new DayTwo();
        ManMachineGame manMachineGame = new ManMachineGame();
        daythree daythree = new daythree();
        leetCode leetCode = new leetCode();
        //int[] arr={1,2,3,4,5,6,7};
        Scanner input = new Scanner(System.in);

        //leetCode.FindKthToTail();
        /*int memberCount=input.nextInt();
        int CarCount=input.nextInt();
        int[] arr=new int[47];
        for (int i=0;i<47;i++){
            arr[i]=i+1;
        }
        String[] strings= daythree.day9_1(47,4,arr);
        for (int i=strings.length-1;i>=0;i--){
            System.out.print(strings[i]);
        }*/
        //daythree.reOrderArray(arr);
        //int n=daythree.returnMin(123456789);
        //int n=daythree.solution(0,1);
        //System.out.println(n);


        /*int[] arr={1,-2,4,-5,6,-7};
        System.out.println(daythree.returnMax(arr));*/
        //输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
        //System.out.println(daythree.NumberOf1(-3));
        //成绩分级
       /* Scanner scanner = new Scanner(System.in);
        int score=scanner.nextInt();
        System.out.println(dayOne.swichDemo(score));*/

        //打印九九乘法表
        //dayOne.printMulTable();

        //输出100元买100只鸡的解决方法
        //dayOne.solution();

        //输出2~1000的素数
        //dayOne.primeNumber();

        //求1至1000之间的所有“完全数”，
        //dayOne.PerfectNumber();
       /* int i=2;               //++在前：参数加1；++在后：先取参数值在加一
        int j=3;
        System.out.println(i++);
        System.out.println(--j);*/

        //逆序输出五句话
        /*String[] s={"story第一句","qwert，第二句","第三句chklr","第四句,et","第五句，eurggl"};
        dayTwo.ReversedOrder(s);*/

        //输入5个积分。打印出最低积分，和所在的位置。
        /*Scanner input = new Scanner(System.in);
        int[] arr=new int[5];
        for (int i=0;i<5;i++){
            arr[i]=input.nextInt();
        }
        dayTwo.printMinIntegral(arr);*/
        //统计非法数字。
        /*Scanner input = new Scanner(System.in);
        int[] arr=new int[10];
        for (int i=0;i<arr.length;i++){
            arr[i]=input.nextInt();
        }
        dayTwo.illegalStatistics(arr);*/
        //dayTwo.twoArr();
        //manMachineGame.Game();
        //System.out.println(dayOne.enchage(94));
    }
}
