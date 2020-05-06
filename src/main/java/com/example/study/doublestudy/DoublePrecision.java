/*******************************************************************************
 * @(#)DoublePrecision.java 2020/5/6
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.doublestudy;

import java.math.BigDecimal;

/**
 * double 精度问题
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/5/6 12:55
 */
public class DoublePrecision {

    public static void main(String[] args) {
        double number1 = 1;
        double number2 = 20.2;
        double number3 = 300.03;
        double result = number1 + number2 + number3;
        System.out.println(result);
        double result1 = addDouble(1, 20.2);
        double result2 = addDouble(result1, 300.03);
        System.out.println("使用BigDecimal时结果值：" + result2);
    }

    /**
     * 加法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double addDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.add(p2).doubleValue();
    }

    /**
     * 减法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double subDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

    /**
     * 乘法运算
     *
     * @param m1
     * @param m2
     * @return
     */
    public static double mul(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.multiply(p2).doubleValue();
    }


    /**
     * 除法运算
     *
     * @param m1
     * @param m2
     * @param scale
     * @return
     */
    public static double div(double m1, double m2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
