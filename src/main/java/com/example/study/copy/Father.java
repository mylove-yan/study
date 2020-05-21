/*******************************************************************************
 * @(#)Father.java 2020/5/21
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.copy;

import lombok.Data;

/**
 * 父类
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/5/21 8:37
 */
@Data
public class Father {
    private String face; // 长相
    private String height; // 身高
    private Life life; // 生命
}
