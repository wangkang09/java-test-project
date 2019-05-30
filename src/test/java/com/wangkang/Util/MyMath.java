package com.wangkang.Util;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:20 2019/3/19
 * @Modified By:
 */
public class MyMath {

    /**
     *
     * @Description: 计算两个坐标点的距离
     * 
     * @auther: wangkang
     * @date: 16:23 2019/3/19
     * @param: [x1, y1, x2, y2]
     * @return: double
     *
     */
    public static double distance(double x1,double y1,double x2,double y2) {

        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    public static double 四个数相乘(double a,double b,double c,double d) {
        return a*b*c*d;
    }
}
