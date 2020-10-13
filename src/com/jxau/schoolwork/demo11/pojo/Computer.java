package com.jxau.schoolwork.demo11.pojo;

import java.util.Random;
import java.util.Scanner;

public class Computer {

    private String ComputerName; //电脑姓名
    private int integral;//积分

    public String getComputerName() {
        return ComputerName;
    }

    public void setComputerName(String computerName) {
        ComputerName = computerName;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    //出拳
    public int punches() {
        Scanner input = new Scanner(System.in);
        Random ra = new Random();
        double q = ra.nextInt(10);
        //System.out.println(q);
        int p = (int) q % 3 + 1;
        System.out.print(getComputerName() + "出拳：");
        if (p == 1) {
            System.out.println("剪刀");
        } else if (p == 2) {
            System.out.println("石头");
        } else if (p == 3) {
            System.out.println("布");
        }
        return p;
    }
}
