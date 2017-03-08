package com.qingguo.tools;

/**
 * Created by wangquan on 2017/1/2.
 */

public class serialNumber {

    private static String serialnumbertoString(int number){
        String str="";
        switch (number){
            case 1:
                str="水相1#溶解罐液位";
            case 2:
                str="水相1#溶解罐温度";
            case 3:
                str="水相2#储存罐液位";
            case 4:
                str="水相2#储存罐温度";
            case 5:
                str="水相3#溶解罐液位";
            case 6:
                str="水相3#溶解罐温度";
            case 7:
                str="水相4#储存罐液位";
            case 8:
                str="水相4#储存罐温度";
            case 9:
                str="水相5#储存罐液位";
            case 10:
                str="水相5#储存罐温度";
            case 11:
                str="水相热水罐液位";
            case 12:
                str="水相热水罐温度";
            case 13:
                str="油相柴油罐液位";
            case 14:
                str="油相机油罐液位";
            case 15:
                str="油相机油罐温度";
            case 16:
                str="油相1#乳化剂罐液位";
            case 17:
                str="油相1#乳化剂罐温度";
            case 18:
                str="油相2#乳化剂罐液位";
            case 19:
                str="油相2#乳化剂罐温度";
            case 20:
                str="油相1#制备罐液位";
            case 21:
                str="油相1#制备罐温度";
            case 22:
                str="油相2#储存罐液位";
            case 23:
                str="油相2#储存罐温度";
            case 24:
                str="15#炸药车水相罐液位";
            case 25:
                str="15#炸药车水相罐温度";
        }
        return str;
    }


    public static StringBuilder serialnumbertoList(String str) {
        StringBuilder serialnumber=new StringBuilder();
        String[] ary = str.split("\\|");
        for (int i = 0; i < ary.length; i++) {
            ary[i] = ary[i].replaceAll("C", ",当前数值：");
            ary[i] = ary[i].replaceAll("S", ",警报设置值：");
            ary[i] = ary[i].replaceAll("c", "°C");

            ary[i] = ary[i].replaceFirst(ary[i].substring(0, 2), serialNumber.serialnumbertoString(Integer.parseInt(ary[i].substring(0, 2))));
            serialnumber.append(ary[i]+"\n");
        }
        return serialnumber;
    }


}
