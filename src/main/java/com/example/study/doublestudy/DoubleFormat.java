/*******************************************************************************
 * @(#)DoubleFormat.java 2020/5/6
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.doublestudy;

import java.text.DecimalFormat;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/5/6 13:23
 */
public class DoubleFormat {
    public static void main(String[] args) {
        double num=13.154215;
        DecimalFormat df1 = new DecimalFormat("0.00");
        String str = df1.format(num);
        // #.00 表示两位小数 #.0000四位小数
        DecimalFormat df2 =new DecimalFormat("#.00");
        String str2 =df2.format(num);
        //%.2f %. 表示 小数点前任意位数 2 表示两位小数 格式后的结果为f 表示浮点型
        String result = String.format("%.2f", num);
        System.out.println(result);
    }

}


