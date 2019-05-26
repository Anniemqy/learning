package com.hiveview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
//        Boolean res = TestController.validBrackets("()");
//        System.out.println(res);

        // 有效的括号

        // 合并两个有序链表 todo
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;

        ListNode list5 = new ListNode(2);
        ListNode list6 = new ListNode(7);
        ListNode list7 = new ListNode(8);
        list5.next = list6;
        list6.next = list7;
        ListNode res = TestController.mergeTwoLists(list1, list5);
        print(res);

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

    private static void print(ListNode res) {
        ListNode temp = res;
        while (temp != null && temp.val != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    private static class ListNode {
        public Integer val;
        public ListNode next;
        public ListNode prev;

        public ListNode(Integer val) {
            this.val = val;
        }
    }

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
