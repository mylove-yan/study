/*******************************************************************************
 * @(#)CheckPerson.java 2020/6/5
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.lambda;

/**
 * 筛选会员的条件
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/5 16:24
 */
public interface CheckPerson {
    boolean test(Person p);
}
