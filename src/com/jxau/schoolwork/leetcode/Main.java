package com.jxau.schoolwork.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @description:
 * @author: caifeifei
 * @createDate: 2020-10-13
 * @version: 1.0
 */

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^

     */
    /******************************开始写代码******************************/
    static int buyCoke(int m, int a, int b, int c, int x) {
        int count = 0;
        int total = m*x;
        int temp=0;
        int money=100*c+50*b+10*a;
        if (m<=0){
            return count;
        }

        if(total>money){
            return count;
        }
        if (total==money){
            return a+b+c;
        }else {
            while (temp<total && m>0){
                if(x/100<c){
                    if (x/100==0 && x/100<=c){
                        temp=x;
                        c-=x/100;
                        count+=x/100;
                        m--;
                    }else if(x/100==0 && x/100<c){
                        temp=100*c;
                        x=x-temp;
                        if (x/50<=b){
                            temp+=x;
                            b-=x/50;
                            count+=x/50;
                            m--;
                        }else if(x/50>b){
                            count+=x/10;
                            m--;
                        }
                    }else if(x/100 != 0 && x/100<c-1){
                        int y=x%100;
                        if (x/100<c-1 && y>50){
                            temp+=x;
                            count+=(x/100)+1;
                            a+=(100-y)/10;
                            m--;
                        }else if(x/100<c-1 && y<=50){
                            temp+=x;
                            count+=(x/100)+1;
                            b++;
                            a+=(100-y-50)/10;
                            m--;
                        }
                    }

                }else if(x/100>c && (x-100*c)/50<b){
                    if(x%100==0){
                        x=x-100*c;
                        count+=c;
                        b-=x/50;
                        count+=x/50;
                        temp+=x;
                        m--;
                    }else if(x%100 !=0 && (x-100*c)/50<b-1){
                        x=x-100*c;
                        count+=c;
                        b-=(x/50+1);
                        a+=(50-x%50)/10;
                        temp+=x;
                        count+=b+1;
                        m--;
                    }
                }
            }
        }

        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        /*Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));
*/
        ArrayList<Integer> imm = new ArrayList<>();
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            imm.add(incomeOfA);
            imm.add(incomeOfB);
            System.out.println(cin+"===="+incomeOfA);
            //Start coding -- Input Data
        }
        int[][] arr = new int[2][imm.size()];
        for (int i=0;i<imm.size();i++){
            arr[1][i]=imm.get(i);
        }

    }
}
