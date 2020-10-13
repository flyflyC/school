package com.jxau.schoolwork.demo11;

import com.jxau.schoolwork.demo11.pojo.Computer;
import com.jxau.schoolwork.demo11.pojo.User;

import java.util.Scanner;

public class ManMachineGame {
    String playerOne;
    String playerTwo;
    int time = 0;

    public void Game() {
        User user = new User();
        Computer computer = new Computer();
        int role = 0;
        int ug = 0;
        int cg = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("---------------------------------欢迎进入 游戏世界---------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t***********************************\t\t\t");
        System.out.println("\t\t\t\t\t\t**   猜拳  ， 开始     **\t\t\t\t\t");
        System.out.println("\t\t\t***********************************\t\t\t");
        System.out.println();
        System.out.println();
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
        System.out.print("请选择对方角色：（1：刘备；2：孙权；3：曹操）：");

        int p = 0;
        boolean judge = true;
        //选择对方角色
        while (judge) {
            p = in.nextInt();
            if (p == 1) {
                judge = false;
                playerOne = "刘备";
            } else if (p == 2) {
                judge = false;
                playerOne = "孙权";
            } else if (p == 3) {
                judge = false;
                playerOne = "曹操";
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        //玩家B（User）
        System.out.print("请输入你的名字：");
        String username = in.next();
        playerTwo = username;
        user.setUserName(playerTwo);

        computer.setComputerName(playerOne);
        System.out.println("你选择了" + computer.getComputerName() + "对战");
        System.out.println();

        //循环游戏
        System.out.print("要开始吗？（Y/N）");
        String isGame = in.next();
        System.out.println();

        while (isGame.equals("Y") || isGame.equals("y")) {
            int u = user.punches();
            int c = computer.punches();
            time++;
            if (u == c) {
                System.out.println("和局");
            } else if ((u == 3 && c == 1)) {
                cg++;
                System.out.println("你输了");
            } else if (u == 1 && c == 3) {
                ug++;
                System.out.println("你赢了");
            } else if (u < c) {
                cg++;
                System.out.println("你输了");
            } else if (c < u) {
                ug++;
                System.out.println("你赢了");
            }
            System.out.print("是否下一轮（Y/N）：");
            isGame = in.next();
        }
        user.setIntegral(ug);
        computer.setIntegral(cg);
        System.out.println("---------------------------------------------------------------");
        System.out.println(user.getUserName() + "  VS  " + computer.getComputerName());
        System.out.println("对战次数：" + time);
        if (user.getIntegral() > computer.getIntegral()) {
            System.out.println("恭喜你赢了！");
        } else if (user.getIntegral() == computer.getIntegral()) {
            System.out.println("平局");
        } else {
            System.out.println("你输了");
        }
    }
}
