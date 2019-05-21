package com.hiveview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

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
//        Integer res = TestController.validBrackets("MCMXCIV");
//        System.out.println(res);
    }

//    public static int validBrackets(String str){
//
//    }

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
