package com.hiveview.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.image.ImageWatched;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: xiaomeng
 * Date: 2019-04-25
 * Time: 18:09
 */

@Controller
@RequestMapping("/test")
public class TestController {

    public static void main(String[] args) {
        // 两数相加
//        int[] nums = {1, 2, 4, 7, 8};
//        int [] result = TestController.twoSum(nums, 8);
//        System.out.println(Arrays.toString(result));

        // 整数反转 Integer.MAX_VALUE = 2147483647, Integer.MAX_VALUE = -2147483648
//        int reserseNum = TestController.reverseNum(12);
//        System.out.println(reserseNum);

        // 回文数
//        Boolean res = TestController.huiWen(101);
//        System.out.println(res);

        // 罗马数字转整数
//        Integer res = TestController.luomaToNum("MCMXCIV");
//        System.out.println(res);

        // 有效的括号

        // 有效的括号
//        Boolean res = TestController.validBrackets("()");
//        System.out.println(res);

        // 有效的括号

        // 合并两个有序链表 todo
//        LinkedList<Integer> list1 = new LinkedList<Integer>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(4);
//        LinkedList<Integer> list2 = new LinkedList<Integer>();
//        list2.add(1);
//        list2.add(3);
//        list2.add(4);
//        System.out.println(list1);
//        System.out.println(list2);
//        System.exit(0);
//        LinkedList res = TestController.mergeTwoLists(list1, list2);

        // 删除排序数组中的重复项
//        int[] nums = {0, 0, 1, 2, 2, 3, 3, 4, 4, 5, 5, 7, 7};
//        Integer res = TestController.removeRepeat(nums);
//        System.out.println(res);

        // 最长公共前缀
//        String[] strs = {"flower","flow","flight"};
//        String result = TestController.longestPublicPrefix(strs);
//        System.out.println(result);

        // 实现strStr，第二个字符串在第一个字符串中首次出现的位置
//        Integer result = TestController.strStr("abcbcd", "bcd");
//        System.out.println(result);

        // 实现strStr，第二个字符串在第一个字符串中首次出现的位置
        String result = TestController.countAndSay(8);
        System.out.println(result);
    }

    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }

    // 实现strStr，第二个字符串在第一个字符串中首次出现的位置
    public static Integer strStr(String str1, String str2){
        int str1Len = str1.length();
        int str2Len = str2.length();
        if(str1Len < str2Len) return -1;
        if(str2Len == 0) return 0;
        for (int i = 0; i < str1Len - str2Len + 1; i++) {
            if(str1.substring(i, i+str2Len).equals(str2)) return i;
        }
        return -1;
    }

    // 最长公共前缀
    public static String longestPublicPrefix(String[] strs){
        int len = strs.length;
        if(strs == null || len == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // 删除排序数组中的重复项
    public static int removeRepeat(int[] nums){
        int len = nums.length;
        if(len == 0) return 0;
        int num = 0;
        for (int j = 1; j < len; j++) {
            if(nums[j] != nums[j-1]){
                num++;
            }
        }
        return num + 1;
    }

//    public static LinkedList mergeTwoLists(LinkedList l1, LinkedList l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy;
//        while (l1 != null && l2 != null){
//            if (l1.val < l2.val){
//                p.next = l1;
//                l1 = l1.next;
//            }
//            else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//        if (l1 == null) p.next = l2;
//        if (l2 == null) p.next = l1;
//        return dummy.next;
//    }

    // 有效的括号
    public static Boolean validBrackets(String str){
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<Character>();

        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            char topElement = stack.empty() ? '#' : stack.pop();
            if (map.containsKey(c)) {
                if(map.get(c) != topElement){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // 罗马数字转整数
    public static int luomaToNum(String str){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sumNum = 0;
        int len = str.length();
        int currentNum, nextNum = 0, nextKey;
        for (int i = 0; i < len; i++){
            if(map.containsKey(str.charAt(i))){
                currentNum = map.get(str.charAt(i));
                nextKey = i + 1;
                if(nextKey < len){
                    nextNum = map.get(str.charAt(nextKey));
                }
                if(currentNum < nextNum){
                    sumNum -= currentNum;
                }else{
                    sumNum += currentNum;
                }
            }
        }
        return sumNum;
    }

    // 回文数
    public static Boolean huiWen(int num){
        int reverseNum = 0;

        if(num < 0 || (num % 10 == 0  && num != 0)) return false;
        while (num > reverseNum){
            num /= 10;

            reverseNum = reverseNum * 10 + num % 10;
        }
        return num == reverseNum || (num / 10 == reverseNum);
    }

    // 整数反转
    public static int reverseNum(int num){
        int reverseNum = 0;

        while (num != 0){
            int yushu = num % 10;
            num /= 10;

            if(reverseNum > Integer.MAX_VALUE / 10 || (reverseNum == Integer.MAX_VALUE / 10 && yushu > 7)) return 0;
            if(reverseNum < Integer.MIN_VALUE / 10 || (reverseNum == Integer.MIN_VALUE / 10 && yushu < -8)) return 0;

            reverseNum = reverseNum * 10 + yushu;
        }
        return reverseNum;
    }

    // 两数相加
    public static int [] twoSum(int [] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int otherNum = target - nums[i];
            if(map.containsKey(otherNum) && map.get(otherNum) != i){
                return new int [] {map.get(otherNum), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
