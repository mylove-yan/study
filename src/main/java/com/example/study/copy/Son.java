/*******************************************************************************
 * @(#)Son.java 2020/5/21
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.copy;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/5/21 8:38
 */
public class Son extends Father {
    private Life life;

    public static void main(String[] args) {
        Father cuishan = new Father();
        cuishan.setFace("handsome");
        cuishan.setHeight("180");
        Life cuishanLife = new Life();
        cuishanLife.setStatus("alive");
        cuishan.setLife(cuishanLife);
        Son wuji = new Son();
        BeanUtils.copyProperties(cuishan, wuji);
        //case1
//        Life wujiLife = wuji.getLife();
//        wujiLife.setStatus("alive");
//        wuji.setLife(wujiLife);
//        cuishanLife.setStatus("dead"); // 翠山后来自刎了
        //case2
//        cuishanLife.setStatus("dead"); // 翠山后来自刎了
//        Life wujiLife = wuji.getLife();
//        wujiLife.setStatus("alive");
//        wuji.setLife(wujiLife);
        //case3
        cuishanLife.setStatus("dead"); // 翠山自刎了  该行放在上下均可
        // 无忌用个新对象 不受翠山影响了
        Life wujiLife = new Life();
        wujiLife.setStatus("alive");
        wuji.setLife(wujiLife);

        System.out.println(JSON.toJSONString(cuishan));
        System.out.println(JSON.toJSONString(wuji));
    }
}
