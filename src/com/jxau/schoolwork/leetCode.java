package com.jxau.schoolwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetCode {
    public static void main(String[] args) {
        /*ListNode listNode=new ListNode(1);
        for (int i=2;i<10;i++){
            *//*while (listNode.next.next !=null){
                listNode=listNode.next;
            }*//*
            listNode.next.val=i;
        }
        ListNode result=FindKthToTail(listNode,4);
        System.out.println(result);*/

        /*int[] arr={2,1,3,4,6};
        String str=PrintMinNumber(arr);
        System.out.println(str);*/

        //丑数
        //System.out.println(GetUglyNumber_Solution(7));
        //返回字符串，无重复的下标
        // System.out.println(FirstNotRepeatingChar("google"));
        //两数相加不用+
        //System.out.println(Add(3, 8));
       /*
       int[] a={1,2,3,4,5};
        int[] b={4,5,3,2,1};
        boolean flag=IsPopOrder(a,b);
        System.out.println(flag);*/

       /* Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        IsString(input);*/

        NumberOf1Between1AndN_Solution(111);
        System.out.println(NumberOf1Between1AndN_Solution(123));
    }


    public static ListNode FindKthToTail(ListNode head, int k) {
        int length = 0;
        int temp = k;
        ListNode result = head;
        while (head != null) {
            length++;
            head = head.next;
            if (k < 1) {
                result = result.next;
            }
            k--;
        }
        if (length < temp) {
            return null;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        Stack<ListNode> temp = new Stack<ListNode>();
        ListNode p = head;
        ListNode result = null;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        for (int i = 0; i < length; i++) {
            temp.push(p);
            p = p.next;
            result = temp.pop();
        }

        return result;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        int temp = 0;
        int first = 0;
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String a = numbers[i] + "" + numbers[j];
                String b = numbers[j] + "" + numbers[j];
                if (Integer.valueOf(a) > Integer.valueOf(b)) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            str = str + numbers[i];
        }
        return str;
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 思路：用数组来存值；用丑数乘以2、 3和5还是一个丑数；用一个下标来表示每一个数乘到的位置，每次把最小的放入数组
     *
     * @param index
     * @return
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        List<Integer> UglyList = new ArrayList<Integer>();
        int a = 0, b = 0, c = 0, d = 0;
        UglyList.add(1);
        while (UglyList.size() < index) {
            int m1 = UglyList.get(a) * 2;
            int m2 = UglyList.get(b) * 3;
            int m3 = UglyList.get(c) * 5;
            int min = Math.min(m1, Math.min(m2, m3));
            UglyList.add(min);

            if (min == m1) {
                a++;
            }
            if (min == m2) {
                b++;
            }
            if (min == m3) {
                c++;
            }
        }
        return UglyList.get(index - 1);
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        //String letter;
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            int first = str.indexOf(str.charAt(i), 0);
            index = str.indexOf(str.charAt(i), i + 1);
            if (first == i && index < 0) {
                index = i;
                return index;
            }
        }
        return index;
    }

    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     * 两个数异或：相当于每一位相加，而不考虑进位；
     * 两个数相与，并左移一位：相当于求得进位；
     * 将上述两步的结果相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root2 == null || root1 == null) {
            return result;
        }
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = Tratree(root1, root2);
            }
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public static boolean Tratree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) return false;
        if (root2 == null) return true;
        if (root1.val != root2.val) return false;
        return Tratree(root1.left, root2.left) && Tratree(root1.right, root2.right);
    }
   /* //判断完全相对应可以考虑
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null){
            return false;
        }
        List<Integer> ProRoot1=new ArrayList<>();
        ProRoot1=preorder(root1);
        List<Integer> ProRoot2=new ArrayList<>();
        ProRoot2=preorder(root2);
        List<Integer> IndRoot1=new ArrayList<>();
        IndRoot1=indOrder(root1);
        List<Integer> IndRoot2=new ArrayList<>();
        IndRoot2=indOrder(root2);

        if (ProRoot1==ProRoot2 && IndRoot1==IndRoot2){
            return true;
        }
        if (root1.left != null){
            HasSubtree(root1.left,root2);
        }
        if (root1.right != null){
            HasSubtree(root1.right,root2);
        }
        return false;
    }

    public static List<Integer> preorder(TreeNode root){
        if (root ==null){
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        list.add(root.val);
        if (root.left != null){
            preorder(root.left);
        }
        if (root.right != null){preorder(root.right);}
        return list;
    }
    public static List<Integer> indOrder(TreeNode root){
        if (root ==null){
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        if (root.left != null){
            indOrder(root.left);
        }
        list.add(root.val);

        if (root.right != null){
            indOrder(root.right);
        }
        return list;
    }*/

    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * @param pushA
     * @param popA
     * @return
     */
   public static boolean IsPopOrder(int[] pushA, int[] popA) {
       //辅助栈
       int [] temp=new int[pushA.length];
       boolean flag=false;
       if(pushA.length!=popA.length){
           return flag;
       }
       int t=0;
       int j=0;
       for(int i=0;i<pushA.length;i++){
           temp[t]=pushA[i];
           t++;
           while (temp[t-1]==popA[j]){
               t--;
               j++;
               if(j==popA.length){
                   flag=true;
                   return flag;
               }
           }
       }
       return flag;
   }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //层序遍历
        ArrayList<Integer> listVal=new ArrayList<Integer>();
        boolean flag=true;
        int i=0;
        int count=0;
        ArrayList<TreeNode> listNode=new ArrayList<TreeNode>();//用于保存当前节点的左右子节点
        if(root !=null){
            listNode.add(root);
            while(flag){
                if(root.left !=null){
                    //添加左子树
                    listNode.add(root.left );
                    count++;
                }
                if(root.right !=null){
                    //添加右子树
                    listNode.add(root.right);
                    count++;
                }
                if(i<count){
                    i++;
                    root=listNode.get(i);//准备添加下一个节点的左右子节点
                }else{
                    flag=false;
                }
            }
        }
        for(int j=0;j<listNode.size();j++){
            listVal.add(listNode.get(j).val);
        }
        return listVal;
    }

    /**
     * 判断输入的字符是否是复合格式的字符串：检查给定字符串是否为有效的字符串文本
     * @param input
     */
    public static void IsString(String input){
        if(input.length()<2){
            System.out.println("false");
        }else if(input.charAt(1)=='"'){
            System.out.println("false");
        }else if(input.charAt(2)=='\\'){
            System.out.println("false");
        }else if(input.charAt(1)=='\\'){
            System.out.println("true");
        }
        else if(input.charAt(input.length()-2)=='"'){
            System.out.println("false");
        }
        else if(input.charAt(0)=='"' && input.charAt(input.length()-1)=='"'){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    /**
     * 求出整数中1出现的次数
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        if(n<=0){
            return count;
        }
        for(int i=1;i<=n;i*=10){  //i代表位数
            int high=n/(i*10); //更高位数字
            int low=(n%i);  //更低位数字
            int cur=(n/i)%10;  //当前位数字
            if(cur==0){
                count+=high*i;
            }else if(cur==1){
                count+=high*i+(low+1);
            }else{
                count+=(high+1)*i;
            }
        }
        return count;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
