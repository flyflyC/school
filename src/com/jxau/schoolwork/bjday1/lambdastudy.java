package com.jxau.schoolwork.bjday1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lambdastudy {
    public static void main(String[] args) {
        //System.out.println("没有传参，没有输出");
        lambdaInter lambdaInter1 = () -> System.out.println("没有传参，没有输出");
        lambdaInter1.NoReturnPara();
        /*List<String> list=new ArrayList<String>();
        Collections.addAll(list,"zhangsan","lisi","wangwu","zhaoliu");
        System.out.println(list);
        list.stream().filter((s)->s.startsWith("z"))
                        .filter((s)->s.length()==7)
                        .forEach(System.out::println);*/

        //Check if the given string is a valid string literal.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String str = input;
        char start = 34;
        str = str.replace("\"", "");
        System.out.println(str);
        //if(input.length()-str.length()==2){
        if (str.length() > 0 && !str.contains("\"")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public int add(int a, int b) {
        System.out.println("这是一个加法！");
        return a + b;
    }
}
