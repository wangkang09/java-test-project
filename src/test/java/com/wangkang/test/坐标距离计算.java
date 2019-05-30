package com.wangkang.test;

import com.wangkang.Util.MyMath;
import org.junit.Test;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:18 2019/3/19
 * @Modified By:
 */
public class 坐标距离计算 {

    @Test
    public void 二维坐标距离计算() {
        double x1 = 147.313;
        double y1 = 280.892;
        double x2 = 147.103;
        double y2 = 207.362;

        System.out.println(MyMath.distance(x1,y1,x2,y2));

    }

    @Test
    public void 两数相乘() {
        double x1 = 0.105;
        double y1 = 36.9800;
        System.out.println(x1*y1);
        y1 = 70.8600;
        System.out.println(x1*y1);
        y1 = 68.2950;
        System.out.println(x1*y1);
        y1 = 73.5303;
        System.out.println(x1*y1);

    }

    @Test
    public void test误差() {

        double x1 = 3.7994;
        double x2 = 3.8092;
        System.out.println(相对误差(x1,x2));
        x1 = 4.1823;
        x2 = 4.1917;
        System.out.println(相对误差(x1,x2));
        x1 = 3.8829;
        x2 = 3.8751;
        System.out.println(相对误差(x1,x2));
        x1 = 7.3811;
        x2 = 7.4415;
        System.out.println(相对误差(x1,x2));
        x1 = 7.2610;
        x2 = 7.1584;
        System.out.println(相对误差(x1,x2));
        x1 = 7.7817;
        x2 = 7.7315;
        System.out.println(相对误差(x1,x2));

    }
    public double 相对误差(double x1,double x2) {
        return 100*(x1-x2)/x2;
    }
    @Test
    public void 四个数相乘() {
        double a = -6;
        double b = 2;
        double c = 5;
        double d = 125;

        double aa = 2;
        double bb = 57;
        double cc = 15;
        double dd = 125;

        double shan = MyMath.四个数相乘(a,b,c,d)+ MyMath.四个数相乘(aa,bb,cc,dd);
        System.out.println(shan);

        double aaa = 5;
        double bbb = 125;
        double ccc = 15;
        double ddd = 125;

        double xia = MyMath.四个数相乘(aaa,bbb,ccc,ddd);
        System.out.println(xia);
        double result = shan/xia;
        System.out.println(result);

    }
}
