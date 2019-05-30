package com.wangkang.entity;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 9:05 2019/4/16
 * @Modified By:
 */
public class Node {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Node() {
    }
}
