package com.wangkang.test.克隆测试;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 11:09 2019/5/30
 * @Modified By:
 */
public class WorkExperience implements Cloneable,Serializable {
    private String timeAArea;
    private String company;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public WorkExperience(String timeAArea, String company) {
        this.timeAArea = timeAArea;
        this.company = company;
    }

    public WorkExperience() {
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "timeAArea='" + timeAArea + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public String getTimeAArea() {
        return timeAArea;
    }

    public void setTimeAArea(String timeAArea) {
        this.timeAArea = timeAArea;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
