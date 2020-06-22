/*******************************************************************************
 * @(#)SentryTest.java 2020/6/17
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.example.study.algorithm;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/6/17 8:51
 */
public class SentryTest {

    public static void main(String[] args) {

    }

    public static int find(String[] a,int n,String key){
        if(a == null || n<=0){
            return -1;
        }
        int i = 0;
        while(i < n){
            if(a[i]==key){
                return i;
            }
            ++i;
        }
        return -1;
    }

    public static int findSentry(String[] a,int n,String key){
        if(a == null || n<=0){
            return -1;
        }
        if(a[n-1]==key){
            return n-1;
        }
        String tmp = a[n-1];
        a[n-1] = key;
        int i = 0;
        while(a[i]!=key){
            ++i;
        }
        a[n-1] = tmp;
        if(i == n-1){
            return -1;
        }else{
            return i;
        }

    }

}
