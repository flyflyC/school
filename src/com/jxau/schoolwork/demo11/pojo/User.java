package com.jxau.schoolwork.demo11.pojo;

import java.util.Scanner;

public class User {
    private String UserName;  //使用着姓名
    private int integral;//积分

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    //出拳
    public int punches() {
        System.out.print("请出拳：1.剪刀 2.石头 3.布（输入相应的数字）：");
        Scanner input = new Scanner(System.in);
        int p = 0;
        boolean judge = true;
        while (judge) {
            p = input.nextInt();
            System.out.print("你出拳：");
            if (p == 1) {
                judge = false;
                System.out.println("剪刀");
            } else if (p == 2) {
                judge = false;
                System.out.println("石头");
            } else if (p == 3) {
                judge = false;
                System.out.println("布");
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
        return p;
    }
}
