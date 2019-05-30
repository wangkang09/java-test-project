package com.wangkang.test.杂;

import com.wangkang.Util.MyMath;
import com.wangkang.entity.Node;
import org.junit.Test;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:01 2019/4/16
 * @Modified By:
 */
public class 电缆护套厚度计算 {

    @Test
    public void test() {

        Node nei = new Node(195,103);
        Node wai = new Node(249,57);
        System.out.println(MyMath.distance(nei.getX(),nei.getY(),wai.getX(),wai.getY())*0.116);
        double zuizhi = getZuizhi(nei,wai);

        double x0 =  -1.0878;
        double y0 = 1.0667;
        double x1 = -0.1809;
        double y1 = 0.1786;

        nei.setX(nei.getX()+x0);
        nei.setY(nei.getY()+y0);
        wai.setX(wai.getX()+x1);
        wai.setY(wai.getY()+y1);

        double now = MyMath.distance(nei.getX(),nei.getY(),wai.getX(),wai.getY());
        double a0 = zuizhi+0.06;
        double a1 = zuizhi+0.05;

        double b0 = zuizhi-0.08;
        double b1 = zuizhi-0.04;

        double c0 = zuizhi-0.08;
        double c1 = zuizhi-0.04;
        //if (now>=c0&&now<=c1) {
            System.out.println(nei.getX());
            System.out.println(nei.getY());
            System.out.println(wai.getX());
            System.out.println(wai.getY());
            System.out.println("实际："+zuizhi*0.116);
            System.out.println(now*0.116);
            System.out.println(now);
        //}

    }

    //D为内x-1.2,y+1.2,外x-0.23,y+0.23
    //E为内x+1.7,外x-0.21
    //F为内y-1.7,外y+0.18
    private double getZuizhi(Node nei, Node wai) {
        double a = MyMath.distance(nei.getX()-1.2,nei.getY()+1.2,wai.getX()-0.23,wai.getY()+0.23);
        return a;
    }

    @Test
    public void test0() {
        double a = 4.1582;
        double b = 4.524;
        double c = 4.292;
        double d = 8.2286;
        double e = 7.888;
        double f = 8.584;

        double[] real = {4.0505,4.5820,4.2953,8.3873,7.7152,8.8021};

        System.out.println(a-real[0]);
        System.out.println(b-real[1]);
        System.out.println(c-real[2]);
        System.out.println(d-real[3]);
        System.out.println(e-real[4]);
        System.out.println(f-real[5]);


    }

    @Test
    public void test1() {
        double a = 8.7871;
        double b = 8.8021;

        System.out.println(a-b);
    }

}
/*
    //Zernike A
    double x0 = -0.1475;
    double y0 = 0.1412;
    double x1 = 0.1267;
    double y1 = -0.1246;


        double a = 4.0574;
        double b = 4.5765;
        double c = 4.2956;
        double d = 8.3580;
        double e = 7.7373;
        double f = 8.7515;

        double a = 4.0631;
        double b = 4.5707;
        double c = 4.2949;
        double d = 8.3447;
        double e = 7.7444;
        double f = 8.7618;

        double a = 4.06;
        double b = 4.5712;
        double c = 4.2964;
        double d = 8.3297;
        double e = 7.7569;
        double f = 8.7492;
                double a = 4.0605;
        double b = 4.5742;
        double c = 4.2966;
        double d = 8.3698;
        double e = 7.7322;
        double f = 8.7751;
*/
